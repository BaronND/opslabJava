package ApachePOI.excel.poidemo;

import app.APP;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class writeExcel_02 {
    @Test
    public void test() throws IOException {

        HSSFWorkbook hssfworkbook = new HSSFWorkbook();
        // 创建sheet页
        HSSFSheet hssfsheet = hssfworkbook.createSheet();
        // sheet名称
        hssfworkbook.setSheetName(0, "测试");

        HSSFRow title = hssfsheet.createRow(0);

        for (int i = 0; i < 40; i++) {
            HSSFCell cell = title.createCell(i);
            cell.setCellValue("title" + String.valueOf(i));
        }

        for (int i = 1; i < 50000; i++) {
            HSSFRow row = hssfsheet.createRow(i);
            for (int j = 0; j < 40; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(i);
            }
        }

        FileOutputStream fileoutputstream =
                new FileOutputStream(APP.path_temp + "2.xls");
        hssfworkbook.write(fileoutputstream);
        fileoutputstream.close();
    }
}
