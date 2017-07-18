package JFreeChart.PieTest;


import app.APP;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @summary： 创建饼图，并设置标题（中文标题）
 */
public class PieTest_02 {
    @Test
    public void CreatePie_test() throws IOException {
        //创建饼图需要的数据
        DefaultPieDataset ds = new DefaultPieDataset();
        ds.setValue("C/C++", 27);
        ds.setValue("Java", 18);
        ds.setValue("object-c", 10);
        ds.setValue("C#", 6);
        ds.setValue("PHP", 4);
        ds.setValue("vb", 4);
        ds.setValue("Python", 4);
        ds.setValue("SQL", 4);
        ds.setValue("Javascript", 4);
        ds.setValue("Ruby", 2);

        //创建JFreeChart对象
        JFreeChart chart = ChartFactory.createPieChart("中国流行的编程语言", ds, true, false, false);

        //设置标题字体（可以通过字体解决中文乱码问题）
        chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));

        //提示条字体
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));

        //得到绘图区
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("宋体", Font.ITALIC, 15));


        //设置前景透明
        //plot.setForegroundAlpha(0.75f);

        //定制标签
        //{0}:名称
        //{1}:数量
        //{2}:百分比
        //{3}:总和
        //{4}:没有了
        //此处可以通过log4j日志那样组合输出
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{2}"));

        String file_name = APP.path_temp + "PieTest_02.jpg";

        //保存到图片中
        ChartUtilities.saveChartAsJPEG(new File(file_name), chart, 800, 500);
    }
}
