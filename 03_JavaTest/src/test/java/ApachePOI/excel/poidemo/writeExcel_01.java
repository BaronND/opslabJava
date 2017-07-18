package ApachePOI.excel.poidemo;

import app.APP;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class writeExcel_01 {
    @Test
    public void test() throws IOException {

        // 工作簿
        HSSFWorkbook hssfworkbook = new HSSFWorkbook();
        // 创建sheet页
        HSSFSheet hssfsheet = hssfworkbook.createSheet();
        // sheet名称
        hssfworkbook.setSheetName(0, "研发部门");
        // 取得第一行
        HSSFRow hssfrow = hssfsheet.createRow(0);
        // 创建第一个单元格
        HSSFCell hssfcell_0 = hssfrow.createCell(0);
        // 对第一个单元格赋值
        hssfcell_0.setCellValue("研发工程师1");

        // 日期单元格格式处理
        HSSFCellStyle hssfcellstyle = hssfworkbook.createCellStyle();
        // m/d/yy h:mm
        hssfcellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        // 创建单元格
        HSSFCell hssfcell_1 = hssfrow.createCell(1);
        hssfcell_1.setCellValue(new Date());
        hssfcell_1.setCellStyle(hssfcellstyle);
        hssfrow.createCell(2).setCellValue(true);
        hssfrow.createCell(3).setCellValue(122.00);
        // 输出
        FileOutputStream fileoutputstream =
                new FileOutputStream(APP.path_temp + "1.xls");
        hssfworkbook.write(fileoutputstream);
        fileoutputstream.close();
    }
}