package com.militarypt.militarypt;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by brian on 12/7/2017.
 */

public class Run extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentrun,null);
        Button enter = (Button)view.findViewById(R.id.enterTime);
        Button timer = (Button)view.findViewById(R.id.usingTimer);


        enter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                EnterRun run = new EnterRun();
                trans.replace(R.id.examFrame,run);
                trans.commit();


            }});
        timer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans =manager.beginTransaction();
                 TimerRun run = new TimerRun();
                trans.replace(R.id.examFrame,run);
                trans.commit();


            }});

        return view;
    }

}