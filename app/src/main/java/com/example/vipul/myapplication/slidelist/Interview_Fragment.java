package com.example.vipul.myapplication.slidelist;

/**
 * Created by vipul on 26/3/15.
 */
import com.example.vipul.myapplication.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

@SuppressLint("NewApi") public class Interview_Fragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.interview_fragment, container, false);

        return rootView;
    }
}

