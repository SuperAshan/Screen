package com.example.weitao.broadcast;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION1 = "edu.cs4730.bcr.mystaticevent";
    public static final String ACTION2 = "edu.cs4730.bcr.mydyanicevent";

    String TAG = "MainActivity";

    MyReceiver mReceiver;

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
    }

    @Override
    public void onResume() {
        super.onResume();
        // Register mReceiver to receive messages.
        // the local is not working, I don't know why...  Using general one.
        //LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION2));

        registerReceiver(mReceiver,  new IntentFilter(ACTION2));
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
