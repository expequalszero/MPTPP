package com.militarypt.militarypt;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class History extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        final Button scores =(Button)findViewById(R.id.displayScores);
        final Button push =(Button)findViewById(R.id.displayPush);
        final Button sit =(Button)findViewById(R.id.displaySit);
        final Button run =(Button)findViewById(R.id.displayRun);
        final Button returnM = (Button)findViewById(R.id.historyReturn);
        db = new DatabaseHelper(this);

        returnM.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this,MainActivity.class);
                startActivity(intent);
            }});

        scores.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                ScoresDisplay test = new ScoresDisplay();
                trans.replace(R.id.historyFrame,test);
                trans.commit();


            }
        });
        push.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                PushupsDisplay test = new PushupsDisplay();
                trans.replace(R.id.historyFrame,test);
                trans.commit();


            }
        });
        sit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                SitupDisplay test = new SitupDisplay();
                trans.replace(R.id.historyFrame,test);
                trans.commit();


            }
        });
        run.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                RunDisplay test = new RunDisplay();
                trans.replace(R.id.historyFrame,test);
                trans.commit();


            }
        });









       /* Cursor data = db.getUserHistory();
        int num = data.getCount();
        if(num == 0){
            Toast.makeText(this, "No History", Toast.LENGTH_SHORT).show();
        }
        else{

            while (data.moveToNext()) {
                String service = data.getString(0);
                String age = data.getString(1);
                String gender = data.getString(2);
                String push = data.getString(3);
                String pscore = data.getString(4);
                String sit = data.getString(5);
                String sScore = data.getString(6);
                String run = data.getString(7);
                String runScre = data.getString(8);
                String finalScore= data.getString(9);
                int runTime =Integer.valueOf(run);
                int min = (runTime/60);
                int sec= runTime%60;
                String PleaseWork = "Service:"+service + ". Pushups: "+push +" Score: "+pscore +"Situps: "+sit +" Score: "+sScore +" Run:"+min+":"+sec+" Score: "+runScre +" Final Score: "
                        +finalScore;

                Toast.makeText(this, "results " +PleaseWork, Toast.LENGTH_SHORT).show();
            }

            data.close();
        }*/

    }
}
