package com.militarypt.militarypt;

import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Exam extends AppCompatActivity {
    public static String branch ;
    public static String age ;
    public static String gender ;


    public static Button btnS;


    public static String push ;
    public static String sit;
    public static String run ;
    public static String pushS ;
    public static String sitS;
    public static String runS ;
    public static String score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        final Button btnR = (Button)findViewById(R.id.run);
        final  Button btnP = (Button)findViewById(R.id.push);
        final  Button btnS = (Button)findViewById(R.id.situps);
        final Button butSc = (Button) findViewById(R.id.butScore);

        btnS.setEnabled(false);
        btnR.setEnabled(false);
        butSc.setEnabled(false);

        SharedPreferences preferences = getSharedPreferences("userInfo", MODE_PRIVATE);
         branch = preferences.getString("branch"," ");
         age = preferences.getString("age"," ");
         gender = preferences.getString("gender"," ");






        btnP.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                Pushups test = new Pushups();
                trans.replace(R.id.examFrame,test);
                trans.commit();
                btnP.setEnabled(false);


        }
        });
        btnS.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                Situps test = new Situps();
                trans.replace(R.id.examFrame,test);
                trans.commit();
                btnS.setEnabled(false);

            }
        });
        btnR.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                btnR.setEnabled(false);


                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                Run test = new Run();
                trans.replace(R.id.examFrame,test);
                trans.commit();
            }
        });
        butSc.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {



                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                FragmentScore test = new FragmentScore();
                trans.replace(R.id.examFrame,test);
                trans.commit();
            }
        });


    }



}
