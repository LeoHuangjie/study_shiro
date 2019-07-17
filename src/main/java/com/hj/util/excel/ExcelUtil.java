package com.hj.util.excel;


import cn.hutool.core.io.FileUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.util.StyleUtil;
import com.google.common.collect.Lists;
import com.hj.entity.excel.BaseReadModel;
import com.hj.util.ExceptionMessageUtil;
import lombok.Cleanup;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.hj.util.excel.DataUtil.*;

/**
 * @author huangjie
 * @time 2019-05-28 10:08
 */
public class ExcelUtil {

    /**
     * 07版本excel读数据量少于1千行数据，内部采用回调方法.
     * headLineMun 0 读取表头
     * @return
     */
    public static List<Object> simpleReadListStringV2007 (String url) {

        InputStream inputStream = null;
        List<Object> read = Lists.newArrayList();
        try {
            inputStream = FileUtil.getInputStream(url);
            read = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        } catch (Exception e) {
            ExceptionMessageUtil.getExceptionMessage(e);
        } finally {
            closeIO(inputStream);
        }
        return read;
    }

    /**
     * 07版本excel读数据量少于1千行数据，内部采用回调方法.
     * inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
     * @return
     */
    public static List<Object> simpleReadJavaModelV2007 (String url, Class<? extends BaseRowModel> clazz) {

        InputStream inputStream = null;
        List<Object> read = Lists.newArrayList();
        try {
            inputStream = FileUtil.getInputStream(url);
            read = EasyExcelFactory.read(inputStream, new Sheet(1, 1, clazz));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeIO(inputStream);
        }
        return read;
    }



    /**
     * 07版本excel读数据量大于1千行，内部采用回调方法.
     *
     * @throws IOException
     * @throws  Exception
     */
    public static void saxReadListStringV2007(String url) {
        InputStream inputStream = null;
        try {
            inputStream = FileUtil.getInputStream(url);
            // 解析每行结果在listener中处理
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1), excelListener);
        } catch (Exception e) {
            ExceptionMessageUtil.getExceptionMessage(e);
        } finally {
            closeIO(inputStream);
        }
    }


    /**
     * 07版本excel读数据量大于1千行，内部采用回调方法.
     *
     * @throws Exception
     */
    public static void saxReadJavaModelV2007(String path, Class<? extends BaseRowModel> clazz) {
        InputStream inputStream = null;
        try {
            inputStream = FileUtil.getInputStream(path);
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, clazz), excelListener);
        } catch (Exception e) {
            ExceptionMessageUtil.getExceptionMessage(e);
        } finally {
            closeIO(inputStream);
        }
    }



    /**
     * 07版本excel读取sheet
     * @param clazz 从第二页的model开始
     *
     * @throws IOException
     */
    public static void saxReadSheetsV2007(String path, Class<? extends BaseReadModel>... clazz) {
        InputStream inputStream = null;
        try {
            inputStream = FileUtil.getInputStream(path);
            ExcelListener excelListener = new ExcelListener();
            ExcelReader excelReader = EasyExcelFactory.getReader(inputStream,excelListener);

            List<Sheet> sheets = excelReader.getSheets();

            for (int i = 0; i < sheets.size(); i++) {
                Sheet sheet = sheets.get(i);
                if(sheet.getSheetNo() > 1) {
                    sheet.setHeadLineMun(1);
                    sheet.setClazz(clazz[i]);
                }
                excelReader.read(sheet);
            }

        } catch (Exception e) {
            ExceptionMessageUtil.getExceptionMessage(e);
        } finally {
            closeIO(inputStream);
        }
    }


    /**
     * excel文件流输出到浏览器，选择下载路径
     * 设置列宽 设置每列的宽度
     * Map columnWidth = new HashMap();
     * columnWidth.put(0,10000);columnWidth.put(1,40000);columnWidth.put(2,10000);columnWidth.put(3,10000);
     * sheet1.setColumnWidthMap(columnWidth);
     */
    public static void writeV2007(HttpServletResponse response, String fileName,  List<List<Object>> objList, List<List<String>> headName) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLSX.getValue());

        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 1);

        sheet1.setHead(headName);
        //设置自适应宽度
        sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(objList, sheet1);

        writer.finish();
        outputStream.close();
    }


    /**
     * 模型上打有表头的注解，合并单元格
     * 需要合并单元格
     * writer.merge(5,20,1,1);
     * 自定义设置格式
     * @param clazz
     * @param fileName
     * @param response
     * @param modelList
     * @throws IOException
     */
    public static void writeV2007WithAnnotation(HttpServletResponse response, Class<? extends BaseRowModel> clazz, String fileName, List<? extends BaseRowModel> modelList) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLSX.getValue());

        //写sheet sheet2  模型上打有表头的注解，合并单元格
        Sheet sheet = new Sheet(2, 3, clazz);
        //设置单元格格式
        sheet.setTableStyle(createTableStyle());

        writer.write(modelList, sheet);

        writer.finish();
    }


    /**
     * withTable
     * 需传入表头名字
     * @param fileName
     * @param response
     * @param headName
     * @param data
     * @throws IOException
     */
    public static void writeV2007WithTable(HttpServletResponse response, String fileName, List<List<String>> headName, List<List<Object>> data) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLSX.getValue());

        Sheet sheet = new Sheet(1, 0);
        sheet.setAutoWidth(Boolean.TRUE);
        Table table = new Table(1);
        table.setHead(headName);
        writer.write1(data, sheet, table);
        writer.finish();
    }

    /**
     * withTable
     * 模型上打有表头的注解
     * @param response
     * @param fileName
     * @param clazz
     * @param modelList
     * @throws IOException
     */
    public void writeV2007 ( HttpServletResponse response, String fileName, Class<? extends BaseReadModel> clazz, List<? extends BaseReadModel> modelList) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLSX.getValue());
        //写第三个sheet包含多个table情况
        Sheet sheet = new Sheet(3, 0);
        sheet.setAutoWidth(Boolean.TRUE);
        sheet.setStartRow(30);

        //写sheet2  模型上打有表头的注解
        Table table = new Table(1);
        table.setTableStyle(createTableStyle());
        table.setClazz(clazz);
        writer.write(modelList, sheet, table);
        writer.finish();
    }


    /**
     * 传header
     * @param response
     * @param fileName
     * @param data
     * @throws IOException
     */
    public void writeV2003(HttpServletResponse response, String fileName, List<List<Object>> data, List<List<String>> header) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLS.getValue());
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);

        sheet1.setHead(header);
        //设置自适应宽度
        sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(data, sheet1);
        writer.finish();
    }

    /**
     * 模型上打有表头的注解
     * 设置样式        sheet2.setTableStyle(createTableStyle());
     * @param response
     * @param fileName
     * @param clazz
     * @param data
     * @throws IOException
     */
    public void writeV2003(HttpServletResponse response, String fileName, Class<? extends BaseReadModel> clazz, List<? extends BaseReadModel> data) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLS.getValue());

        //写第二个sheet
        Sheet sheet = new Sheet(1, 3, clazz);
        sheet.setAutoWidth(Boolean.TRUE);

        writer.write(data, sheet);
    }

    /**
     * WithTable
     * 模型上打有表头的注解
     * @param response
     * @param fileName
     * @param clazz
     * @param data
     * @throws IOException
     */
    public void writeV2003WithTable (HttpServletResponse response, String fileName, Class<? extends BaseReadModel> clazz, List<? extends BaseReadModel> data) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();

        ExcelWriter writer = setHeadResponse(response, outputStream, fileName, ExcelTypeEnum.XLS.getValue());

        //写第三个sheet包含多个table情况
        Sheet sheet = new Sheet(1, 0);

        Table table = new Table(2);
        table.setTableStyle(createTableStyle());
        table.setClazz(clazz);
        writer.write(data, sheet, table);
    }


    private static void closeIO (InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            ExceptionMessageUtil.getExceptionMessage(e);
        }
    }


    private static ExcelWriter setHeadResponse (HttpServletResponse response, ServletOutputStream outputStream, String fileName, String last) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String newsNo = df.format(new Date());
        String downFileName= newsNo+"_"+fileName;
        response.setContentType("multipart/form-data");
        response.addHeader("Content-Disposition","attachment;filename=" +new String(downFileName.getBytes("utf-8"),"ISO-8859-1" )+ last);

        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
        return writer;
    }


}
