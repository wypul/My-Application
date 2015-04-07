package com.example.vipul.myapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ShowCompany extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_company);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_company, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_show_company, container, false);
            return rootView;
        }
    }


    public void setTextToTextView(JSONArray jsonArray) {
        TextView responseTextView;
        String s = "";
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);
                s = s +
                        "Name : " + json.getString("FirstName") + " " + json.getString("LastName") + "\n" +
                        "Age : " + json.getInt("Age") + "\n" +
                        "Mobile Using : " + json.getString("Mobile") + "\n\n";
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        responseTextView = (TextView) findViewById(R.id.responseTextView);

        responseTextView.setText(s);

    }

    public class GetAllCustomerTask extends AsyncTask<FetchCompany, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(FetchCompany... params) {

            // it is executed on Background thread

            return params[0].GetCompanies();
        }


        @Override
        public void onPostExecute(JSONArray jsonArray) {

            setTextToTextView(jsonArray);


        }
    }
}