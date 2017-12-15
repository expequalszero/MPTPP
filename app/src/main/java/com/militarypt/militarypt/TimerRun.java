package com.militarypt.militarypt;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

/**
 * Created by brian on 12/9/2017.
 */

public class TimerRun extends Fragment {
    public long pauseTime;
    public long starttime;
    public String mins;
    public String secs;
    public int min;
    public int sec;
    public String resulting;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentusetimer,null);
        final DatabaseHelper db = new DatabaseHelper(getActivity());

        final Chronometer chronometer = (Chronometer)view.findViewById(R.id.timerDisplay);
        final Button start = (Button)view.findViewById(R.id.startTimer);
        final Button stop = (Button)view.findViewById(R.id.stopTimer);
        final Button pause = (Button)view.findViewById(R.id.pauseTime);
        final Button save = (Button)view.findViewById(R.id.saveTime);
        final Button button=(Button)getActivity().findViewById(R.id.butScore);
        save.setEnabled(false);
        pause.setEnabled(false);
        stop.setEnabled(false);




        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                long results = SystemClock.elapsedRealtime()-chronometer.getBase();


                String timeE = chronometer.getText().toString();
                CharSequence character= timeE;
                mins = character.subSequence(0,2).toString();
                secs = character.subSequence(3,5).toString();
                min = Integer.valueOf(mins);
                sec= Integer.valueOf(secs);
                resulting = String.valueOf((min*60)+sec );


                Cursor runStands = db.getRunScore(resulting);


                String value1 = "";

                int num = runStands.getCount();


                if (num != 0) {

                    while(runStands.moveToNext()){
                        value1 = runStands.getString(1);

                        Exam.runS = value1;
                        Toast.makeText(getActivity().getApplicationContext(), "Run Score Added.", Toast.LENGTH_SHORT).show();

                        button.setEnabled(true);
                        save.setEnabled(true);

                    }}
                else{

                    Toast.makeText(getActivity().getApplicationContext(), "There was an Issue."
                            , Toast.LENGTH_SHORT).show();}

            }


            });


        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                start.setEnabled(false);
                save.setEnabled(false);
                stop.setEnabled(true);
                pause.setEnabled(true);


                if (pauseTime != 0 ){
                    chronometer.setBase(chronometer.getBase()+SystemClock.elapsedRealtime()-pauseTime);
                }
                else {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    starttime = chronometer.getBase();
                }
                chronometer.start();
            }});


        stop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                start.setEnabled(false);
                pause.setEnabled(false);
                chronometer.stop();
                pauseTime= SystemClock.elapsedRealtime();
                save.setEnabled(true);
            }});


        pause.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pauseTime = SystemClock.elapsedRealtime();
                chronometer.stop();
                start.setEnabled(true);
                stop.setEnabled(false);
                save.setEnabled(true);




            }});






                return view;
    }

}
