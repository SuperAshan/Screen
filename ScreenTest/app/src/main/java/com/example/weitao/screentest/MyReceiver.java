package com.example.weitao.screentest;

/**
 * Created by weitao on 2016/3/11.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/*
 * A simple demo of receiving custom intents.
 * action1 is registered statically in the manifest file and action2 is dynamically registered
 * in the mainActivity code.
 *
 * The variables ACTION1 and ACTION2 are declared in the MainActivity as well.
 */

public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Received an intent.", Toast.LENGTH_SHORT).show();

        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            MainActivity.openscreentimes++;
        } else if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            MainActivity.closescreentime++;
        } else if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Toast.makeText(context, "Test Screen.", Toast.LENGTH_SHORT).show();
        }
    }
}