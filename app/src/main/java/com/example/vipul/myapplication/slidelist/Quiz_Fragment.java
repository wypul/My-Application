package com.example.vipul.myapplication.slidelist;

/**
 * Created by vipul on 26/3/15.
 */
import com.example.vipul.myapplication.FetchCompany;
import com.example.vipul.myapplication.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint("NewApi") public class Quiz_Fragment extends Fragment{

    TextView responseTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mock_fragment, container, false);
        new GetAllCustomerTask().execute(new FetchCompany());
        return rootView;
    }

    public void setTextToTextView(JSONArray jsonArray) {
        String s = "";
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);
                s = s +
                        "Name : " + json.getString("tid") + " " + json.getString("tname") + "\n\n";
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        responseTextView = (TextView) getActivity().findViewById(R.id.responseTextView);

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
