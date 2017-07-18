package JFreeChart.BarTest;

import app.APP;
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


/**
 * @Summary:创建简单的柱状图
 */
public class BarTest_01 {
    @Test
    public void CreateBar() throws IOException {
        //创建柱状图所需要的数据集对象
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(6000, "PHP", "Windows");
        ds.addValue(5000, "JAVA", "Windows");
        ds.addValue(4000, "Python", "Windows");

        ds.addValue(5000, "PHP", "Linux");
        ds.addValue(4500, "JAVA", "Linux");
        ds.addValue(3200, "Python", "Linux");

        ds.addValue(5000, "PHP", "Mac");
        ds.addValue(3000, "JAVA", "Mac");
        ds.addValue(3000, "Python", "Mac");

        JFreeChart chart = ChartFactory.createBarChart(
                "开发语言与系统平台搭配使用", // 图表标题
                "开发语言", // 目录轴的显示标签
                "使用人数", // 数值轴的显示标签
                ds, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 是否显示图例(对于简单的柱状图必须是false)
                false, // 是否生成工具
                false // 是否生成URL链接
        );

        //设置标题字体（可以通过字体解决中文乱码问题）
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));

        //提示条字体
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));

        //得到绘图区
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        //domain轴标签字体
        plot.getDomainAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));
        //domain轴小标签字体
        plot.getDomainAxis().setTickLabelFont(new Font("宋体", Font.PLAIN, 15));

        //range轴标签字体
        plot.getRangeAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));


        String file_name = APP.path_temp + "BarTest_01.jpg";

        //保存到图片中
        ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);

    }
}
