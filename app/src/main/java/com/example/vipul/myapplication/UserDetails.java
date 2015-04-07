package com.example.vipul.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by vipul on 3/4/15.
 */
public class UserDetails extends Fragment{
    EditText name;
    EditText rollnumber;
    EditText tenth;
    EditText cgpa;
    EditText twelfth;
    EditText backlog;
    Button submit_button;
    VipulDatabaseAdapter vipulHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user_details, container, false);
        vipulHelper = new VipulDatabaseAdapter(getActivity().getApplicationContext());
        name= (EditText) v.findViewById(R.id.name);
        rollnumber= (EditText) v.findViewById(R.id.rollnumber);
        cgpa = (EditText) v.findViewById(R.id.cgpa);
        tenth= (EditText) v.findViewById(R.id.tenthmarks);
        twelfth= (EditText) v.findViewById(R.id.twelfthmarks);
        backlog=(EditText) v.findViewById(R.id.backlogs);
        submit_button = (Button) v.findViewById(R.id.save);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String rollnumber1 = rollnumber.getText().toString();
                String cgpa1 =  cgpa.getText().toString();
                String tenth1 = tenth.getText().toString();
                String twelfth1 = twelfth.getText().toString();
                String backlog1 = backlog.getText().toString();
                long id;
                id = vipulHelper.insertData(name1,rollnumber1,cgpa1,twelfth1,tenth1,backlog1);
                if(id<0)
                    Message.message(getActivity(),"Unsuccessful");
                else
                    Message.message(getActivity(),"Successfully inserted data");
            }
        });
        return v;
    }

}
