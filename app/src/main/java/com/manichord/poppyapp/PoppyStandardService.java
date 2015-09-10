package com.manichord.poppyapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PoppyStandardService extends Service {
    public PoppyStandardService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do our stuff...in a NEW thread
                PiCalculator.compute();
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
