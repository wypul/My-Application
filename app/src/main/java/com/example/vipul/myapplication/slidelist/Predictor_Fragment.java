package com.example.vipul.myapplication.slidelist;

/**
 * Created by vipul on 26/3/15.
 */
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vipul.myapplication.R;


@SuppressLint("NewApi") public class Predictor_Fragment extends Fragment  {
    int cgpa,projects,internships,societies,nontechnical,langsum=0,contests;
    String name,company="A",tobeprinted;
    EditText name1,cgpa1,projects1,internships1,societies1,contests1;
    TextView print;
    Button btn;
    public void onCheckboxClicked(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            langsum++;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.predictor_fragment, container, false);
        btn = (Button)getActivity().findViewById(R.id.submit);
        return rootView;
    }

    public void onClick(View view){
        name1= (EditText)getActivity(). findViewById(R.id.name);
        cgpa1=(EditText)getActivity(). findViewById(R.id.cgpa);
        projects1=(EditText)getActivity().findViewById(R.id.projects);
        internships1=(EditText)getActivity().findViewById(R.id.internships);
        societies1=(EditText)getActivity().findViewById(R.id.societies);
        contests1=(EditText)getActivity().findViewById(R.id.contests);
        name = name1.getText().toString();
        cgpa = Integer.valueOf(cgpa1.getText().toString());
        projects = Integer.valueOf(projects1.getText().toString());
        internships = Integer.valueOf(internships1.getText().toString());
        societies = Integer.valueOf(societies1.getText().toString());
        contests = Integer.valueOf(contests1.getText().toString());
        if(cgpa<=8.04)
        {
            if(cgpa<6.00)
            {
                company="D";
                tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> NON  DREAM  company (package of about 4 - 6 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on. To target a non -technical  dream company from here on you need to increase your participation in non technical societies and events .<br> Also try improve your CGPA.To target a mid range dream company you have to  improve your CGPA .<br> Also you could focus more on projects as an alternative  to join a mid range dream company.To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.";

            }
            else
            {
                if(internships==0)
                {
                    if(projects<=2 && projects>=0)
                    {
                        if(societies==0)
                        {
                            if(cgpa<=7.51)
                            {
                                if(nontechnical<=3)
                                { company="D";
                                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a  NON  DREAM  company (package of about 4 - 6 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a non -technical  dream company from here on you need to increase your participation in non technical societies and events as well. <br> Also try improve your CGPA.To target a mid range dream company you have to work in some technical societies first and also improve your CGPA .<br> Also you could focus more on projects as an alternative to join a mid range dream company .To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills";
                                }
                                else
                                {
                                    company="C";
                                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> non technical DREAM   company (package of about  6  - 8 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on.To be able to perform better in your placement what you need to look out of the following from here on.To target a mid range dream company you have to work in some technical societies first and also improve your CGPA .<br> Also you could focus more on projects as an alternative  to join a mid range dream company.To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.";
                                }
                            }
                            else
                            {company="C";
                                tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   non technical  DREAM company( package of about  6  - 8 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a mid range dream company you have to work in some technical societies first and also improve your CGPA .<br> Also you could focus more on projects as an alternative to move on to join a mid range dream company. To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills ";

                            }
                        }
                        else
                        {
                            if(cgpa<=7.06)
                            {

                                company="D";
                                tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> NON  DREAM  company (package of about 4 - 6 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a non -technical  dream company from here on you need to increase your participation in non technical societies and events as well.<br> Also try improve your CGPA. To target a mid range dream company you have to  improve your CGPA .<br> Also you could focus more on projects as an alternative  to join a mid range dream company .To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.";

                            }
                            else
                            {
                                if(cgpa>7.51)
                                {

                                    company="B";
                                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>  mid range DREAM  company (package of about  6  -  8 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on . To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.";
                                }
                                else
                                {
                                    company="D";
                                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> NON  DREAM  company (package of about 4 - 6 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on . To target a non -technical  dream company from here on you need to increase your participation in non technical societies and events as well .<br> Also  try improve your CGPA. To target a mid range dream company you have to  improve your CGPA .<br> Also you could focus more on projects as an alternative  to join a mid range dream company .To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.";
                                }

                            }


                        }

                    }
                    else
                    {
                        if(nontechnical==0)
                        {
                            company="D";
                            tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> NON  DREAM  company ( package of about 4 - 6 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a non -technical  dream company from here on you need to increase your participation in non technical societies and events as well <br>. Also try improve your CGPA. To target a mid range dream company you have to  improve your CGPA .<br> Also you could focus more on projects as an alternative  to join a mid range dream company . To target a dream company you have to look out for  an internship and improve your CGPA  .<br> You also need to  start participating in coding competitions to improve your coding skills.";
                        }
                        else
                        {
                            company="B";
                            tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> mid range  DREAM  company (package of about  6  - 8  Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a dream company you have to look out on working on more projects .";
                        }
                    }
                }
                else
                {
                    if(contests<=1)
                    {
                        if(langsum<=3)
                        {
                            if(langsum<=1)
                            {
                                if(cgpa<=7.51)
                                {
                                    company="D";
                                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> NON  DREAM  company (package of about 4 - 6 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a non -technical  dream company from here on you need to increase your participation in non technical societies and events  well as try improve your CGPA. To target a mid range dream company you have to  improve your CGPA .<br> Also you could focus more on projects as an alternative to join a mid range dream company . To target a dream company you have to look out for  an internship and improve your CGPA  . <br>You also need to  start participating in coding competitions to improve your coding skills .";
                                }
                                else
                                {
                                    company="A";
                                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   DREAM  company (package of about 9 - 16  Lacs P.A.).To be able to perform the same way in the real interview you go to continue working this way .<br> Try learn some  more languages.";
                                }

                            }
                            else
                            {
                                company="A";
                                tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   DREAM  company ( package of about 9 - 16  Lacs P.A. ).To be able to perform the same way in the real interview you go to continue working this way . Try learn some  more languages  .";

                            }

                        }
                        else
                        {
                            company="A";
                            tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   DREAM  company (package of about 9 - 16  Lacs P.A.).To be able to perform the same way in the real interview you go to continue working this way . Try learn some  more languages  .";

                        }

                    }
                    else
                    {
                        company  =  "A" ;
                        tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   DREAM  company (package of about 9 - 16  Lacs P.A.).To be able to perform the same way in the real interview you go to continue working this way . Try learn some  more languages ";

                    }

                }
            }
        }
        else
        {
            if(internships==0)
            {
                company="B";
                tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> mid range  DREAM  company (package of about 6 -  8 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a dream company you have to look out on getting an internship .";
            }
            else
            {
                if(projects<=1)
                {
                    company="C";
                    tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   non technical  DREAM company (package of about  6  - 8 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on .To target a mid range dream company   you need  to work on more projects.To target a dream company   you need  to work on more projects and also start participating in coding competitions to improve your coding skills.";

                }
                else
                {
                    if(contests<=0)
                    {
                        company="B";
                        tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br> mid range  DREAM  company (package of about  6  - 8 Lacs P.A.).To be able to perform better in your placement what you need to look out of the following from here on.To target a dream company you need to start participating in coding competitions .";

                    }
                    else
                    {
                        company="A";
                        tobeprinted="Presently  your skills and resume  suggest you might be placed in a<br>   DREAM  company ( package  of  about 9 - 16  Lacs P.A.).To be able to perform the same way in the real interview need to  continue working this way . Try learn some  more languages.";

                    }

                }
            }
        }
        print = (TextView)getActivity().findViewById(R.id.display);
        print.setText(tobeprinted);
    }

}


