package com.hj.util;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.google.common.collect.Maps;
import com.hj.excel.ExcelBody;
import com.hj.excel.ExcelEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

public class ExportExcel {

    /**
     * @param fileName 文件名
     * @throws IOException
     */
    public static SXSSFWorkbook exportExcel(HttpServletRequest request, HttpServletResponse response, String fileName,
                                           ExcelEntity excelEntity) throws IOException {
        // 设置请求
        response.setHeader("Content-disposition",
                "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));

        response.setContentType("application/msexcel;charset=UTF-8");

        // 创建一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook();

        //设置单元格样式
        CellStyle style = createExcelStyle(workbook);

        //设置单元格样式(不设置颜色)
        CellStyle excelStyleNoColor = createExcelStyleNoColor(workbook);

        // 生成一个表格
        SXSSFSheet sheet = workbook.createSheet("表单导出");


        //每一天日期对应的列序号 （key:日期，value:列序号）
        Map<Date, Integer> dateCloumNumHashMap = Maps.newHashMap();

        // 产生表格标题行 第三行 index=2
        //创建表头
        createExcelHeadTable(sheet, style, excelStyleNoColor, excelEntity, dateCloumNumHashMap);


        // 遍历集合数据，产生数据行 ------------------------------------------------------

        //获取时间模版
        List<String> timeTable = excelEntity.getTimeTable();

        //key：teacherId
        Map<Integer, ExcelBody> excelBodyMap = excelEntity.getExcelBody();

        //rowNum = 3; 从第四行开始
        int rowNum = 3;

        for (Integer teacherId : excelBodyMap.keySet()) {

            ExcelBody excelBody = excelBodyMap.get(teacherId);

            //key:行号  value：时间模版的时段
            Map<Integer, String> numValueMap = Maps.newHashMap();

            //创建教师基础信息 numValueMap key:行号  value：时间模版的时段
            rowNum = createExcelNormalInfoBody(sheet, excelStyleNoColor, style, timeTable, excelBody, rowNum, numValueMap);

            //组装老师时间详情
            createTeacherTimeInfo(sheet,excelBody,dateCloumNumHashMap,numValueMap, workbook);

        }
        // 打开流
        OutputStream outputStream = response.getOutputStream();
        // XSSSFWorkbook写入流
        workbook.write(outputStream);
        // XSSSFWorkbook关闭
        workbook.close();
        // 刷新流
        outputStream.flush();
        // 关闭流
        outputStream.close();
        return workbook;
    }


    /**
     * 设置表头
     *
     * @param sheet
     * @param style
     * @param excelEntity
     * @param dateCloumNumHashMap
     */
    private static void createExcelHeadTable(SXSSFSheet sheet, CellStyle style, CellStyle excelStyleNoColor, ExcelEntity excelEntity, Map<Date, Integer> dateCloumNumHashMap) {
        int i = 0;
        //第三行开始创建表头
        SXSSFRow row = sheet.createRow(2);

        List<String> tableHeadName = excelEntity.getTableHeadName();
        for (String tableHead : tableHeadName) {
            SXSSFCell cell = row.createCell(i);
            cell.setCellValue(tableHead);
            cell.setCellStyle(style);
            ++i;
        }

        Map<Date, String> frameTime = excelEntity.getFrameTime();
        for (Date fTime : frameTime.keySet()) {
            String dateName = frameTime.get(fTime);
            SXSSFCell cell = row.createCell(i);
            cell.setCellValue(dateName);
            cell.setCellStyle(style);
            dateCloumNumHashMap.put(fTime, i);
            ++i;
        }

        //前两行合并大标题
        sheet.addMergedRegion(new CellRangeAddress(
                0,
                1,
                0,
                i - 1
        ));

        SXSSFCell cell1 = sheet.createRow(0).createCell(0);
        cell1.setCellValue("空闲时间表");
        cell1.setCellStyle(excelStyleNoColor);
    }


    /**
     * 设置单元格样式
     *
     * @param workbook
     * @return
     */
    private static CellStyle createExcelStyle(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();

        // 左右居中
        style.setAlignment(HorizontalAlignment.CENTER);

        //上下居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        //设置背景颜色-灰色
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK1.getIndex());
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK1.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());


        //自动换行
        style.setWrapText(true);

        return style;
    }

    /**
     * 设置单元格样式 不设置颜色
     *
     * @param workbook
     * @return
     */
    private static CellStyle createExcelStyleNoColor(SXSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();

        // 左右居中
        style.setAlignment(HorizontalAlignment.CENTER);

        //上下居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        //自动换行
        style.setWrapText(true);

        return style;
    }

    /**
     *
     * @param sheet
     * @param style
     * @return key:行号  value：时间模版的时段
     */
    private static int createExcelNormalInfoBody(SXSSFSheet sheet, CellStyle excelStyleNoColor, CellStyle style, List<String> timeTable, ExcelBody excelBody, int rowNum, Map<Integer, String> numValueMap) {

        //rowNum = 3; 从第四行开始
        //列序号
        int cloumNum = 0;

        //教师普通信息
        SXSSFRow row = sheet.createRow(rowNum);
        cloumNum = normalTeacherInfo(sheet, excelBody, timeTable.size(), cloumNum, rowNum, excelStyleNoColor, row);


        for (String tt : timeTable) {
            SXSSFCell cell = row.createCell(cloumNum);
            cell.setCellValue(tt);
            cell.setCellStyle(style);
            numValueMap.put(rowNum, tt);
            row = sheet.createRow(++rowNum);
        }
        return rowNum;
    }

    /**
     * 教师普通信息
     * @param sheet
     * @param excelBody
     * @param timetableSize
     * @param cloumNum
     * @param style
     * @return
     */
    private static int normalTeacherInfo (SXSSFSheet sheet, ExcelBody excelBody, int timetableSize, int cloumNum, int rowNum, CellStyle style, SXSSFRow row) {

        SXSSFCell cell2 = row.createCell(cloumNum);
        cell2.setCellValue(excelBody.getTeacherName());
        sheet.addMergedRegion(new CellRangeAddress(
                rowNum,
                rowNum + timetableSize - 1,
                cloumNum,
                cloumNum++
        ));
        cell2.setCellStyle(style);

        SXSSFCell cell3 = row.createCell(cloumNum);
        cell3.setCellValue(excelBody.getHaveClassTime());
        sheet.addMergedRegion(new CellRangeAddress(
                rowNum,
                rowNum + timetableSize - 1,
                cloumNum,
                cloumNum++
        ));
        cell3.setCellStyle(style);

        SXSSFCell cell4 = row.createCell(cloumNum);
        cell4.setCellValue(excelBody.getCourseTime());
        sheet.addMergedRegion(new CellRangeAddress(
                rowNum,
                rowNum + timetableSize - 1,
                cloumNum,
                cloumNum++
        ));
        cell4.setCellStyle(style);
        return cloumNum;
    }

    /**
     * 组装老师时间详情
     * @param sheet
     * @param
     * @param excelBody
     * @param dateCloumNumHashMap （key:日期，value:列序号）
     * @param numValueMap key:行号  value：时间模版的时段
     */
    private static void createTeacherTimeInfo (SXSSFSheet sheet, ExcelBody excelBody, Map<Date, Integer> dateCloumNumHashMap, Map<Integer, String> numValueMap, SXSSFWorkbook workbook) {
        //教师开放时间详情 key:日期  value:(key:模版时间段，value：状态)
        Map<Date, Map<String, Integer>> frameTimeInfo = excelBody.getFrameTimeInfo();

        for (Date date : frameTimeInfo.keySet()) {
            //获取列序号
            Integer cloumNum = dateCloumNumHashMap.get(date);

            //获取详情 key:时间模版的每一个时段  value：每个时段老师的时间状态
            Map<String, Integer> teacherTimeStatusMap = frameTimeInfo.get(date);

            //继续组装老师的每一个时间段的时间详情
            processCreateTeacherTimeInfo(numValueMap, teacherTimeStatusMap, sheet, workbook, cloumNum);
        }
    }

    /**
     * 继续组装老师的每一个时间段的时间详情
     * @param numValueMap key:行号  value：时间模版的时段
     * @param teacherTimeStatusMap 获取详情 key:时间模版的每一个时段  value：每个时段老师的时间状态
     * @param sheet
     * @param
     * @param cloumNum
     */
    private static void processCreateTeacherTimeInfo (Map<Integer, String> numValueMap, Map<String, Integer> teacherTimeStatusMap, SXSSFSheet sheet, SXSSFWorkbook workbook, Integer cloumNum) {
        for (Integer rowNum : numValueMap.keySet()) {

            String timeTable1 = numValueMap.get(rowNum);

            Integer status = teacherTimeStatusMap.get(timeTable1);


            String val = null;
            if (status == 0) {
                val = "√";
            } else if (status == 1) {
                val = "上课";
            } else if (status == 2) {
                val = "请假";
            }

            //rowNum为行号
            SXSSFRow rowPrivate = sheet.getRow(rowNum);
            SXSSFCell cell = rowPrivate.createCell(cloumNum);
            cell.setCellValue(val);

            CellStyle style = createExcelStyle(workbook);

            if (status == 0) {
                style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
            } else if (status == 1) {
                style.setFillForegroundColor(IndexedColors.RED.index);
            } else if (status == 2) {
                style.setFillForegroundColor(IndexedColors.SKY_BLUE.index);
            }

            cell.setCellStyle(style);
        }
    }
}

