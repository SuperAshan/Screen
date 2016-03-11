package com.example.weitao.screentest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static int openscreentimes=0;
    public static int closescreentime=0;
    MyReceiver mReceiver;
    String TAG="ScreenTest.MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment()).commit();
        }

        //need to initialize the variable here.
        mReceiver = new MyReceiver();
        final IntentFilter filter = new IntentFilter();
        // 屏幕灭屏广播
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        // 屏幕亮屏广播
        filter.addAction(Intent.ACTION_SCREEN_ON);
        // 屏幕解锁广播
        filter.addAction(Intent.ACTION_USER_PRESENT);
        // 当长按电源键弹出“关机”对话或者锁屏时系统会发出这个广播
        // example：有时候会用到系统对话框，权限可能很高，会覆盖在锁屏界面或者“关机”对话框之上，
        // 所以监听这个广播，当收到时就隐藏自己的对话，如点击pad右下角部分弹出的对话框
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

        registerReceiver(mReceiver,filter);

    }


    @Override
    public void onResume() {
        super.onResume();
        // Register mReceiver to receive messages.
        // the local is not working, I don't know why...  Using general one.
        //LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION2));

//        final IntentFilter filter = new IntentFilter();
//        // 屏幕灭屏广播
//        filter.addAction(Intent.ACTION_SCREEN_OFF);
//        // 屏幕亮屏广播
//        filter.addAction(Intent.ACTION_SCREEN_ON);
//        // 屏幕解锁广播
//        filter.addAction(Intent.ACTION_USER_PRESENT);
//        // 当长按电源键弹出“关机”对话或者锁屏时系统会发出这个广播
//        // example：有时候会用到系统对话框，权限可能很高，会覆盖在锁屏界面或者“关机”对话框之上，
//        // 所以监听这个广播，当收到时就隐藏自己的对话，如点击pad右下角部分弹出的对话框
//        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
//
//        registerReceiver(mReceiver,filter);
        //Log.v(TAG, "receiver should be registered");
    }
    @Override
    protected void onPause() {  //or onDestory()
        // Unregister since the activity is not visible
        //again, local not working,
        //LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        unregisterReceiver(mReceiver);
        Log.v(TAG, "receiver should be unregistered");
        super.onPause();

    }
}
