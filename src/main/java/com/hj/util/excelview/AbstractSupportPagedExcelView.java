/**
 * @author LiuYu
 * @date 2016年06月30日 18:15
 * @version v1.00
 */
package com.hj.util.excelview;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.LocalizedResourceHelper;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Locale;
import java.util.Map;

/**
 * Excel增强导出
 * @author
 * @since
 */
public abstract class AbstractSupportPagedExcelView extends AbstractView {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    private static final String EXTENSION = ".xlsx";
    private String url;

    public AbstractSupportPagedExcelView() {
        setContentType(CONTENT_TYPE);
    }
    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        long startTime = System.currentTimeMillis();
        String tmp = System.getProperty("java.io.tmpdir");
        File tmpDir = new File(tmp);
        if(!tmpDir.exists()){
            tmpDir.mkdir();
        }
        logger.info("Created Excel Workbook from scratch,tmp dir:{}",tmp);
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
//        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream byteArrayOutputStream = createTemporaryOutputStream();
        //String fileName = buildExcelDocument(model, workbook, request, response);
        String fileName = buildExcelDocument(workbook);
        workbook.write(byteArrayOutputStream);
        String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName + EXTENSION);
        writeToResponse(response, byteArrayOutputStream);
        long endTime = System.currentTimeMillis();
        logger.info(fileName+"用时="+((endTime-startTime)/1000)+"秒");
    }

    protected Workbook getTemplateSource(String url, HttpServletRequest request) throws Exception {
        LocalizedResourceHelper helper = new LocalizedResourceHelper(getApplicationContext());
        Locale userLocale = RequestContextUtils.getLocale(request);
        Resource inputFile = helper.findLocalizedResource(url, EXTENSION, userLocale);

        if (logger.isDebugEnabled()) {
            logger.debug("Loading Excel workbook from " + inputFile);
        }
        return new XSSFWorkbook(inputFile.getInputStream());
    }

    /*
    protected abstract String buildExcelDocument(
            Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception;
            */

    protected abstract String buildExcelDocument(Workbook workbook) throws Exception;

    protected Cell getCell(Sheet sheet, int row, int col) {
        Row sheetRow = sheet.getRow(row);
        if (sheetRow == null) {
            sheetRow = sheet.createRow(row);
        }
        Cell cell = sheetRow.getCell(col);
        if (cell == null) {
            cell = sheetRow.createCell(col);
        }
        return cell;
    }
    protected void setText(Cell cell, String text) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(text);
    }
}
