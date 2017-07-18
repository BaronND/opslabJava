package JFreeChart.TimeSeriesTest;


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
import org.jfree.data.time.Hour;
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
public class TimeSeriesTest_01 {
    @Test
    public void CreateLine() throws IOException {
        TimeSeries timeSeries = new TimeSeries("前日");
        for (int j = 0; j < 24; j++) {
            //每个小时一个点
            timeSeries.add(new Hour(j, 02, 03, 2013), (int) (Math.random() * 8000 + 6000));
            //没30分钟一个点
//			for(int i=0;i<2;i++){
//				timeSeries.add(new Minute(i*30,new Hour(j,02,03,2013)), (int)(Math.random()* 8000 + 6000) );
//			}
        }

        TimeSeries timeSeries1 = new TimeSeries("昨日");
        for (int j = 0; j < 24; j++) {
            //每个小时一个点
            timeSeries1.add(new Hour(j, 02, 03, 2013), (int) (Math.random() * 8000 + 6000));
            //没30分钟一个点
//			for(int i=0;i<2;i++){
//				timeSeries1.add(new Minute(i*30,new Hour(j,02,03,2013)), (int)(Math.random()* 8000 + 6000) );
//			}
        }

        //时间曲线数据集合
        TimeSeriesCollection lineDataset = new TimeSeriesCollection();


        lineDataset.addSeries(timeSeries);
        lineDataset.addSeries(timeSeries1);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(" 访问量统计时间线", "时间点", "访问量", lineDataset, true, true, true);
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

        String file_name = APP.path_temp+ "TimeSeriesTest_03.jpg";

        ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 1300, 800);
    }
}
