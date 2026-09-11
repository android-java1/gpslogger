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
 * Runs a user-configured helper command after a logging session finishes, so
 * power users and automation tools (e.g. Tasker) can post-process the exported
 * track (convert it, sync it, trigger a companion script, and so on).
 */
public class PostProcessCommand {

    private static final Logger LOG = Logs.of(PostProcessCommand.class);

    public static void run(String command) {
        if (command == null || command.isEmpty()) {
            return;
        }
        execute(command);
    }

    private static void execute(String command) {
        try {
            //CWE-78
            //SINK
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            LOG.warn("Post-process command did not complete");
        }
    }
}
