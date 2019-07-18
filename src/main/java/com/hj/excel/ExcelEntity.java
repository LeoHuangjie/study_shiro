package com.hj.excel;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author huangjie
 * @time 2019-07-17 19:10
 */
@Data
public class ExcelEntity implements Serializable {
    /**
     * 时间详情之前的表头
     */
    private List<String> tableHeadName;

    /**
     * 每天的表头
     */
    private Map<Date, String> frameTime;

    /**
     * 时间模版
     */
    private List<String> timeTable;


    /**
     * 详情
     */
    private Map<Integer, ExcelBody> excelBody;
}
