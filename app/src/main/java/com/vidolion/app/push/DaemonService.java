package com.vidolion.app.push;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class DaemonService extends Service {
    public DaemonService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "DaemonService onCreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "DaemonService onStart");

        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "DaemonService onStartCommand");
        flags = START_STICKY;
        handler.postDelayed(runnable,1000);         // 开始Timer
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "DaemonService onDestroy");
        super.onDestroy();
        Intent intent = new Intent("com.vidolion.app.push.DaemonService");
        sendBroadcast(intent);
        handler.removeCallbacks(runnable);           //停止Timer
    }

    private final static String TAG = "DaemonService";

    private final static int SECOND = 1000;

    private Handler handler = new Handler( );

    private Runnable runnable = new Runnable( ) {

        public void run ( ) {

            Toast.makeText(DaemonService.this , "DaemonService beep " + System.currentTimeMillis() , Toast.LENGTH_SHORT ).show();

            handler.postDelayed(this, SECOND * 2 );     //postDelayed(this,1000)方法安排一个Runnable对象到主线程队列中

        }

    };
}
