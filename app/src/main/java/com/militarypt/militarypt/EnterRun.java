package com.militarypt.militarypt;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by brian on 12/9/2017.
 */

public class EnterRun extends Fragment {

    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmententerrun,null);
        db = new DatabaseHelper(getActivity());
        final Button button=(Button)getActivity().findViewById(R.id.butScore);
        final EditText minIn = (EditText)view.findViewById(R.id.runMinIn);
        final EditText secIn = (EditText)view.findViewById(R.id.runSecIn);
        final Button save = (Button)view.findViewById(R.id.saveEnterRun);
        final String min = minIn.getText().toString();
        String sec = secIn.getText().toString();

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(!minIn.getText().toString().equals("")){


                    String min = minIn.getText().toString();
                    String sec = secIn.getText().toString();
                    if (sec.equals(null)||sec.equals("")){
                        sec = "0";
                    }
                    int minInput = Integer.parseInt(min);
                    int secInput = Integer.parseInt(sec);
                    int sum = minInput * 60 + secInput;
                    Exam.run = String.valueOf(sum);
                    boolean valueFound = false;
                    String time = String.valueOf(sum);


                    Cursor runStands = db.getRunScore(time);


                    String value1 = "";

                    int num = runStands.getCount();

                    if (num != 0) {

                        while(runStands.moveToNext()){
                            value1 = runStands.getString(1);

                            Exam.runS = value1;
                            Toast.makeText(getActivity().getApplicationContext(), "Run Score Added.", Toast.LENGTH_SHORT).show();
                            button.setEnabled(true);
                            save.setEnabled(false);

                        }}
                    else{

                        Toast.makeText(getActivity(), "There was an Issue."
                                , Toast.LENGTH_SHORT).show();}




                }

                else {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter in the Minutes and Seconds.", Toast.LENGTH_SHORT).show();


                }
            }});







        return view;
    }

}