package JFreeChart.LineTest;

import app.APP;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LineTest_01 {
    @Test
    public void CreateLine() throws IOException {

        //创建类别数据集
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(3400, "HOST1", "0");
        ds.addValue(3100, "HOST2", "0");
        ds.addValue(1950, "HOST3", "0");

        ds.addValue(3300, "HOST1", "2");
        ds.addValue(3600, "HOST2", "2");
        ds.addValue(2150, "HOST3", "2");


        ds.addValue(3600, "HOST1", "4");
        ds.addValue(3600, "HOST2", "4");
        ds.addValue(2350, "HOST3", "4");

        ds.addValue(3400, "HOST1", "6");
        ds.addValue(3200, "HOST2", "6");
        ds.addValue(1850, "HOST3", "6");

        ds.addValue(3800, "HOST1", "8");
        ds.addValue(3000, "HOST2", "8");
        ds.addValue(2950, "HOST3", "8");

        ds.addValue(3000, "HOST1", "10");
        ds.addValue(3400, "HOST2", "10");
        ds.addValue(1800, "HOST3", "10");

        ds.addValue(3900, "HOST1", "12");
        ds.addValue(3200, "HOST2", "12");
        ds.addValue(1950, "HOST3", "12");

        ds.addValue(3400, "HOST1", "14");
        ds.addValue(3100, "HOST2", "14");
        ds.addValue(1950, "HOST3", "14");

        ds.addValue(3300, "HOST1", "16");
        ds.addValue(3600, "HOST2", "16");
        ds.addValue(2150, "HOST3", "16");


        ds.addValue(3600, "HOST1", "18");
        ds.addValue(3600, "HOST2", "18");
        ds.addValue(2350, "HOST3", "18");

        ds.addValue(3400, "HOST1", "20");
        ds.addValue(3200, "HOST2", "20");
        ds.addValue(1850, "HOST3", "20");

        ds.addValue(3800, "HOST1", "22");
        ds.addValue(3000, "HOST2", "22");
        ds.addValue(2950, "HOST3", "22");

        ds.addValue(3000, "HOST1", "24");
        ds.addValue(3400, "HOST2", "24");
        ds.addValue(1800, "HOST3", "24");


        //创建jfreechart对象( 饼图)
        String title1 = "各服务访问量";
        String title2 = "小时";
        String title3 = "访问量(人:次)";
        JFreeChart chart = ChartFactory.createLineChart(title1, title2, title3, ds, PlotOrientation.VERTICAL, true, false, false);
        //中文问题
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));
        //提示条字体
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));
        //得到绘图区
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //设置背景颜色
        plot.setBackgroundPaint(ChartColor.BLACK);
        //domain轴标签字体
        plot.getDomainAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));
        //domain轴小标签字体
        plot.getDomainAxis().setTickLabelFont(new Font("宋体", Font.PLAIN, 15));

        //range轴标签字体
        plot.getRangeAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));

        String file_name = APP.path_temp + "LineTest_01.jpg";

        ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
    }
}
