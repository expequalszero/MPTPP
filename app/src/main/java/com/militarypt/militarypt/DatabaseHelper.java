package com.militarypt.militarypt;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * CNEED TO CHECK ALL FEMALE STANDARDS FOR PROPER NUMBERS.
 */

public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String database = "PTAPP.db";
    private static final int verison = 1;


    public DatabaseHelper(Context context){
        super(context,database,null,verison);
    }




    public Cursor getUserHistory(){
        SQLiteDatabase dbR = this.getReadableDatabase();
        Cursor data = dbR.rawQuery("SELECT * FROM history", null );

        return data;
    }








    public Cursor getpushupsMax(){
        SQLiteDatabase drb = this.getReadableDatabase();

        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;

        Cursor data = drb.rawQuery("SELECT  MAX(CAST(pushUps as int)),pushScore FROM standardsforptapp WHERE age = '"+age+"' AND service = '"+branch+"' AND gender = '" + gender+"'",null);


        return data;
    }

    public Cursor getpushupMin(){
        SQLiteDatabase drb = this.getReadableDatabase();
        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;
        Cursor data = drb.rawQuery("SELECT  MIN(CAST(pushUps as int)) as pushUps,sitScore FROM standardsforptapp WHERE age = '"+age+"' AND service = '"+branch+"' AND gender = '" + gender+"'",null);
        return data;
    }
    public Cursor getsitMin(){
        SQLiteDatabase drb = this.getReadableDatabase();
        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;
        Cursor data = drb.rawQuery("SELECT  MIN(CAST(sit as int)) as sit,sitScore FROM standardsforptapp WHERE age = '"+age+"' AND service = '"+branch+"' AND gender = '" + gender+"'",null);
        return data;
    }



    public Cursor getsitupsMax(){
        SQLiteDatabase drb = this.getReadableDatabase();
        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;
        Cursor data = drb.rawQuery("SELECT MAX(cast(sit as int)),sitScore FROM standardsforptapp WHERE age = '"+age+"' AND service = '"+branch+"' AND gender = '" + gender+"'",null);


        return data;
    }


    public Cursor getrunMax(){
        SQLiteDatabase drb = this.getReadableDatabase();

        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;
        Cursor data = drb.rawQuery("SELECT  MAX(CAST(run as int)),runScore FROM standardsforptapp WHERE age = '"+age+"' AND service = '"+branch+"' AND gender = '" + gender+"'",null);


        return data;
    }
    public Cursor getrunMin(){
        SQLiteDatabase drb = this.getReadableDatabase();

        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;
        Cursor data = drb.rawQuery("SELECT  MIN(CAST(run as int)),runScore FROM standardsforptapp WHERE age = '"+age+"' AND service = '"+branch+"' AND gender = '" + gender+"'",null);


        return data;
    }



    public Cursor getpushupsScore(){
        SQLiteDatabase drb = this.getReadableDatabase();
        Cursor data;
        String push = Exam.push;
        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;

        data = drb.rawQuery("SELECT pushScore FROM standardsforptapp WHERE pushUps = '" +push+"' AND age = '"+age+"' AND service = '"+branch+"' AND gender = '"+gender+"'",null);

        return data;
    }
    public Cursor getsitsScore(){
        SQLiteDatabase drb = this.getReadableDatabase();
        Cursor data;
        String sit = Exam.sit;
        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;

        data = drb.rawQuery("SELECT sitScore FROM standardsforptapp WHERE sit = '" +sit+"' AND age = '"+age+"' AND service = '"+branch+"' AND gender = '"+gender+"'",null);

        return data;
    }









    public Cursor getRunScore(String run){
        SQLiteDatabase drb =this.getReadableDatabase();
        Cursor max = this.getrunMax();
        Cursor min =this.getrunMin();
        Cursor runTime = drb.rawQuery("SELECT run,runScore FROM standardsforptapp WHERE service = '"+Exam.branch+"' AND age = '"+Exam.age+ "' AND gender = '"+Exam.gender+ "'" ,null);

        String value1= "";
        String value2= "";

        max.moveToFirst();
        min.moveToFirst();

        String MAX = max.getString(0);
        String MAXS = max.getString(1);
        String MIN = min.getString(0);
        String MINS = min.getString(1);
        int x= 0;
        int y =1;



        while(runTime.moveToNext()) {

            runTime.moveToPosition(x);
            value1 = runTime.getString(0);

            runTime.moveToPosition(y);
            value2= runTime.getString(0);




            if (Integer.valueOf(run) < Integer.valueOf(value1)){
                Cursor runScoring = drb.rawQuery("SELECT run,runScore FROM standardsforptapp WHERE run = '"+ value1+"' AND service = '"+Exam.branch+"' AND age = '"+Exam.age+ "' AND gender = '"+Exam.gender+ "'" ,null);

                return runScoring;

            }
            if (Integer.valueOf(run) >Integer.valueOf(value1)&& Integer.valueOf(run) <Integer.valueOf(value2)  ){
                Cursor runScoring = drb.rawQuery("SELECT run,runScore FROM standardsforptapp WHERE run = '"+ value2+"' AND service = '"+Exam.branch+"' AND age = '"+Exam.age+ "' AND gender = '"+Exam.gender+ "'" ,null);

                return runScoring;

            }
            if (Integer.valueOf(run) > Integer.valueOf(MAX)){
                Cursor data = drb.rawQuery("SELECT  MAX(CAST(run as int)),runScore FROM standardsforptapp WHERE age = '"+Exam.age+"' AND service = '"+Exam.branch+"' AND gender = '" + Exam.gender+"'",null);
                return data;

            }
            else {
                x=+1;
                y+=1;

            }





        }







        return runTime;


    }

public Cursor getScoresHistory(){
    SQLiteDatabase dbR = this.getReadableDatabase();

    Cursor entire = dbR.rawQuery("SELECT * FROM history",null);

    return entire;





}


public Cursor getPushups(){
    SQLiteDatabase dbR = this.getReadableDatabase();

    Cursor entire = dbR.rawQuery("SELECT pushScore FROM history",null);

    return entire;

}




    public boolean addUserHistory(){
        SQLiteDatabase dbR = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String branch = Exam.branch;
        String age = Exam.age;
        String gender = Exam.gender;
        String push = Exam.push;
        String pushS = Exam.pushS;
        String sit = Exam.sit;
        String sitS = Exam.sitS;
        String run = Exam.run;
        String runS = Exam.runS;
        String score = Exam.score;




        values.put("branch",branch);
        values.put("age",age);
        values.put("gender",gender);
        values.put("pushups",push);
        values.put("pushScore",pushS);
        values.put("situps",sit);
        values.put("sitScore",sitS);
        values.put("run",run);
        values.put("runScore",runS);
        values.put("score",score);






        long result = dbR.insert("history", null, values);

        if(result ==-1){return false;
            }
        else{return true;}
    }



}
