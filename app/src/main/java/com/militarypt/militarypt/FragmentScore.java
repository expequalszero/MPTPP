package com.militarypt.militarypt;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by brian on 12/9/2017.
 */

public class FragmentScore extends Fragment {
    DatabaseHelper db;
    public boolean input = false;
    public static Button button;
    public TextView results;
    public static Button mainmenu;
    public boolean clockRunning = false;
    public EditText text;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final CountDownTimer count;

        final View view = inflater.inflate(R.layout.fragmentscore, null);
        db = new DatabaseHelper(getActivity());

        mainmenu = (Button)view.findViewById(R.id.returnMain);
        results = (TextView) view.findViewById(R.id.finalScore);
        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;

        double p = Double.valueOf(Exam.pushS);
        double s = Double.valueOf(Exam.sitS);
        double r = Double.valueOf(Exam.runS);
        double sum = p+r+s;
        String score = "";
        if (Exam.branch.equals("Marines")||Exam.branch.equals("Army")||Exam.branch.equals("Navy")){
            score = String.valueOf(sum/3);
            Exam.score = score;
        }
        else{
            score = String.valueOf(sum+20);
            Exam.score = score;}

        double num = Double.valueOf(score);

        if(num>75.0&& !Exam.pushS.equals("0")&&!Exam.sitS.equals("0")){

            results.setText("Congratulations you have passed with a score of: "+ score);
        }
        else{
            results.setText("You have failed the exam!");
        }

        db.addUserHistory();

        mainmenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }});



        return view;
    }}