/**
 * poi工具类
 *
 * @author xionglingjun
 * @date 2015年05月15日 17:14
 * @version v1.00
 */
package com.hj.util.excelview.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * poi工具类
 * 
 * @author xionglingjun
 * @date 2015年05月15日 17:14
 * @since
 */
public class PagedExcelUtil {

    private final static Logger logger = LoggerFactory.getLogger(PagedExcelUtil.class);

    /**
     * 创建整个Excel表
     * @param sheet 页签
     * @param headerList 头部
     * @param contentList 内容
     */
    public static void createExcelSheet(Sheet sheet, List<String> headerList, List<List<ExcelValue>> contentList){
        logger.debug("createExcelSheet contentList.size : {}",contentList.size());
        //创建一个表头行
        // 设置表头，从sheet中得到
        Header header = sheet.getHeader();
        header.setCenter("用户表");
        // 创建一行
        Row headerRow = sheet.createRow(0);
        int headerIndex = 0;
        for(String headerValue : headerList){
            Cell headerCell = headerRow.createCell(headerIndex++);
            headerCell.setCellValue(headerValue);
        }

        
    }

    /**
     * 字体样式
     * @param workbook 工作薄
     * @return
     */
    private static CellStyle buildRedStyle(Workbook workbook){
        CellStyle style = workbook.createCellStyle(); // 样式对象
        Font font = workbook.createFont();
        font.setColor(HSSFColor.RED.index);//红色字体
        style.setFont(font);
        return style;
    }

    /**
     * 创建 Excel 表一个 sheet 中的内容部分
     * @param sheet 页签
     * @param bodyRowLists 内容部分
     */
    public static void createExcelSheetBody(Sheet sheet, List<List<ExcelValue>> bodyRowLists) {
        int rowIndex = sheet.getLastRowNum()+1;
        Row row;
        for(List<ExcelValue> list : bodyRowLists){
            row = sheet.createRow(rowIndex++);
            int cellIndex = 0;
            Cell cell;
            for(ExcelValue excelValue : list){
                cell = row.createCell(cellIndex++);
                if(excelValue.isNumberCell()){
                    cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(Double.valueOf(excelValue.getValue()));
                }else{
                    cell.setCellValue(excelValue.getValue());
                }
            }
        }
    }

    /**
     * 创建 Excel 表一个 sheet 中的尾部内容部分
     * @param sheet 页签
     * @param foot 尾部内容
     */
    public static void createExcelSheetFoot(Sheet sheet, String foot) {
        Footer footer = sheet.getFooter();
        footer.setRight(foot);
    }

    /**
     * 创建 Excel 表一个 sheet 中的表头行内容部分
     * @param sheet 页签
     * @param headerList 表头行内容
     */
    public static void createExcelSheetHead(Sheet sheet, List<String> headerList) {
        logger.info("createExcelSheet headerList : {}",headerList);
        //创建一个表头行
        // 设置表头，从sheet中得到
        Header header = sheet.getHeader();
        header.setCenter("用户表");
        // 创建一行
        Row headerRow = sheet.createRow(0);
        int headerIndex = 0;
        for(String headerValue : headerList){
            Cell headerCell = headerRow.createCell(headerIndex++);
            headerCell.setCellValue(headerValue);
        }
    }
}
