package com.hj.util.excelview;

import com.hj.util.excelview.util.ExcelValue;
import com.hj.util.excelview.util.PagedExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public abstract class ExcelWithBuildTemplate implements ExcelTemplate {

    public static final int MAX_ROWS = 1048576;

    private int pageSize = 300;

    private List<String> headerList;

    private String sheetDesc;

    private boolean lastRowRed;

    public ExcelWithBuildTemplate() {
    }

    public ExcelWithBuildTemplate(String sheetDesc,List<String> headerList,boolean lastRowRed) {
        this.headerList = headerList;
        this.sheetDesc = sheetDesc;
        this.lastRowRed = lastRowRed;
    }

    public ExcelWithBuildTemplate(String sheetDesc,List<String> headerList,boolean lastRowRed,int pageSize) {
        this.headerList = headerList;
        this.sheetDesc = sheetDesc;
        this.lastRowRed = lastRowRed;
        if(pageSize > 0){
            this.pageSize = pageSize;
        }
    }

    @Override
    public List<String> headerList() {
        return headerList;
    }

    @Override
    public String sheetDesc() {
        return sheetDesc;
    }

    @Override
    public boolean lastRowRed() {
        return lastRowRed;
    }

    public void buildExcel(Workbook workbook) {
        long totalRowCount = total();
        if (0 == totalRowCount) {
            Sheet sheet = workbook.createSheet(sheetDesc());
            PagedExcelUtil.createExcelSheetHead(sheet, headerList());
            return;
        }
        long pages = totalRowCount / pageSize;
        long totalPageCount = totalRowCount % pageSize == 0 ? pages : pages + 1;

        long lngOfIndex = getLongLng(totalRowCount);
        // 算出 stringBuffer 的最大可能 size 以减少 stringBuffer 扩容带来的开销
        long initSize = Math.max((sheetDesc().length() + lngOfIndex), (9 + lngOfIndex * 2));
        StringBuffer stringBuffer = new StringBuffer((int)initSize);

        Sheet sheet = null;
        int sheetCount = 0;
        int nowLine = 0;
        for (int pageNo = 1; pageNo <= totalPageCount; pageNo++) {
            // 如果 当前是第一次查询 (sheet == null) 或 此次查询后预计超过 MAX_ROWS

            List<List<ExcelValue>> bodyRowLists = fetch(pageNo, pageSize);
            nowLine += bodyRowLists.size();
            if (nowLine > sheetCount * MAX_ROWS) {

                // 如果 sheet 已经存在
                if (sheet != null) {
                    // 生成新的 sheet 之前先把上一 sheet 的 foot 写上
                    stringBuffer.setLength(0);
                    stringBuffer.append("Page ").append(HSSFFooter.page()).append(" of ").append(HSSFFooter.numPages());
                    PagedExcelUtil.createExcelSheetFoot(sheet, stringBuffer.toString());
                }

                // 生成新的 sheet
                sheetCount++;
                stringBuffer.setLength(0);
                stringBuffer.append(sheetDesc()).append("_").append(sheetCount);
                sheet = workbook.createSheet(stringBuffer.toString());
                PagedExcelUtil.createExcelSheetHead(sheet, headerList());

            }
            // 循环添加 Excel表 sheet 的 内容行
            PagedExcelUtil.createExcelSheetBody(sheet, bodyRowLists);
        }
        if (sheet != null) {
            stringBuffer.setLength(0);
            stringBuffer.append("Page ").append(HSSFFooter.page()).append(" of ").append(HSSFFooter.numPages());
            PagedExcelUtil.createExcelSheetFoot(sheet, stringBuffer.toString());
        }
    }

    private long getLongLng(long totalRowCount) {
        long x = totalRowCount / MAX_ROWS;
        return getLen(x + 1);
    }

    public long getLen(long x) {
        if (x < 10) return 1;
        return getLen(x / 10) + 1;
    }

}
