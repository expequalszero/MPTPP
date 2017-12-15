package com.militarypt.militarypt;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by brian on 12/10/2017.
 */

public class ScoresDisplay extends android.app.Fragment {
    DatabaseHelper db;
    LineChart lineChart;
    LineGraphSeries<DataPoint> graphing;


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.scoredisplay,null);
        db = new DatabaseHelper(getActivity());
        graphing = new LineGraphSeries<DataPoint>();
        GraphView graph = (GraphView)view.findViewById(R.id.graphScore);

        Cursor cursor = db.getScoresHistory();
        ArrayList<Double>yA= new ArrayList<>();
        ArrayList<Integer>xA= new ArrayList<>();
        int xValue= 0;
        graphing.isDrawBackground();
        graphing.setColor(Color.WHITE);
        graphing.setThickness(10);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(1);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf,nf) );
        graphing.setDrawDataPoints(true);
        graphing.setDataPointsRadius(20);





        int num = cursor.getCount();
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxX(num);
        graph.getViewport().setMinX(0);


       /* graph.getViewport().setScalable(true);*/
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMaxY(100);
        graph.getViewport().setMinY(0);

        if (num!=0) {
            while (cursor.moveToNext()) {
                int i = 0;
                String test = cursor.getString(cursor.getColumnIndex("score"));
               double y = Double.valueOf(test);
                yA.add(y);

                i += 1;
                xA.add(xValue);
                xValue += 1;

            }

        }


        for(int i = 0; i<yA.size();i++){
            double x = xA.get(i);
            double y = yA.get(i);


        graphing.appendData(new DataPoint(x, y), true, num);
        }


    graph.addSeries(graphing);





            return view;
        }}



















