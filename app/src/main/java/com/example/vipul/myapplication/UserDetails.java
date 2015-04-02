package com.example.vipul.myapplication;
/**
 * Created by shubham on 3/4/15.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class UserDetails extends ActionBarActivity {
    EditText name;
     EditText rollnumber;
     EditText tenth;
     EditText twelth;
     EditText backlog;
    Button submit_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        name= (EditText)findViewById(R.id.name);
        rollnumber= (EditText)findViewById(R.id.rollnumber);
        tenth= (EditText)findViewById(R.id.tenthmarks);
        twelth= (EditText)findViewById(R.id.twelthmarks);
        backlog=(EditText)findViewById(R.id.backlogs);
        submit_button = (Button)findViewById(R.id.button);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
