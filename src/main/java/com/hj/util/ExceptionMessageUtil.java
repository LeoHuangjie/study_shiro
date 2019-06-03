package com.hj.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author huangjie
 * @time 2019-05-30 14:28
 */
public class ExceptionMessageUtil {

    public static String getExceptionMessage(Exception ex) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        return sw.toString();
    }
}
