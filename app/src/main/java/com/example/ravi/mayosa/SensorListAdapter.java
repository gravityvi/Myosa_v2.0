package com.example.ravi.mayosa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ravi.mayosa.Database.DataRecord;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ravi on 14-02-2018.
 */

public class SensorListAdapter extends RecyclerView.Adapter<SensorListAdapter.ViewHolder> {

    private static Context context;
    private static ArrayList<SensorObject> SensorList;
    private static LayoutInflater inflator;
    private static ArrayList<DataRecord> dataRecords;



   private static final List<Entry> entries13=new ArrayList<Entry>();
    private static final  List<Entry> entries0=new ArrayList<Entry>();
    private static final List<Entry> entries1=new ArrayList<Entry>();
    private static final List<Entry> entries12=new ArrayList<Entry>();
    private static final List<Entry> entries11=new ArrayList<Entry>();
    private static final List<Entry> entries10=new ArrayList<Entry>();
    private static final List<Entry> entries9=new ArrayList<Entry>();
    private static final List<Entry> entries8=new ArrayList<Entry>();
    private static final List<Entry> entries7=new ArrayList<Entry>();
    private static final List<Entry> entries6=new ArrayList<Entry>();
    private static final List<Entry> entries5=new ArrayList<Entry>();
    private static final List<Entry> entries4=new ArrayList<Entry>();
    private static final List<Entry> entries3=new ArrayList<Entry>();
    private static final List<Entry> entries2=new ArrayList<Entry>();





    public SensorListAdapter(Context context, ArrayList<SensorObject> arrayList,ArrayList<DataRecord> arrayList1 ) {
        this.context=context;
        this.SensorList=arrayList;
        inflator=LayoutInflater.from(context);
        this.dataRecords=arrayList1;




    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        dataRecords= valueSeque.getValueRecord();
        View view=inflator.inflate(R.layout.sensor_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        for(int i=0;i<dataRecords.size();i++)
        {
            entries0.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getVisibility())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries1.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getTime())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries2.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getGyroX())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries3.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getGyroY())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries4.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getGyroZ())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries5.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getHumidity())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries6.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getInfrared())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries7.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getLux())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries8.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getMagnX())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries9.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getMagnY())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries10.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getMagnZ())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries11.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getPress_mbar())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries12.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getPress_mmhg())));
        }

        for(int i=0;i<dataRecords.size();i++)
        {
            entries13.add(new Entry(i,Integer.parseInt(dataRecords.get(i).getTemp())));
        }

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       SensorObject  sensorObject= SensorList.get(position);
       holder.Attribute.setText(sensorObject.getAttribute());
       holder.SensorHeading.setText(sensorObject.getSensorHead());

       DataRecord dataRecord= dataRecords.get(dataRecords.size()-1);

       if(position==0)
       {
           LineDataSet dataSet =new LineDataSet(entries0,"Label0");
           LineData lineData=new LineData(dataSet);
           holder.lineChart.invalidate();//refresh
           holder.Value.setText(dataRecord.getVisibility());

       }

       else if(position==1)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getTime());

        }

       else if(position==2)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getGyroX());
        }

       else if(position==3)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getGyroY());
        }

       else if(position==4)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getGyroZ());
        }

       else if(position==5)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getHumidity());
        }

       else if(position==6)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getInfrared());
        }

       else if(position==7)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getLux());
        }

       else if(position==8)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getMagnX());
        }

       else if(position==9)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getMagnY());
        }

       else if(position==10)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getMagnZ());
        }

       else if(position==11)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getPress_mbar());
        }

       else if(position==12)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getPress_mmhg());
        }
       else if(position==13)
        {
            LineDataSet dataSet =new LineDataSet(entries0,"Label0");
            LineData lineData=new LineData(dataSet);
            holder.lineChart.invalidate();//refresh
            holder.Value.setText(dataRecord.getTemp());
        }



    }

    @Override
    public int getItemCount() {
        return SensorList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView SensorHeading;
        TextView Attribute;
        TextView Value;
        Button bSet;
        EditText MinValue;
        LineChart lineChart;
        EditText MaxValue;


        public ViewHolder(View itemView) {
            super(itemView);
            Value=itemView.findViewById(R.id.tValue);
            lineChart=itemView.findViewById(R.id.Chart);
            SensorHeading=itemView.findViewById(R.id.tSensorHead);
            Attribute=itemView.findViewById(R.id.tAttribute);
            bSet= itemView.findViewById(R.id.bSet);
            MinValue=itemView.findViewById(R.id.eMinValue);
            MaxValue=itemView.findViewById(R.id.eMaxValue);


        }
    }
}
