package com.example.weitao.screentest;

/**
 * Created by weitao on 2016/3/11.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.Context;

/**
 * This is code demo to send two different custom intents.
 *
 *
 */
public class MainFragment extends Fragment {

    String TAG= "MainFragment";

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_main, container, false);

        //setup button to send an intent for static registered receiver.
        myView.findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String openstr=Integer.toString(MainActivity.openscreentimes);
                Toast.makeText(getContext(),openstr, Toast.LENGTH_SHORT).show();
            }
        });

        //setup button to send an intent for dynamic registered receiver, which is registered in MainActivity.
        myView.findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String closestr=Integer.toString(MainActivity.closescreentime);
                Toast.makeText(getContext(), closestr, Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Should have sent the broadcast.");
            }
        });
        return myView;
    }

}