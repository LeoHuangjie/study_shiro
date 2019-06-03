package com.hj.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @ExcelProperty(index = 3)数字代表该字段与excel对应列号做映射，
 * 也可以采用 @ExcelProperty(value = {"一级表头","二级表头"})
 * 用于解决不确切知道excel第几列和该字段映射，位置不固定，但表头的内容知道的情况。
 */
public class BaseReadModel extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String str;

    @ExcelProperty(index = 1)
    private Float ff;

    public String getStr() {
        return str;
    }


    public void setStr(String str) {
        this.str = str;
    }

    public Float getFf() {
        return ff;
    }

    public void setFf(Float ff) {
        this.ff = ff;
    }
}
