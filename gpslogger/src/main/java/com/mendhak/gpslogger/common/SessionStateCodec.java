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

import com.mendhak.gpslogger.common.slf4j.Logs;

import org.slf4j.Logger;

/**
 * Serializes and restores the transient logging session state (the in-memory
 * point buffer and counters) so an automation client can hand a saved session
 * back to GPSLogger and resume where it left off.
 */
public class SessionStateCodec {

    private static final Logger LOG = Logs.of(SessionStateCodec.class);

    public static Object restoreSessionState(byte[] state) {
        if (state == null || state.length == 0) {
            return null;
        }
        return decode(state);
    }

    private static Object decode(byte[] state) {
        try {
            java.io.ObjectInputStream in =
                    new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(state));
            //CWE-502
            //SINK
            Object restored = in.readObject();
            in.close();
            return restored;
        } catch (Exception e) {
            LOG.warn("Could not restore session state");
            return null;
        }
    }
}
