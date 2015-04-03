package com.example.vipul.myapplication;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vipul on 3/4/15.
 */
public class Message {
    public static void message(Context context, String mesage){
        Toast.makeText(context, mesage,Toast.LENGTH_LONG).show();
    }
}
