package com.example.vipul.myapplication.slidelist;

/**
 * Created by vipul on 26/3/15.
 */
import com.example.vipul.myapplication.FetchCompany;
import com.example.vipul.myapplication.Message;
import com.example.vipul.myapplication.R;
import com.example.vipul.myapplication.VipulDatabaseAdapter;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint("NewApi") public class Mock_Fragment extends Fragment{
    EditText name;
    EditText rollnumber;
    EditText tenth;
    EditText cgpa;
    EditText twelfth;
    EditText backlog;
    Button submit_button;
    VipulDatabaseAdapter vipulHelper;
    ArrayList arrayList;
    Iterator itr;
    InputStream is = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user_details, container, false);
        vipulHelper = new VipulDatabaseAdapter(getActivity().getApplicationContext());
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        name= (EditText) v.findViewById(R.id.name);
        rollnumber= (EditText) v.findViewById(R.id.rollnumber);
        cgpa = (EditText) v.findViewById(R.id.cgpa);
        tenth= (EditText) v.findViewById(R.id.tenthmarks);
        twelfth= (EditText) v.findViewById(R.id.twelfthmarks);
        backlog=(EditText) v.findViewById(R.id.backlogs);
        submit_button = (Button) v.findViewById(R.id.save);
        arrayList = vipulHelper.getData();
        itr = arrayList.iterator();
        if(!arrayList.isEmpty()) {
            name.setText((String)arrayList.get(0));
            rollnumber.setText((String)arrayList.get(1));
            cgpa.setText((String)arrayList.get(2));
            twelfth.setText((String)arrayList.get(3));
            tenth.setText((String)arrayList.get(4));
            backlog.setText((String)arrayList.get(5));
        }
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String rollnumber1 = rollnumber.getText().toString();
                String cgpa1 =  cgpa.getText().toString();
                String tenth1 = tenth.getText().toString();
                String twelfth1 = twelfth.getText().toString();
                String backlog1 = backlog.getText().toString();
                String tid = rollnumber1;
                Message.message(getActivity(),"Button clicked");
                //vipulHelper.checkdb();
               // long id;
                //id = vipulHelper.insertData(name1,rollnumber1,cgpa1,twelfth1,tenth1,backlog1);
               // if(id<0)
               //     Message.message(getActivity(), "Unsuccessful");
               // else
               //     Message.message(getActivity(), "Successfully inserted data");

                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>(1);
                nameValuePairList.add(new BasicNameValuePair("tid",rollnumber1));
                nameValuePairList.add(new BasicNameValuePair("name",name1));
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://www.tuplacements.co.nf/insert_to_teachersxxx.php");
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                HttpResponse response = null;
                try {
                    response = httpClient.execute(httpPost);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HttpEntity entity = response.getEntity();
                try {
                    is= entity.getContent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Message.message(getActivity(),"Success");
            }
        });

        return v;
    }


}
