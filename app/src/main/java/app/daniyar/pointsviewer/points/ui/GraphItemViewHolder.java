package app.daniyar.pointsviewer.points.ui;

import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import app.daniyar.pointsviewer.R;
import app.daniyar.pointsviewer.models.Point;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GraphItemViewHolder extends BaseItemViewHolder<List<Point>> {
    @BindView(R.id.points_chart)
    protected LineChart pointsChart;

    public GraphItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        initChart();
    }

    private void initChart() {
        pointsChart.getDescription().setEnabled(false);

        // enable touch gestures
        pointsChart.setTouchEnabled(true);

        pointsChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        pointsChart.setDragEnabled(true);
        pointsChart.setScaleEnabled(true);
        pointsChart.setDrawGridBackground(false);
        pointsChart.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        pointsChart.setPinchZoom(true);

        // set an alternative background color
        pointsChart.setBackgroundColor(Color.LTGRAY);


        Legend l = pointsChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);
        l.setTextSize(11f);
        l.setTextColor(Color.WHITE);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
//        l.setYOffset(11f);

        XAxis xAxis = pointsChart.getXAxis();
        xAxis.setTextSize(11f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);

        YAxis leftAxis = pointsChart.getAxisLeft();
        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);

        YAxis rightAxis = pointsChart.getAxisRight();
        rightAxis.setTextColor(Color.RED);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);
    }

    @Override
    public void updateUI() {
        ArrayList<Entry> dataSetValues = new ArrayList<>();
        for (Point item : data) {
            dataSetValues.add(new Entry(item.getX(), item.getY()));
        }

        LineDataSet lineDataSet = new LineDataSet(dataSetValues, "");

        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setColor(ColorTemplate.getHoloBlue());
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setFillAlpha(65);
        lineDataSet.setFillColor(ColorTemplate.getHoloBlue());
        lineDataSet.setHighLightColor(Color.rgb(244, 117, 117));
        lineDataSet.setDrawCircleHole(false);

        pointsChart.setData(new LineData(lineDataSet));
    }
}
