package com.hj.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hj.excel.ExcelBody;
import com.hj.excel.ExcelEntity;
import com.hj.util.DateUtil;
import com.hj.util.ExportExcel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author huangjie
 * @time 2019-07-17 18:10
 */
@RestController
@RequestMapping("/excel")
public class ExportExcelController {

    @RequestMapping("export")
    public void test (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExcelEntity excelEntity = new ExcelEntity();

        List<String> tableHeadName = Lists.newArrayList();
        tableHeadName.add("教师");
        tableHeadName.add("已上课小时数");
        tableHeadName.add("可排课小时数");
        tableHeadName.add("时段");
        excelEntity.setTableHeadName(tableHeadName);

        Map<Date, String> map = Maps.newHashMap();
        map.put(DateUtil.stringToDate("2019-07-01 00:00"),"7月1号");
        map.put(DateUtil.stringToDate("2019-07-02 00:00"),"7月2号");
        map.put(DateUtil.stringToDate("2019-07-03 00:00"),"7月3号");
        map.put(DateUtil.stringToDate("2019-07-04 00:00"),"7月4号");
        map.put(DateUtil.stringToDate("2019-07-05 00:00"),"7月5号");
        map.put(DateUtil.stringToDate("2019-07-06 00:00"),"7月6号");
        map.put(DateUtil.stringToDate("2019-07-07 00:00"),"7月7号");
        map.put(DateUtil.stringToDate("2019-07-08 00:00"),"7月8号");
        map.put(DateUtil.stringToDate("2019-07-09 00:00"),"7月9号");
        map.put(DateUtil.stringToDate("2019-07-10 00:00"),"7月10号");
        excelEntity.setFrameTime(map);

        List<String> timeTable = Lists.newArrayList();
        timeTable.add("08:00-09:30");
        timeTable.add("09:40-11:10");
        timeTable.add("11:20-12:50");
        timeTable.add("13:00-14:30");
        timeTable.add("14:40-16:10");
        timeTable.add("16:20-17:50");
        timeTable.add("18:30-20:00");
        timeTable.add("20:10-21:40");
        excelEntity.setTimeTable(timeTable);

        Map<Integer, ExcelBody> excelBodyMap = Maps.newHashMap();
        ExcelBody excelBody = new ExcelBody();
        excelBody.setCourseTime(12.5D);
        excelBody.setHaveClassTime(13.5D);
        excelBody.setTeacherId(1);
        excelBody.setTeacherName("小黑");


        Map<Date, Map<String,Integer>> statusMap = Maps.newHashMap();

        Map<String,Integer> timeTableStatusMap = Maps.newHashMap();
        timeTableStatusMap.put("08:00-09:30",1);
        timeTableStatusMap.put("09:40-11:10",0);
        timeTableStatusMap.put("11:20-12:50",0);
        timeTableStatusMap.put("13:00-14:30",0);
        timeTableStatusMap.put("14:40-16:10",0);
        timeTableStatusMap.put("16:20-17:50",0);
        timeTableStatusMap.put("18:30-20:00",0);
        timeTableStatusMap.put("20:10-21:40",0);

        statusMap.put(DateUtil.stringToDate("2019-07-01 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-02 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-03 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-04 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-05 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-06 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-07 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-08 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-09 00:00"),timeTableStatusMap);
        statusMap.put(DateUtil.stringToDate("2019-07-10 00:00"),timeTableStatusMap);

        excelBody.setFrameTimeInfo(statusMap);

        excelBodyMap.put(1,excelBody);
        excelBodyMap.put(2,excelBody);

        excelEntity.setExcelBody(excelBodyMap);

        ExportExcel.exportExcel(request,response,"aaa",excelEntity);
    }
}
