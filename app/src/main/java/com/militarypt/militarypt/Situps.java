package com.militarypt.militarypt;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by brian on 12/7/2017.
 */

public class Situps extends Fragment {
    DatabaseHelper db;
    public boolean input = false;
    public static Button button;
    public Handler handler;
    public TextView clock;
    public boolean clockRunning = false;
    public EditText text;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        button=(Button)getActivity().findViewById(R.id.run);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final CountDownTimer count;

        final View view = inflater.inflate(R.layout.fragmentsit,null);
        db = new DatabaseHelper(getActivity());

        text=(EditText)view.findViewById(R.id.sitInput);
        clock=(TextView)view.findViewById(R.id.sitTime);
        final Button save = (Button)view.findViewById(R.id.sitSave);
        final Button start = (Button)view.findViewById(R.id.sitStart);
        /*Button reset = (Button)view.findViewById(R.id.sitRest);*/





        save.setOnClickListener(new View.OnClickListener(){




            @Override
            public void onClick(View v) {

                if (!text.getText().toString().equals("")) {
                    save.setEnabled(false);
                    start.setEnabled(false);
                    Exam.sit = text.getText().toString();
                    Cursor cursor = db.getsitsScore();
                    Cursor cursorMax= db.getsitupsMax();
                    Cursor cursorMin = db.getsitMin();
                    cursorMax.moveToFirst();
                    cursorMin.moveToFirst();
                    String max = cursorMax.getString(0);
                    String min = cursorMin.getString(0);
                    int numIn = Integer.valueOf(text.getText().toString());
                    if (Integer.valueOf(text.getText().toString()) > Integer.valueOf(max)) {
                        if (Exam.branch.equals("AirForce")) {
                            Exam.sitS = "10";

                        } else {
                            Exam.sitS = "100";


                        }
                    }
                    if(numIn<=Integer.valueOf(min)){
                        Exam.sitS ="0";

                    }
                    else{
                        while(cursor.moveToNext()){
                            Exam.sitS= cursor.getString(cursor.getColumnIndex("sitScore"));

                            Toast.makeText(getActivity().getApplicationContext(), "Sit Score Added.", Toast.LENGTH_SHORT).show();
                        }

                    }






                    button.setEnabled(true);
                    Toast.makeText(getActivity().getApplicationContext(), "Sit Score Added.", Toast.LENGTH_SHORT).show();
                }
            }}

        );

        start.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v){
                start.setEnabled(false);
                save.setEnabled(false);
                if(!clockRunning){

                    if (Exam.branch.equals("AirForce" )|| Exam.branch.equals("Navy")) {

                        CountDownTimer count = new CountDownTimer(15000, 1000) {


                            public void onTick(long millisUntilFinished) {

                                clockRunning = true;

                                clock.setText("Time: " + millisUntilFinished / 1000);}

                            public void onFinish() {
                                clock.setText("Begin");
                                handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {


                                        CountDownTimer count = new CountDownTimer(60000, 1000) {


                                    public void onTick(long millisUntilFinished) {

                                        clockRunning = true;

                                        clock.setText("Time: " + millisUntilFinished / 1000);

                                        if (millisUntilFinished / 1000 == 62) {

                                        }
                                    }

                                    public void onFinish() {
                                        clockRunning = !clockRunning;
                                        clock.setText("Times Up");
                                        start.setEnabled(true);
                                        save.setEnabled(true);

                                    }
                                }.start();}},1000);}
                        }.start();
                    }
                    if (Exam.branch.equals("Army")||Exam.branch.equals("Marines")) {

                        CountDownTimer count = new CountDownTimer(15000, 1000) {
                            public void onTick(long millisUntilFinished) {

                                clockRunning = true;

                                clock.setText("Time: " + millisUntilFinished / 1000);}

                            public void onFinish() {
                                clock.setText("Begin");
                                handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        CountDownTimer count = new CountDownTimer(120000, 1000) {
                                    public void onTick(long millisUntilFinished) {

                                        clockRunning = true;

                                        clock.setText("Time: " + millisUntilFinished / 1000);

                                        if (millisUntilFinished / 1000 == 62) {

                                        }
                                    }
                                    public void onFinish() {
                                        clockRunning = !clockRunning;
                                        clock.setText("Times Up");
                                        start.setEnabled(true);

                                    }
                                }.start();}},1000);}
                        }.start();
                    }            }


            }}  );



/*
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if (clockRunning){
                    clockRunning = !clockRunning;
                    Toast.makeText(getActivity(), "testing Reset", Toast.LENGTH_SHORT).show();
                }







            }});*/




        return view;
    }


}
