package JFreeChart;


import app.APP;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import java.io.File;

public class UseJFreeChartDemo {
    @Test
    public void test() {
        // 创建一个柱状图
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // 装载数据
        dataset.setValue(6, "Profit", "Jane");
        dataset.setValue(3, "Profit2", "Jane");
        dataset.setValue(7, "Profit", "Tom");
        dataset.setValue(6, "Profit2", "Tom");
        dataset.setValue(8, "Profit", "Jill");
        dataset.setValue(9, "Profit2", "Jill");
        dataset.setValue(5, "Profit", "John");
        dataset.setValue(8, "Profit2", "John");
        dataset.setValue(12, "Profit", "Fred");
        dataset.setValue(11, "Profit2", "Fred");

        // 产生柱状图
        // JFreeChart chart =
        // ChartFactory.createXYLineChart("标题"，"x轴标志","y轴标志","设置数据","设置图形显示方向",是否显示图形,是否进行提示,是否配置报表存放地址);
        // 图形显示方向：
        // (1)HORIZONTAL:横向显示图形
        // (2)VERTICAL:纵向显示图形
        // 3D柱状图
        JFreeChart chart = ChartFactory.createBarChart3D("销售统计图", "数值", "时间", dataset, PlotOrientation.VERTICAL, true, true, false);

        // 设置总的背景颜色
        chart.setBackgroundPaint(ChartColor.WHITE);
        // 设置标题颜色
        chart.getTitle().setPaint(ChartColor.blue);
        // 获得图表对象
        CategoryPlot p = chart.getCategoryPlot();
        // 设置图的背景颜色
        p.setBackgroundPaint(ChartColor.WHITE);
        // 设置表格线颜色
        p.setRangeGridlinePaint(ChartColor.red);
        try {
            // // 创建图形显示面板
            // ChartFrame cf = new ChartFrame("柱状图",chart);
            // cf.pack();
            // // 设置图片大小
            // cf.setSize(500,300);
            // // 设置图形可见
            // cf.setVisible(true);

            // 保存图片到指定文件夹
            String file = APP.path_temp + "BarChart.png";
            ChartUtilities.saveChartAsPNG(new File(file), chart, 500, 300);

        } catch (Exception e) {
            System.err.println("Problem occurred creating chart.");
        }
    }

}
