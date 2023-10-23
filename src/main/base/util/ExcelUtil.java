package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtil {
    static String Path = "/Users/likui/Desktop/Java/file/wps/";

    public static void writeExcel() throws IOException {
        //1、创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //2、创建一个工作表
        Sheet sheet = workbook.createSheet("工作簿1");
        //3、创建一个行（1，1）
        Row row = sheet.createRow(0);
        //4、创建一个单元格
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        cell1.setCellValue("数据1");
        cell2.setCellValue("数据2");
        //生成一张表
        FileOutputStream outputStream = new FileOutputStream(Path + "test.xlsx");
        //输出
        workbook.write(outputStream);
        //关闭流
        outputStream.close();
    }

    public static void readExcel() throws IOException {
        FileInputStream inputStream = new FileInputStream(Path + "test.xlsx");
        //1、创建一个工作簿
        Workbook workbook = new XSSFWorkbook(inputStream);
        //2、得到表
        Sheet sheet = workbook.getSheetAt(0);
        //3、获取第一行
        Row row = sheet.getRow(0);
        //4、等到第一列
        Cell cell = row.getCell(0);
        //根据单元格中的数据类型不同来获取不同类型的数据
        System.out.println(cell.getStringCellValue());
    }

    public static Object getCellValue(Cell cell) {
        //1.获取到单元格的属性类型
        CellType cellType = cell.getCellType();
        //2.根据单元格数据类型获取数据
        Object value = null;
        switch (cellType) {
            case STRING -> value = cell.getStringCellValue();
            case BOOLEAN -> value = cell.getBooleanCellValue();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    //日期格式
                    value = cell.getDateCellValue();
                } else {
                    //数字
                    value = (int) cell.getNumericCellValue();
                }
            }
            default -> {
                System.out.println("暂无此类型！");
            }
        }
        //最后根据不同的数据类型获取到了我们想要的值
        return value;
    }
}
