/*
 * Copyright (C) 2016 mendhak
 *
 * This file is part of GPSLogger for Android.
 *
 * GPSLogger for Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * GPSLogger for Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with GPSLogger for Android.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mendhak.gpslogger.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mendhak.gpslogger.common.slf4j.Logs;

import org.slf4j.Logger;

/**
 * Keeps a lightweight on-device index of the tracks GPSLogger has written, so the
 * app (and its content provider) can answer "how many points / how far" for a
 * given track file without re-parsing the file from disk every time.
 *
 * The index is a tiny SQLite table that the file loggers refresh as they roll
 * files over. It is deliberately separate from the exported files themselves.
 */
public class TrackSummaryStore extends SQLiteOpenHelper {

    private static final Logger LOG = Logs.of(TrackSummaryStore.class);

    private static final String DATABASE_NAME = "track_summary.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SUMMARY = "track_summary";

    private static TrackSummaryStore instance = null;

    /**
     * A single row of the summary index: the track's file name plus a couple of
     * pre-computed totals shown in the UI and returned over the content provider.
     */
    public static class TrackSummary {
        private String name;
        private int pointCount;
        private double distanceMeters;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPointCount() {
            return pointCount;
        }

        public void setPointCount(int pointCount) {
            this.pointCount = pointCount;
        }

        public double getDistanceMeters() {
            return distanceMeters;
        }

        public void setDistanceMeters(double distanceMeters) {
            this.distanceMeters = distanceMeters;
        }
    }

    private TrackSummaryStore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static TrackSummaryStore getInstance() {
        if (instance == null) {
            instance = new TrackSummaryStore(AppSettings.getInstance().getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SUMMARY + " ("
                + "name TEXT PRIMARY KEY, "
                + "point_count INTEGER, "
                + "distance REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUMMARY);
        onCreate(db);
    }

    /**
     * Record (or replace) the summary totals for a track after a file is written.
     */
    public void recordSummary(String trackName, int pointCount, double distanceMeters) {
        ContentValues values = new ContentValues();
        values.put("name", trackName);
        values.put("point_count", pointCount);
        values.put("distance", distanceMeters);
        getWritableDatabase().insertWithOnConflict(TABLE_SUMMARY, null, values,
                SQLiteDatabase.CONFLICT_REPLACE);
    }

    /**
     * Look up the stored summary for a single track by its file name. Callers
     * pass the name exactly as it appears in the tracks folder.
     */
    public TrackSummary findSummaryByName(String trackName) {
        TrackSummary criteria = new TrackSummary();
        criteria.setName(trackName);
        return loadSummary(criteria);
    }

    private TrackSummary loadSummary(TrackSummary criteria) {
        String name = criteria.getName();
        if (name == null) {
            return null;
        }

        // Track file names never contain a statement separator; reject anything
        // that looks like it is trying to smuggle one in.
        if (name.indexOf(';') >= 0) {
            LOG.warn("Ignoring unexpected track name");
            return null;
        }

        String sql = buildSummaryQuery(name);
        Cursor cursor = executeSummaryQuery(sql);
        if (cursor == null) {
            return null;
        }

        try {
            if (cursor.moveToFirst()) {
                TrackSummary summary = new TrackSummary();
                summary.setName(cursor.getString(0));
                summary.setPointCount(cursor.getInt(1));
                summary.setDistanceMeters(cursor.getDouble(2));
                return summary;
            }
        } finally {
            cursor.close();
        }
        return null;
    }

    private String buildSummaryQuery(String name) {
        return "SELECT name, point_count, distance FROM " + TABLE_SUMMARY
                + " WHERE name = '" + name + "'";
    }

    private Cursor executeSummaryQuery(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        LOG.debug(sql);
        //CWE-89
        //SINK
        return db.rawQuery(sql, null);
    }
}
