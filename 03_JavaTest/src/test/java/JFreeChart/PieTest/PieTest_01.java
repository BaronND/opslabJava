package JFreeChart.PieTest;


import app.APP;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PieTest_01 {

    /**
     * 创建一个饼状图
     *
     * @throws IOException
     */
    @Test
    public void CreatePieTest() throws IOException {

        String file_name = APP.path_temp + "PieTest_01.jpg";

        File file = new File(file_name);

        //创建jfreechart对象( 饼图)
        JFreeChart chart = ChartFactory.createPieChart("Title", null, true, true, false);

        //将图像报错到指定的文件中
        ChartUtilities.saveChartAsJPEG(file, chart, 400, 300);
    }
}
