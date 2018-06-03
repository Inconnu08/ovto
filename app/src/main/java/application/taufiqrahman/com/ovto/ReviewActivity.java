package application.taufiqrahman.com.ovto;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;


public class ReviewActivity extends AppCompatActivity {

    public static final int PRIMARYCOLOR = Color.parseColor("#42da72");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        BarChart chart = (HorizontalBarChart) findViewById(R.id.graph);

        BarDataSet set1;
        set1 = new BarDataSet(getDataSet(), "Ratings");

        set1.setColors(PRIMARYCOLOR, PRIMARYCOLOR, PRIMARYCOLOR, PRIMARYCOLOR, PRIMARYCOLOR);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);

        //bar settings
        data.setBarWidth(0.2f);

        // hide Y-axis
        YAxis left = chart.getAxisLeft();
        left.setDrawLabels(false);

        // custom X-axis labels
        String[] values = new String[] { "1 star", "2 stars", "3 stars", "4 stars", "5 stars"};
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));

        chart.setData(data);

        // hide grid
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);

        // custom description
        Description description = new Description();
        description.setText("Rating");
        chart.setDescription(description);

        // hide legend
        chart.getLegend().setEnabled(false);

        chart.animateY(1000);
        chart.invalidate();

    }

//        items.add(new BarItem("2★ ", 400d, PRIMARYCOLOR, Color.WHITE));
//        items.add(new BarItem("1★ ", 100d, PRIMARYCOLOR, Color.WHITE));

    public class MyXAxisValueFormatter implements IAxisValueFormatter {

        private String[] mValues;

        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }

    private ArrayList<BarEntry> getDataSet() {

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry v1e2 = new BarEntry(1, 434);
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(2, 312);
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(3, 552);
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(4, 1042);
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(5, 2093);
        valueSet1.add(v1e6);

        return valueSet1;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }

}
