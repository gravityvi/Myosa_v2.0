package com.example.ravi.mayosa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ravi.mayosa.Database.DataRecord;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ravi on 14-02-2018.
 */

public class SensorListAdapter extends RecyclerView.Adapter<SensorListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SensorObject> SensorList;
    private LayoutInflater inflator;
    private ArrayList<DataRecord> dataRecords;


    private int upperLimit[] = {500, 500, 300, 10200, 40100, 90100, 10200, 10200};
    private int lowerLimit[] = {0, 0, 0, 1000, 28000, 78000, 8000, 8000};


    private final List<Entry> entries13 = new ArrayList<Entry>();
    private final List<Entry> entries0 = new ArrayList<Entry>();
    private final List<Entry> entries1 = new ArrayList<Entry>();
    private final List<Entry> entries12 = new ArrayList<Entry>();
    private final List<Entry> entries11 = new ArrayList<Entry>();
    private final List<Entry> entries10 = new ArrayList<Entry>();
    private final List<Entry> entries9 = new ArrayList<Entry>();
    private final List<Entry> entries8 = new ArrayList<Entry>();
    private final List<Entry> entries7 = new ArrayList<Entry>();
    private final List<Entry> entries6 = new ArrayList<Entry>();
    private final List<Entry> entries5 = new ArrayList<Entry>();
    private final List<Entry> entries4 = new ArrayList<Entry>();
    private final List<Entry> entries3 = new ArrayList<Entry>();
    private final List<Entry> entries2 = new ArrayList<Entry>();
    private LineData lineData0;
    private LineDataSet dataSet0;
    private Handler handler=new Handler();

    private ArrayList<LineGraphSeries> sensor_att=new ArrayList<>();
    private ArrayList<Integer> temp=new ArrayList<>();


    public SensorListAdapter(Context context, ArrayList<SensorObject> arrayList, ArrayList<DataRecord> arrayList1) {
        this.context = context;
        this.SensorList = arrayList;
        inflator = LayoutInflater.from(context);
        this.dataRecords = arrayList1;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataRecords = valueSeque.getValueRecord();
        View view = inflator.inflate(R.layout.sensor_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);


        for(int i=0;i<13;i++)
        {
            LineGraphSeries series=new LineGraphSeries();
            sensor_att.add(series);

        }

        for(int i=0;i<13;i++)
        {
            temp.add(0);

        }


        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {



        DataRecord dataRecord = dataRecords.get(dataRecords.size() - 1);
        final String s[]=valueSeque.getValues().get(dataRecords.size()-1);

            if (temp.get(position) == 0) {
                sensor_att.get(position).setAnimated(true);


            }

                    //System.out.println("hello1  "+ position);
                    holder.Value.setText(s[position]);
                    holder.lineChart.removeAllSeries();
                    LineGraphSeries lineGraphSeries=new LineGraphSeries();
                    for(int i=0;i<valueSeque.getValues().size();i++)
                    {
                        String l[]=valueSeque.getValues().get(i);
                        lineGraphSeries.appendData(new DataPoint(i+1,Integer.parseInt(l[position])),true,4);
                    }
                    holder.lineChart.removeAllSeries();
                    holder.lineChart.addSeries(lineGraphSeries);











    }

    @Override
    public int getItemCount() {
        return 13;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView SensorHeading;
        TextView Attribute;
        TextView Value;
        Button bSet;
        EditText MinValue;
        GraphView lineChart;
        EditText MaxValue;


        public ViewHolder(View itemView) {
            super(itemView);
            Value = itemView.findViewById(R.id.tValue);
            lineChart = itemView.findViewById(R.id.lineChart);
            SensorHeading = itemView.findViewById(R.id.tSensorHead);
            Attribute = itemView.findViewById(R.id.tAttribute);
            bSet = itemView.findViewById(R.id.bSet);
            MinValue = itemView.findViewById(R.id.eMinValue);
            MaxValue = itemView.findViewById(R.id.eMaxValue);


        }
    }

}
