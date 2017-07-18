package JFreeChart.LineTest;

import app.APP;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @Summary： 利用timeSeries在统一绘图区绘制俩条线，做比较
 */
public class LineTest_02 {
    @Test
    public void CreateLine() throws IOException {
        TimeSeries timeSeries = new TimeSeries("2012访问量统计");

        //构造数据集合
        timeSeries.add(new Month(1, 2013), 11200);
        timeSeries.add(new Month(2, 2013), 9000);
        timeSeries.add(new Month(3, 2013), 6200);
        timeSeries.add(new Month(4, 2013), 8200);
        timeSeries.add(new Month(5, 2013), 8200);
        timeSeries.add(new Month(6, 2013), 12200);
        timeSeries.add(new Month(7, 2013), 13200);
        timeSeries.add(new Month(8, 2013), 8300);
        timeSeries.add(new Month(9, 2013), 12400);
        timeSeries.add(new Month(10, 2013), 12500);
        timeSeries.add(new Month(11, 2013), 13600);
        timeSeries.add(new Month(12, 2013), 12500);

        TimeSeries timeSeries1 = new TimeSeries("2013访问量统计");

        //构造数据集合
        timeSeries1.add(new Month(1, 2013), 11800);
        timeSeries1.add(new Month(2, 2013), 8000);
        timeSeries1.add(new Month(3, 2013), 9200);
        timeSeries1.add(new Month(4, 2013), 9200);
        timeSeries1.add(new Month(5, 2013), 10200);
        timeSeries1.add(new Month(6, 2013), 12200);
        timeSeries1.add(new Month(7, 2013), 9900);
        timeSeries1.add(new Month(8, 2013), 11300);
        timeSeries1.add(new Month(9, 2013), 10400);
        timeSeries1.add(new Month(10, 2013), 8800);
        timeSeries1.add(new Month(11, 2013), 10200);
        timeSeries1.add(new Month(12, 2013), 14500);

        //时间曲线数据集合
        TimeSeriesCollection lineDataset = new TimeSeriesCollection();


        lineDataset.addSeries(timeSeries);
        lineDataset.addSeries(timeSeries1);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(" 访问量统计时间线", "月份", "访问量", lineDataset, true, true, true);
        //中文问题
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));
        //提示条字体
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));
        //得到绘图区
        XYPlot plot = (XYPlot) chart.getPlot();
        //设置背景颜色
        plot.setBackgroundPaint(ChartColor.WHITE);

        //设置网格竖线颜色
        plot.setDomainGridlinePaint(ChartColor.BLACK);

        //设置网格横线颜色
        plot.setRangeGridlinePaint(ChartColor.BLACK);


        //domain轴标签字体
        plot.getDomainAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));
        //domain轴小标签字体
        plot.getDomainAxis().setTickLabelFont(new Font("宋体", Font.PLAIN, 15));

        //range轴标签字体
        plot.getRangeAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));

        //设置曲线上显示数据
        XYItemRenderer xyitem = plot.getRenderer();
        xyitem.setBaseItemLabelsVisible(true);
        xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition
                (ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
        plot.setRenderer(xyitem);

        String file_name = APP.path_temp + "LineTest_02.jpg";

        ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
    }
}
