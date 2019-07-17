/**
 * @author LiuYu
 * @date 2016年06月27日 13:50
 * @version v1.00
 */
package com.hj.util.excelview;

import cn.hutool.core.date.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Date;
import java.util.Random;

/**
 * Excel模板抽象类
 * @author LiuYu
 * @date 2016年06月27日 13:50
 * @since
 */
public class PagedExcelView extends AbstractSupportPagedExcelView {

    public static final String DATA_KEY = "contentList";

    public static final int MAX_ROWS = 1048576;

    public static final int PAGE_SIZE = 500;

    private ExcelTemplate excelTemplate;

    public PagedExcelView(){}

    public PagedExcelView(ExcelTemplate excelTemplate){
        this.excelTemplate = excelTemplate;
    }

    @Override
    protected String buildExcelDocument(Workbook workbook) throws Exception {
//        List<List<ExcelValue>> contentList = (List<List<ExcelValue>>)map.get(DATA_KEY);
        logger.info("white tmp path:{}",System.getProperty("java.io.tmpdir"));
//      buildExcel(contentList,workbook,request,response);
        excelTemplate.buildExcel(workbook);
        Random rnd = new Random();
        int num = rnd.nextInt(89999) + 10000;
        return excelTemplate.sheetDesc()+"_"+ DateUtil.formatDate(new Date())+"_"+num;
    }


    private int getInitLng(int totalRowCount) {
        int x = totalRowCount / MAX_ROWS ;
        return getLen(x+1);
    }

    public int getLen(int x){
        if(x<10) return 1;
        return getLen(x/10)+1;
    }
}
