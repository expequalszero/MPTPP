package com.militarypt.militarypt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Button afT = (Button)findViewById(R.id.afTipss);
        Button armyT = (Button)findViewById(R.id.armyTips);
        Button navyT = (Button)findViewById(R.id.navyTips);
        Button marinesT = (Button)findViewById(R.id.marinePage);
        Button retM = (Button)findViewById(R.id.tipsReturn);

        retM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Tips.this,MainActivity.class);
                startActivity(intent);
            }
            });

        afT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.afpc.af.mil/Air-Force-Fitness-Program/"));
                startActivity(intent);

            }

        });

        armyT.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v){

                                         Intent intent = new Intent(Intent.ACTION_VIEW);
                                         intent.setData(Uri.parse("https://m.goarmy.com/content/dam/goarmy/downloaded_assets/pt_guide/pocket-pt-guide.pdf"));
                                         startActivity(intent);

                                     }

                                 }

        );

        navyT.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v){

                                         Intent intent = new Intent(Intent.ACTION_VIEW);
                                         intent.setData(Uri.parse("https://www.navy.com/navy-life/life-as-a-sailor/fitness.html#physical-training"));
                                         startActivity(intent);

                                     }

                                 }

        );

        marinesT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.fitness.marines.mil/"));
                startActivity(intent);

            }



        });









    }





}
