package com.smzdz.util.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * class excel 解析
 *
 * @author qibaichao
 * @version 1.0
 * @date Feb 6, 2013 11:30:48 AM
 * @since 1.0
 */
public class ExcelUtils {

    /**
     * 常量：缺省一个sheet页中行数（含表头）最大值为65536
     */
    public static int DEFAULT_MAX_ROWCOUNT_PER_SHEET = 65536;

    /**
     * function 创建workbook
     *
     * @return
     */
    public static Workbook createWorkbook(Object param) {
        Workbook workbook = null;
        try {
            // 通过文件路径创建 workbook
            if (param instanceof String) {
                InputStream inputStream = new FileInputStream((String) param);
                workbook = WorkbookFactory.create(inputStream);
            }
            // 通过输入流创建workbook
            if (param instanceof InputStream) {
                workbook = WorkbookFactory.create((InputStream) param);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;

    }

    /**
     * function 解析excel 单元格
     *
     * @param cell
     * @return
     */
    public static String getCellStringValue(Cell cell) {
        String content = "";
        if (cell != null) {
            int type = cell.getCellType();
            switch (type) {
                case Cell.CELL_TYPE_NUMERIC: // Numeric
                    if (DateUtil.isCellDateFormatted(cell)) {
                        content = (new SimpleDateFormat("yyyy-MM-dd")
                                .format(cell.getDateCellValue()));
                    } else {
                        double tempValue = cell.getNumericCellValue();
                        content = String.valueOf(tempValue);
                    }
                    break;
                case Cell.CELL_TYPE_STRING: // String
                    content = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_FORMULA: // Formula 公式, 方程式
                    content = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_BLANK: // Blank
                    content = "";
                    break;
                case Cell.CELL_TYPE_BOOLEAN: // boolean
                    boolean tempValue = cell.getBooleanCellValue();
                    content = String.valueOf(tempValue);
                    break;
                case Cell.CELL_TYPE_ERROR: // Error
                    byte b = cell.getErrorCellValue();
                    content = String.valueOf(b);
                    break;
            }
        }
        // 除去字符串中的空格
        return content.trim();
    }

    /**
     * function 空行判断
     *
     * @param row
     * @return
     */
    public static boolean checkNullRow(Row row) {

        boolean isNullLine = true;
        if (row != null) {
            // 总的单元格数
            int maxColNum = row.getLastCellNum();
            Cell cell;
            for (short colNum = 0; colNum <= maxColNum; colNum++) {
                // 获取一格
                cell = row.getCell(colNum);
                if (cell != null) {
                    // 获取单元格的值(String)
                    String value = getCellStringValue(cell);
                    if (StringUtils.isNotEmpty(value)) {
                        isNullLine = false;
                        return isNullLine;
                    }
                }
            }
        }
        return isNullLine;
    }

    /**
     * excel 导出
     *
     * @param sumHeaderList
     * @param sumDataList
     * @param headerList
     * @param dataList
     * @param fileName
     * @param response
     */
    public static void exportExcel(List<String> sumHeaderList,
                                   List<String> sumDataList,
                                   List<String> headerList,
                                   List<List<String>> dataList,
                                   String fileName,
                                   HttpServletResponse response) {

        try {
            // 参数空值保护
            if (headerList == null || dataList == null) {
                throw new IllegalArgumentException(
                        "invalid parameter:\r\ndataList=" + dataList
                                + "\r\ncolHeaders=" + headerList);
            }
            if (fileName == null) {
                throw new IllegalArgumentException("fileName is null.");
            }
            // 创建workbook
            Sheet sheet = null;
            Row row = null;
            Cell cell = null;
            HSSFWorkbook workbook = new HSSFWorkbook();
            int sheetNumber = 1;
            if (dataList.size() > DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1)
                sheetNumber = dataList.size() / (DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1) + 1;
            //字体设置
            //HSSFFont font = workbook.createFont();
            //font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗
            // HSSFCellStyle style = workbook.createCellStyle();
            //style.setFont(font);
            for (int sheetId = 0; sheetId < sheetNumber; sheetId++) {
                sheet = workbook.createSheet("Sheet" + (sheetId + 1));
                int rowNum = 0;
                int column = 0;
                row = sheet.createRow(rowNum);
                //创建汇总标题
                for (String text : sumHeaderList) {
                    cell = row.createCell(column++);
                    cell.setCellValue(text);// 填充值
                }
                //创建汇总数据
                rowNum++;
                row = sheet.createRow(rowNum);
                column = 0;
                for (String data : sumDataList) {
                    cell = row.createCell(column++);
                    cell.setCellValue(data);// 填充值
                }
                rowNum++;
                rowNum++;
                row = sheet.createRow(rowNum);
                column = 0;
                // 创建标题
                for (String hearderText : headerList) {
                    cell = row.createCell(column++);
                    cell.setCellValue(hearderText);// 填充值
                    //cell.setCellStyle(style);
                }
                // 创建数据
                for (int rowId = 0; rowId < DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1; rowId++) {
                    int realRowId = rowId + sheetId * (DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1);
                    if (realRowId > dataList.size() - 1)
                        break;
                    List<String> rowValue = dataList.get(realRowId);
                    column = 0;
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    for (String cellValue : rowValue) {
                        cell = row.createCell(column++);
                        cell.setCellValue(cellValue);// 填充值
                    }
                }
            }
            fileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
            OutputStream os = response.getOutputStream();
            fileName = fileName + ".xls";
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * excel 导出
     *
     * @param headerList
     * @param dataList
     * @param fileName
     * @param response
     * @return
     */
    public static void exportExcel(List<String> headerList, List<List<String>> dataList, String fileName, HttpServletResponse response) {

        try {
            // 参数空值保护
            if (headerList == null || dataList == null) {
                throw new IllegalArgumentException(
                        "invalid parameter:\r\ndataList=" + dataList
                                + "\r\ncolHeaders=" + headerList);
            }
            if (fileName == null) {
                throw new IllegalArgumentException("fileName is null.");
            }
            // 创建workbook
            Sheet sheet = null;
            Row row = null;
            Cell cell = null;
            // Workbook workbook = ExcelUtils.createWorkbook("D:\\test.xlsx");
            HSSFWorkbook workbook = new HSSFWorkbook();
            int sheetNumber = 1;
            if (dataList.size() > DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1)
                sheetNumber = dataList.size() / (DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1) + 1;
            for (int sheetId = 0; sheetId < sheetNumber; sheetId++) {
                sheet = workbook.createSheet("Sheet" + (sheetId + 1));
                int rowNum = 0;
                int column = 0;
                row = sheet.createRow(rowNum);
                // 创建标题
                for (String hearderText : headerList) {
                    cell = row.createCell(column++);
                    cell.setCellValue(hearderText);// 填充值

                }
                // 创建数据
                for (int rowId = 0; rowId < DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1; rowId++) {
                    int realRowId = rowId + sheetId * (DEFAULT_MAX_ROWCOUNT_PER_SHEET - 1);
                    if (realRowId > dataList.size() - 1)
                        break;
                    List<String> rowValue = dataList.get(realRowId);
                    column = 0;
                    rowNum++;
                    row = sheet.createRow(rowNum);
                    for (String cellValue : rowValue) {
                        cell = row.createCell(column++);
                        cell.setCellValue(cellValue);// 填充值
                    }
                }
            }
            fileName = new String(fileName.getBytes("GBK"), "ISO8859_1");
            OutputStream os = response.getOutputStream();
            fileName = fileName + ".xls";
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
