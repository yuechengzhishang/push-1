package com.vidolion.app.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DaemonReceiver extends BroadcastReceiver {

    private final static String TAG = "DaemonReceiver";

    public DaemonReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        Intent mIntent = new Intent();
        mIntent.setClass( context , DaemonService.class );
        context.startService( mIntent );
    }
}
