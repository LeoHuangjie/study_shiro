package com.hj.excel;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author huangjie
 * @time 2019-07-17 17:48
 */
@Data
public class ExcelBody implements Serializable {
    private String teacherName;

    private Integer teacherId;
    /**
     * 已上课小时数
     */
    private Double haveClassTime;

    /**
     * 课排课小时数
     */
    private Double courseTime;

    /**
     * key: 日期  value: 老师时间详情
     */
    private Map<Date, Map<String,Integer>> frameTimeInfo;
}
