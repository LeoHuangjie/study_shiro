/**
 * @author LiuYu
 * @date 2016年06月27日 13:37
 * @version v1.00
 */
package com.hj.util.excelview.util;

public class ExcelValue {

    private boolean isNumberCell;
    private String value;

    public ExcelValue(String value){
        isNumberCell = false;
        this.value = value;
    }

    public ExcelValue(boolean isNumberCell,String value){
        this.isNumberCell = isNumberCell;
        this.value = value;
    }

    public boolean isNumberCell() {
        return isNumberCell;
    }

    public void setNumberCell(boolean isNumberCell) {
        this.isNumberCell = isNumberCell;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
