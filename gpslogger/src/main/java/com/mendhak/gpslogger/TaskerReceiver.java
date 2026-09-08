package com.mendhak.gpslogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;

import com.mendhak.gpslogger.common.slf4j.Logs;

import org.slf4j.Logger;

public class TaskerReceiver extends BroadcastReceiver {

    private static final Logger LOG = Logs.of(TaskerReceiver.class);
    @Override
    public void onReceive(Context context, Intent intent) {
        LOG.info("Tasker Command Received");

        //CWE-400
        //SOURCE
        int startupDelaySeconds = intent.getIntExtra("com.mendhak.gpslogger.STARTUP_DELAY_SECONDS", 0);
        if (startupDelaySeconds > 0) {
            com.mendhak.gpslogger.common.Systems.pauseBeforeStart(startupDelaySeconds);
        }

        Intent serviceIntent = new Intent(context, GpsLoggingService.class);
        serviceIntent.putExtras(intent);
        ContextCompat.startForegroundService(context, serviceIntent);
    }
}
