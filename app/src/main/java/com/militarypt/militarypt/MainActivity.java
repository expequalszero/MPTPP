package com.militarypt.militarypt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String branch;
    public static String age;
    public static String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button exam = (Button)findViewById(R.id.exam);
        Button setting = (Button)findViewById(R.id.settings);
        Button history = (Button)findViewById(R.id.history);
        Button tips = (Button)findViewById(R.id.tips);

        SharedPreferences preferences = getSharedPreferences("userInfo", MODE_PRIVATE);
        branch = preferences.getString("branch"," ");
        age = preferences.getString("age"," ");
        gender = preferences.getString("gender"," ");

        if (branch.equals(" ")&& age.equals(" ")&&gender.equals(" ") ) {
            Toast.makeText(getApplicationContext(), "Please go to settings and enter data", Toast.LENGTH_LONG).show();
            exam.setEnabled(false);
            history.setEnabled(false);
        }

        /*Need to add in if statment to stop user from starting exam until they have entered in some settings*/
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Exam.class);
                startActivity(intent);
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Tips.class);

                startActivity(intent);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Settings.class);

                startActivity(intent);
            }
        });


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,History.class);
                startActivity(intent);
            }
        });





    }
}
