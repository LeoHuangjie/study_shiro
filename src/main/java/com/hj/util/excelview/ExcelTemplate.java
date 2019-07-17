package com.hj.util.excelview;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * @author
 * @date 2017年11月02日 16:16
 */
public interface ExcelTemplate extends Itor {
    /**
     * 页签描述
     * @return
     */
    String sheetDesc();

    /**
     * 头部
     * @return
     */
    List<String> headerList();

    /**
     * 最后一行是否设置成红色
     * @return
     */
    boolean lastRowRed();

    void buildExcel(Workbook workbook);
}
