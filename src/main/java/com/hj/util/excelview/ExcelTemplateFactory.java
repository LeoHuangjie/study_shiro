package com.hj.util.excelview;

import org.springframework.web.servlet.View;

public class ExcelTemplateFactory {
    public static View getView(ExcelTemplate excelTemplate){
      return new PagedExcelView(excelTemplate);
    }
}
