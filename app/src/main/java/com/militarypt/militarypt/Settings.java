package com.militarypt.militarypt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    public static String branch ;
    public static String age ;
    public static String gender ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SharedPreferences preferences = getSharedPreferences("userInfo", MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        Button save = (Button)findViewById(R.id.saveSettings);
        Button returnM= (Button)findViewById(R.id.settingsReturn);



        final RadioButton af = (RadioButton)findViewById(R.id.afBut);
        final RadioButton army = (RadioButton)findViewById(R.id.armyBut);
        final RadioButton navy = (RadioButton)findViewById(R.id.navyBut);
        final RadioButton marine = (RadioButton)findViewById(R.id.marinesBut);
        final RadioButton under30 = (RadioButton)findViewById(R.id.under30);
        final RadioButton thirty = (RadioButton)findViewById(R.id.age30_39);
        final RadioButton fourty = (RadioButton)findViewById(R.id.age40);
        final RadioButton fifty = (RadioButton)findViewById(R.id.age50);

        final RadioButton genM = (RadioButton)findViewById(R.id.genM);
        final RadioButton genF = (RadioButton)findViewById(R.id.genF);

        returnM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);

            }});


        save.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){

                        editor.putBoolean("af",af.isChecked());
                        editor.putBoolean("army",army.isChecked());
                        editor.putBoolean("navy",navy.isChecked());
                        editor.putBoolean("marine",marine.isChecked());
                        editor.putBoolean("ageUnder", under30.isChecked());
                        editor.putBoolean("age30", thirty.isChecked());
                        editor.putBoolean("age40", fourty.isChecked());
                        editor.putBoolean("age50", fifty.isChecked());

                        editor.putBoolean("genM", genM.isChecked());
                        editor.putBoolean("genF", genF.isChecked());
                        editor.putString("branch",branch);
                        editor.putString("age",age);
                        editor.putString("gender",gender);




                        editor.commit();

                        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();}}
                );



        boolean afSel = preferences.getBoolean("af", false);
        boolean armySel = preferences.getBoolean("army", false);
        boolean navySel = preferences.getBoolean("navy", false);
        boolean marSel = preferences.getBoolean("marine", false);
        boolean ageUnder = preferences.getBoolean("ageUnder",false);
        boolean age30 = preferences.getBoolean("age30",false);
        boolean age40 = preferences.getBoolean("age40",false);
        boolean age50 = preferences.getBoolean("age50",false);
        boolean male = preferences.getBoolean("genM",false);
        boolean female = preferences.getBoolean("genF",false);
        String bran = preferences.getString("branch"," ");
        String ag = preferences.getString("age"," ");
        String gen = preferences.getString("gender"," ");

        af.setChecked(afSel);
        army.setChecked(armySel);
        navy.setChecked(navySel);
        marine.setChecked(marSel);
        under30.setChecked(ageUnder);
        thirty.setChecked(age30);
        fourty.setChecked(age40);
        fifty.setChecked(age50);

        genM.setChecked(male);
        genF.setChecked(female);
        branch = bran;
        age = ag;
        gender = gen;

        if(af.isChecked()){
            branch= "AirForce";
            editor.putString("branch","Airforce");
            editor.apply();
        }
        if(army.isChecked()){
            branch= "Army";
            editor.putString("branch","Army");
            editor.apply();
        }
        if(navy.isChecked()){
            branch= "Navy";
            editor.putString("branch","Navy");
            editor.apply();
        }
        if(marine.isChecked()){
            branch= "Marines";
            editor.putString("branch","Marines");
            editor.apply();
        }

        if (under30.isChecked()){
            age="29";
            editor.putString("age","29");
            editor.apply();
        }
        if (thirty.isChecked()){
            age="39";
            editor.putString("age","39");
            editor.apply();
        }
        if (fourty.isChecked()){
            age="49";
            editor.putString("age","49");
            editor.apply();
        }
        if (fifty.isChecked()){
            age="59";
            editor.putString("age","59");
            editor.apply();
        }

        if(genM.isChecked()){
            gender= "male";
            editor.putString("gender","male");
            editor.apply();
        }
        if (genF.isChecked()){
            gender="female";
            editor.putString("gender","female");
            editor.apply();
        }





    }







    public void InfoSelect(View view){
        switch (view.getId()){
            case R.id.afBut:
                branch= "AirForce";

                break;
            case R.id.armyBut:
                branch= "Army";
                break;
            case R.id.navyBut:
                branch= "Navy";
                break;
            case R.id.marinesBut:
                branch= "Marines";
                break;
        }


        switch (view.getId()) {
            case R.id.under30:
                age = "29";
                break;
            case R.id.age30_39:
                age = "39";
                break;
            case R.id.age40:
                age = "49";
                break;
            case R.id.age50:
                age = "59";
                break;


        }



        switch (view.getId()){
            case R.id.genM:
                gender="male";
                break;
            case R.id.genF:
                gender="female";
                break;
        }

    }





}
