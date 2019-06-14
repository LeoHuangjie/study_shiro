package com.hj.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author huangjie
 * @time 2019-06-14 15:27
 */
public class MyDateUtils extends DateUtils {
//    public static final String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
//    public static final String DATE_FORMAT_PAR = "yyyy-MM-dd";
//
//    public static boolean isDate(String s) {
//        return parseDate(s) != null;
//    }
//
//    public static String getCurrentDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String sDate = sdf.format(new Date());
//        return sDate;
//    }
//
//    // 传入一个时间，获取当前时间的获取年份
//    public static int getYear(String date) {
//        return getYear(getDateFromString(date));
//    }
//
//    // 传入一个时间，获取当前时间的获取年份
//    public static int getYear(Date date) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return cal.get(Calendar.YEAR);
//    }
//
//    // 传入一个字符串格式的时间，获取当前时间的获取月份
//    public static int getMonth(String date) {
//        return Integer.parseInt(date.split("-")[1]);
//    }
//
//    // 传入一个时间，获取当前时间的获取月份
//    public static int getMonth(Date date) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return cal.get(Calendar.MONTH) + 1;
//    }
//
//    // 获取日
//    public static int getDayOfMonth(String date) {
//        return getDayOfMonth(getDateFromString(date));
//    }
//
//    // 获取日
//    public static int getDayOfMonth(Date date) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return cal.get(Calendar.DAY_OF_MONTH);
//    }
//
//    // 获取小时
//    public static int getHourOfDay(Date date) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return cal.get(Calendar.HOUR_OF_DAY);
//    }
//
//    // 获取今天是周几
//    public static Integer getDayOfWeek(String date) {
//        return getDayOfWeek(getDateFromString(date));
//    }
//
//    // 获取今天是周几
//    public static Integer getDayOfWeek(Date date) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return cal.get(Calendar.DAY_OF_WEEK);
//    }
//
//
//
//    /**
//     * 显示年月日 格式yyyy-MM-dd
//     *
//     * @param dateStr时间字符串
//     *            修改内容：增加dateStr为空值处理
//     * @return
//     */
//    public static Date getDateFromString(String dateStr) {
//        if (dateStr == null || "null".equals(dateStr) || "".equals(dateStr)) {
//            return null;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        try {
//            return sdf.parse(dateStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 将"yyyy-MM-dd"格式字符串转成java.util.Date日期
//     *
//     * @param str
//     * @return
//     * @throws ParseException
//     */
//    static public java.util.Date getUtilDateFromStr(String str)
//            throws ParseException {
//        if (null == str || "".equals(str)) {
//            return null;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.parse(str);
//    }
//
//    /**
//     * 获得当前之前/之后天数的日期，格式为yyyy-mm-dd
//     *
//     * @param dateNum
//     *            当前日期之前/之后天数
//     * @return 相应日期
//     */
//    public static Date getDateFromString(int dateNum) {
//        Date temp = new Date();
//        String dateStr = temp.getYear() + 1900 + "-" + (temp.getMonth() + 1) + "-" + (temp.getDate() + dateNum);
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            return sdf.parse(dateStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static Date getDateFromString2(int dateNum) {
//        Date temp = new Date();
//        String dateStr = temp.getYear() + 1900 + "-" + (temp.getMonth() + 1 + dateNum) + "-" + (temp.getDate())+ " "+temp.getHours() +":"+temp.getMinutes()+":"+temp.getSeconds();
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STR);
//            return sdf.parse(dateStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    //修改内容：增加date为空值处理
//    public static String getStringDate(Date date) {
//        if (date == null) {
//            return null;
//        }
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return new StringBuffer().append(cal.get(Calendar.YEAR)).append("-")
//                .append((cal.get(Calendar.MONTH) + 1)).append("-").append(
//                        cal.get(Calendar.DAY_OF_MONTH)).toString();
//    }
//
//    // 获取今天年月日时 YYYY-MM-DD:HH
//    public static String getDayandhour(Date date) {
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        return new StringBuffer().append(cal.get(Calendar.YEAR)).append("-")
//                .append((cal.get(Calendar.MONTH) + 1)).append("-").append(
//                        cal.get(Calendar.DAY_OF_MONTH)).append(" : ").append(
//                        cal.get(Calendar.HOUR_OF_DAY)).toString();
//    }
//
//    // 计算两个日期之间的天数
//    //增加date为空值处理
//    public static String getStringDateFormat(Date date) {
//        if (date == null) {
//            return null;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(date);
//    }
//
//    public static int countDays(Date begin, Date later) {
//        if (begin == null || later == null)
//            return -1;
//        return (int) ((later.getTime() - begin.getTime()) / 86400000);
//    }
//
//    /**
//     * 换算成以年为单位
//     *
//     * days/365年
//     *
//     * @param days
//     *            <天数>
//     * @return
//     */
////    public static double leavingsYear(int days) {
////        return FormatUtil.round(days / 365.0D, 4);
////    }
//
//    /**
//     * 计算剩余年限(计闰日)
//     *
//     * @param begin
//     *            <开始日期>
//     * @param end
//     *            <截止日期>
//     * @return
//     */
//    public static double leavingsYear(Date begin, Date end) {
//        if (begin == null || end == null || end.before(begin))
//            return 0;
//        int days = DateUtils.countDayByDate(begin, end);
//        return DateUtils.leavingsYear(days);
//    }
//
//    // type 类型：0 计闰日 1不计闰日
//    public static double leavingsYear(Date begin, Date end, int type) {
//        if (begin == null || end == null || end.before(begin))
//            return 0;
//        int days = DateUtils.countDayByDate(begin, end, type);
//        return DateUtils.leavingsYear(days);
//    }
//
//    /**
//     * 将指定日期增量后得到一个新的日期
//     *
//     * @param type
//     *            增量类型，Calendar.DAY_OF_MONTH、Calendar.MONTH等
//     * @param num
//     *            增量的数量值
//     */
//    public static Date dateAdd(Date date, int type, int num) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.add(type, num);
//        return cal.getTime();
//    }
//
//    /**
//     * 将指定日期减量后得到一个新的日期
//     *
//     * @param type
//     *            减量类型，Calendar.DAY_OF_MONTH、Calendar.MONTH等
//     * @param num
//     *            减量的数量值
//     */
//    public static Date dateSub(Date date, int type, int num) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int value = cal.get(type) - num;
//        cal.set(Calendar.DAY_OF_MONTH, value);
//        return cal.getTime();
//    }
//
//    /**
//     * 判断两个日期之间差了多少天，不足一天，则按一天计算，即20.01天也算21天
//     */
//    public static int dateDiff(Date date1, Date date2) {
//        if (date1 == null || date2 == null)
//            return 0;
//        long baseNum = 3600 * 1000 * 24;
//        long absNum = Math.abs(date1.getTime() - date2.getTime());
//        long mod = absNum % baseNum;
//        int num = (int) (absNum / baseNum);
//        if (mod > 0)
//            num++;
//        return num;
//    }
//
//    /**
//     * 获得当前日期天内的毫秒值
//     *
//     * @param long
//     */
//    public static long getCurrDayTimeMillis(Date currDate) {
//        long currTime = 0;
//        if (currDate == null)
//            return currTime;
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(currDate);
//        int hour = cal.get(Calendar.HOUR_OF_DAY);
//        int minu = cal.get(Calendar.MINUTE);
//        int sec = cal.get(Calendar.SECOND);
//        currTime = (hour * 60 * 60 + minu * 60 + sec) * 1000;
//        return currTime;
//    }
//
//    /**
//     * 根据字符型的年、月、日参数，转换成相应的日期
//     * 如果年、月、日 三个参数当中有一个是无效的，则返回空值，
//     * 需要注意的是，这里无效是指输入的字符串无法转换成整型数值。
//     */
//    public static Date parseDate(String year, String month, String day) {
//        int intYear = 0, intMonth = 0, intDay = 0;
//        String s = "";
//        try {
//            intYear = Integer.parseInt(year);
//            s = month;
//            if (s.length() > 1 && s.substring(0, 1).equals("0"))
//                s = s.substring(1);
//            intMonth = Integer.parseInt(s);
//            s = day;
//            if (s.length() > 1 && s.substring(0, 1).equals("0"))
//                s = s.substring(1);
//            intDay = Integer.parseInt(s);
//        } catch (Exception ex) {
//            return null;
//        }
//        return parseDate(intYear, intMonth, intDay);
//    }
//
//    /**
//     * 根据字符型的年、月、日参数，转换成相应的日期，
//     * 此方法对于 int month , int day 参数范围不做限制，
//     * 比如设置month为15，day为34等，系统可以直接将超出的部分累加到下一年或下一月。
//     */
//    public static Date parseDate(int year, int month, int day) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(year, month - 1, day);
//        return cal.getTime();
//    }
//
//    /**
//     * 与Date parseDate(int year,int month,int day)方法类似，只是多了时、分、秒三个参数
//     */
//    public static Date parseDate(int year, int month, int day, int hour,
//                                 int min, int sec) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(year, month - 1, day, hour, min, sec);
//        return cal.getTime();
//    }
//
//    /**
//     * 将指定字符串按固定格式转换为日期格式，当前兼容的格式如下：<br>
//     * 1、eg. 1978-12-21 14:21:25<br>
//     * 2、eg. 12/21/1978 14:21:35<br>
//     * 如果当前字符串格式违例，则返回空值
//     */
//
//    public static Date parseDate(String strDate, String format) {
//        Date now = null;
//        try {
//            now = getDate(strDate, format);
//        } catch (Exception ex) {
//            now = null;
//        }
//        return now;
//    }
//
//    private static Date getDate(String strDate, String format) throws Exception {
//        SimpleDateFormat formator = new SimpleDateFormat(format);
//        return formator.parse(strDate);
//    }
//
//    public static Date parseDate(String strDate) {
//        Date now = null;
//        try {
//            now = getDate(strDate, DATE_FORMAT_STR);
//        } catch (Exception ex) {
//            now = null;
//        }
//        if (now == null) {
//            try {
//                now = getDate(strDate, DATE_FORMAT_PAR);
//            } catch (Exception e) {
//                now = null;
//            }
//        }
//        if (now == null) {
//            try {
//                SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//                now = f.parse(strDate);
//            } catch (Exception e) {
//                now = null;
//            }
//        }
//        if (now == null) {
//            try {
//                SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
//                now = f.parse(strDate);
//            } catch (Exception e) {
//                now = null;
//            }
//        }
//        return now;
//    }
//
//    public static String shortDateForChina(Date date) {
//        String r = "";
//        SimpleDateFormat formator = new SimpleDateFormat("yyyy年MM月dd日");
//        try {
//            r = formator.format(date);
//        } catch (Exception ex) {
//            r = formator.format(new Date());
//        }
//        return r;
//    }
//
//    /**
//     * 将日期按无格式方式输出，即：按yyyyMMddHHmmss这样的格式输出，此方法很少用到
//     */
//    public static String fullTimeNoFormat(Date date) {
//        if (date == null)
//            return "";
//        String r = "";
//        SimpleDateFormat formator = new SimpleDateFormat("yyyyMMddHHmmss");
//        try {
//            r = formator.format(date);
//        } catch (Exception ex) {
//            r = "";
//        }
//        return r;
//    }
//
//    /**
//     * 将日期按指定格式输出，日期格式在config.porperties文件中设定，如果没有设定，则以'yyyy-MM-dd HH:mm:ss'，<br>
//     * 如果日期的时间部分全为0，则不显示
//     */
//    public static String fullTime(Date date) {
//        if (date == null)
//            return "";
//        String format = DATE_FORMAT_STR;
//        String s = "";
//        SimpleDateFormat formator = new SimpleDateFormat(format);
//        try {
//            s = formator.format(date);
//        } catch (Exception ex) {
//            s = "";
//        }
//        if (s != null && s.length() > 11) {
//            String sTime = s.substring(11);
//            if (sTime.equals("00:00:00"))
//                return s.substring(0, 10);
//        }
//        return s;
//    }
//
//    /**
//     * 日期格式在config.porperties文件中设定，需要按 'yy/MM/dd' 格式显示，则获得'yy/MM/dd'，<br>
//     * 如果日期的时间部分全为0，则不显示 2008-11-24 format 要输出的时间格式，eavic 信息的是 M/d 如3/1 11/5
//     * 11/11
//     */
//    public static String fullTimeByFormat(Date date, String format) {
//        if (date == null)
//            return "";
//        if (format == null || format.trim().equals(""))
//            format = "yyyy/MM/dd";
//        String s = "";
//        SimpleDateFormat formator = new SimpleDateFormat(format);
//        try {
//            s = formator.format(date);
//        } catch (Exception ex) {
//            s = "";
//        }
//        if (s != null && s.length() > 11) {
//            // String sTime = s.substring(11);
//            s.substring(0, 8);
//        }
//        return s;
//    }
//
//    public static String fullTime() {
//        return fullTime(new Date());
//    }
//
//    public static String fullTime(long date) {
//        return fullTime(new Date(date));
//    }
//
//    /**
//     * 将日期按指定格式输出，但仅输出日期部分，不显示时间，其他规则与fullTime(Date date , Locale area)一致
//     */
//    public static String shortDate(Date date) {
//        String s = fullTime(date);
//        if (s == null || s.equals(""))
//            return s;
//        return s.substring(0, 10);
//    }
//
//    public static String shortDate() {
//        return shortDate(new Date());
//    }
//
//    public static String shortDate(long date) {
//        return shortDate(new Date(date));
//    }
//
//    /**
//     * 显示日期的时间部分
//     */
//    public static String shortTime(Date date) {
//        if (date == null)
//            return "";
//        String s = "";
//        SimpleDateFormat formator = new SimpleDateFormat("HH:mm:ss");
//        try {
//            s = formator.format(date);
//        } catch (Exception ex) {
//            s = "";
//        }
//        return s;
//    }
//
//
//
//    /**
//     * 显示当前HH:mm:ss
//     */
//    public static String shortTime() {
//        return shortTime(new Date());
//    }
//
//    /**
//     * 显示当前HH:mm:ss
//     *
//     * @param date
//     *            传入当前时间
//     */
//    public static String shortTime(long date) {
//        return shortTime(new Date(date));
//    }
//
//    /**
//     * 根据月份数值得到mon+1月前的总天数，如mon=1，即得到2月之前的天数
//     *
//     * @param mon
//     *            月份数值
//     * @return 返回的计算天数
//     */
//    public static int dayCountByMonth(int mon) {
//        int ret = 0;
//        switch (mon) {
//            case 1:
//                ret = 31;
//                break;
//            case 2:
//                ret = 31 + 28;
//                break;
//            case 3:
//                ret = 31 + 28 + 31;
//                break;
//            case 4:
//                ret = 31 + 28 + 31 + 30;
//                break;
//            case 5:
//                ret = 31 + 28 + 31 + 30 + 31;
//                break;
//            case 6:
//                ret = 31 + 28 + 31 + 30 + 31 + 30;
//                break;
//            case 7:
//                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31;
//                break;
//            case 8:
//                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
//                break;
//            case 9:
//                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
//                break;
//            case 10:
//                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
//                break;
//            case 11:
//                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
//                break;
//        }
//        return ret;
//    }
//
//    /**
//     * 计算两个日期之间的天数差，扣除闰日
//     *
//     * @param t_i
//     *            输入日期i
//     * @param t
//     *            输入日期
//     * @return 输入日期i与输入日期t的天数差
//     */
//    @SuppressWarnings("deprecation")
//    public static int countDayNumberNoSpecialDay(Date t_i, Date t) {
//        int year = t.getYear();
//        int mon = t.getMonth();
//        int date = t.getDate();
//        int dayCount = dayCountByMonth(mon) + date;
//        int year_i = t_i.getYear();
//        int mon_i = t_i.getMonth();
//        int date_i = t_i.getDate();
//        int dayCount_i = dayCountByMonth(mon_i) + date_i;
//        return (year_i - year) * 365 + dayCount_i - dayCount;
//    }
//
//    /**
//     * 根据当前日期获得前一年日期的间隔天数（365，366）
//     *
//     * @param countDate
//     *            当前日期
//     * @param n
//     *            前N年的年实际天数
//     * @return 365/366
//     */
//    @SuppressWarnings("deprecation")
//    public static long dayNumberBeyond(Date countDate, int n) {
//        Date beyondDate = new Date(0);
//        beyondDate.setYear(countDate.getYear() - n);
//        beyondDate.setMonth(countDate.getMonth());
//        beyondDate.setDate(countDate.getDate());
//        beyondDate.setHours(0);
//        beyondDate.setMinutes(0);
//        beyondDate.setSeconds(0);
//        long ret = 0;
//        ret = (countDate.getTime() - beyondDate.getTime()) / (1000 * 3600 * 24);
//        return ret;
//    }
//
//    /**
//     * 判断是否是闰年
//     *
//     * @param year
//     *            要判断的年数
//     */
//    public static boolean isLeapYear(int year) {
//        return ((year % 400 == 0) || ((year % 4 == 0) && (!(year % 100 == 0)))) ? true
//                : false;
//    }
//
//    /**
//     * 判断当年有多少天 如果是闰年 返回366天 否则返回355
//     *
//     * @param year
//     *            要判断的年数
//     * @return 当年的天数
//     */
//
//    public static int getDaysFromYear(int year) {
//        return isLeapYear(year) ? 366 : 365;
//    }
//
//    /**
//     * 计算两个日期之间的天数(计闰日)
//     *
//     * @param begin
//     *            开始的日期 later结束的日期
//     * @return 天数（可以为负数）
//     */
//    public static int countDayByDate(Date begin, Date later) {
//        return (int) ((later.getTime() - begin.getTime()) / (24 * 3600 * 1000));
//    }
//
//    /**
//     * 计算两个日期之间的天数
//     *
//     * @param begin
//     *            开始的日期
//     * @param end
//     *            结束的日期
//     * @param type
//     *            类型：0 计闰日；1不计闰日
//     * @return 天数（可以为负数）
//     */
//    public static int countDayByDate(Date begin, Date end, int type) {
//        int countDay = 0;
//
//        if (type == 0) {
//            countDay = countDayByDate(begin, end);
//        } else {
//            countDay = countDayNumberNoSpecialDay(end, begin);
//        }
//
//        return countDay;
//    }
//
//    /**
//     * 计算指定年的月份的天数
//     *
//     * @param year
//     *            年 month 月
//     * @return 天数 如果传入的月不合法则返回-1
//     */
//    public static int getDaysFromYM(int year, int month) {
//        if (month >= 13 || month < 0) {
//            return -1;
//        }
//        int iReturn = 0;
//        switch (month) {
//
//            case 2:
//                iReturn = isLeapYear(year) ? 29 : 28;
//            case 4:
//            case 6:
//            case 8:
//            case 10:
//                iReturn = 30;
//            default:
//                iReturn = 31;
//        }
//        return iReturn;
//    }
//
//    /**
//     * 计算指定的日期之前的天数
//     *
//     * @param date
//     *            日期 days 天数
//     * @return 指定日期
//     */
//    public static Date getAfterDate(Date date, int days) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
//                - days);
//        return calendar.getTime();
//    }
//
//    /**
//     * 判断是否是同天
//     *
//     * @param dateOne
//     * @param dateTwo
//     * @return
//     */
//    public static boolean compare(Date dateOne, Date dateTwo) {
//        if (dateOne == null || dateTwo == null)
//            return false;
//        return DateUtils.getYear(dateOne) == DateUtils.getYear(dateTwo)
//                && DateUtils.getMonth(dateOne) == DateUtils.getMonth(dateTwo)
//                && DateUtils.getDayOfMonth(dateOne) == DateUtils
//                .getDayOfMonth(dateTwo);
//    }
//
//    /**
//     * 判断是否是同天同小时
//     *
//     * @param dateOne
//     * @param dateTwo
//     * @return
//     */
//    public static boolean compareWithHour(Date dateOne, Date dateTwo) {
//        return DateUtils.getYear(dateOne) == DateUtils.getYear(dateTwo)
//                && DateUtils.getMonth(dateOne) == DateUtils.getMonth(dateTwo)
//                && DateUtils.getDayOfMonth(dateOne) == DateUtils.getDayOfMonth(dateTwo)
//                && DateUtils.getHourOfDay(dateOne) == DateUtils.getHourOfDay(dateTwo);
//    }
//
//    public static String getEndDate(List<Date> dList) {
//        if (dList.size() == 1) {
//            return getStringDate(dList.get(0));
//        } else if (dList.size() < 1) {
//            return "";
//        }
//
//        Collections.sort(dList, new Comparator<Date>() {
//
//            public int compare(Date d1, Date d2) {
//
//                return d1.compareTo(d2);
//            }
//
//        });
//        return getStringDate(dList.get(dList.size() - 1));
//    }
//
//    /**
//     * 将短时间格式字符串yyyy-MM-dd转换为时间
//     *
//     * @param strDate
//     * @return
//     */
//    public static Date strToDate(String strDate) {
//        ParsePosition pos = new ParsePosition(0);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        Date strtodate = sdf.parse(strDate, pos);
//        return strtodate;
//    }
//
//    // 得到一个时间延后或前移几天的时间
//    public static String getCountedDay(String strDate, String delay) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            String mdate = "";
//            Date d = strToDate(strDate);
//            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
//            d.setTime(myTime * 1000);
//            mdate = sdf.format(d);
//            return mdate;
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    // 比较两个日期
//    public static int compareTwoDate(String fromDate, String toDate) {
//        try {
//            Date fDate = strToDate(fromDate);
//            Date tDate = strToDate(toDate);
//            if (fDate.getTime() > tDate.getTime()) {
//                return 1;
//            } else if (fDate.getTime() < tDate.getTime()) {
//                return -1;
//            } else {
//                return 0;
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return 0;
//    }
//
//    // 得到两个日期之间的所有天的列表
//    public static List<String> getDayListOfTwoDate(String fromDate,
//                                                   String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        daysList.add(startDate);
//        String nextDay = getCountedDay(startDate, "1");
//        while (compareTwoDate(nextDay, endDate) <= 0) {
//            daysList.add(nextDay);
//            nextDay = getCountedDay(nextDay, "1");
//        }
//        return daysList;
//    }
//
//    // 获得给定日期字符串的 -- "该周的日期"
//    public static String getDayOFWeek(String strDate, String weekDay) {
//        Date dd = strToDate(strDate);
//        Calendar c = Calendar.getInstance();
//        c.setTime(dd);
//        if (weekDay.equals("1")) {// 返回星期一所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        } else if (weekDay.equals("2")) {// 返回星期二所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
//        } else if (weekDay.equals("3")) {// 返回星期三所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
//        } else if (weekDay.equals("4")) {// 返回星期四所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
//        } else if (weekDay.equals("5")) {// 返回星期五所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
//        } else if (weekDay.equals("6")) {// 返回星期六所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
//        } else if (weekDay.equals("7")) {// 返回中国星期日所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
//            c.add(GregorianCalendar.DATE, 1);
//        } else if (weekDay.equals("0")) {// 返回西方星期日所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(c.getTime());
//    }
//
//    // 得到一个时间延后或前移几周的时间
//    public static String getCountedWeek(String strDate, String delay) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            Date dd = strToDate(strDate);
//            Calendar currentDate = Calendar.getInstance();
//            currentDate.setTime(dd);
//            currentDate.add(Calendar.WEDNESDAY, Integer.parseInt(delay));
//            return sdf.format(currentDate.getTime());
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    // 得到两个日期之间的所有周几的列表
//    public static List<String> getWeekDayListOfTwoDate(String fromDate,
//                                                       String toDate, String weekDay) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startWeekDay = getDayOFWeek(startDate, weekDay);
//        String endWeekDay = getDayOFWeek(endDate, weekDay);
//        daysList.add(startWeekDay);
//        String nextWeekDay = getCountedWeek(startWeekDay, "1");
//        while (compareTwoDate(nextWeekDay, endWeekDay) <= 0) {
//            daysList.add(nextWeekDay);
//            nextWeekDay = getCountedWeek(nextWeekDay, "1");
//        }
//        return daysList;
//    }
//
//    // 获取给定日期字符串的月第一天
//    public static String getFirstDayOfMonth(String strDate) {
//        Date dd = strToDate(strDate);
//        Calendar c = Calendar.getInstance();
//        c.setTime(dd);
//        c.set(Calendar.DATE, 1);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(c.getTime());
//    }
//
//    // 得到一个时间延后或前移几月的时间
//    public static String getCountedMonth(String strDate, String delay) {
//        try {
//            Date dd = strToDate(strDate);
//            Calendar currentDate = Calendar.getInstance();
//            currentDate.setTime(dd);
//            currentDate.add(Calendar.MONDAY, Integer.parseInt(delay));
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            return sdf.format(currentDate.getTime());
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    // 得到两个日期之间的所有月初的列表
//    public static List<String> getFirstDayListOfMonthInTwoDate(String fromDate,
//                                                               String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startMonthDay = getFirstDayOfMonth(startDate);
//        String endMonthDay = getFirstDayOfMonth(endDate);
//        daysList.add(startMonthDay);
//        String nextMonthDay = getCountedMonth(startMonthDay, "1");
//        while (compareTwoDate(nextMonthDay, endMonthDay) <= 0) {
//            daysList.add(nextMonthDay);
//            nextMonthDay = getCountedMonth(nextMonthDay, "1");
//        }
//        return daysList;
//    }
//
//    // 获取给定日期字符串的月最后一天
//    public static String getLastDayOfMonth(String strDate) {
//        Date dd = strToDate(strDate);
//        Calendar lastDate = Calendar.getInstance();
//        lastDate.setTime(dd);
//        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
//        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
//        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(lastDate.getTime());
//    }
//
//    // 获得季度
//    public static int getIntSeasonOfYear(String strDate) {
//        int month = getMonth(strDate);
//        int season = 1;
//        if ((month >= 1) && (month <= 3)) {
//            season = 1;
//        }
//        if ((month >= 4) && (month <= 6)) {
//            season = 2;
//        }
//        if ((month >= 7) && (month <= 9)) {
//            season = 3;
//        }
//        if ((month >= 10) && (month <= 12)) {
//            season = 4;
//        }
//        return season;
//    }
//
//    // 获得给定日期字符串的季度第一天
//    public static String getFirstDayOfSeason(String strDate) {
//        String array[][] = { { "01", "02", "03" }, { "04", "05", "06" },
//                { "07", "08", "09" }, { "10", "11", "12" } };
//        int years = getYear(strDate);
//        int season = getIntSeasonOfYear(strDate);
//        String start_month = array[season - 1][0];
//        return years + "-" + start_month + "-01";
//    }
//
//    // 得到两个日期之间的所有季初的列表
//    public static List<String> getFirstDayListOfSeasonInTwoDate(
//            String fromDate, String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startMonthDay = getFirstDayOfSeason(startDate);
//        String endMonthDay = getFirstDayOfSeason(endDate);
//        daysList.add(startMonthDay);
//        String nextMonthDay = getCountedMonth(startMonthDay, "3");
//        while (compareTwoDate(nextMonthDay, endMonthDay) <= 0) {
//            daysList.add(nextMonthDay);
//            nextMonthDay = getCountedMonth(nextMonthDay, "3");
//        }
//        return daysList;
//    }
//
//    // 获得给定日期字符串的季度最后一天
//    public static String getLastDayOfSeason(String strDate) {
//        String array[][] = { { "01", "02", "03" }, { "04", "05", "06" },
//                { "07", "08", "09" }, { "10", "11", "12" } };
//        int years = getYear(strDate);
//        int season = getIntSeasonOfYear(strDate);
//        String end_month = array[season - 1][2];
//        return getLastDayOfMonth(years + "-" + end_month + "-01");
//    }
//
//    // 得到一个时间延后或前移几年的时间
//    public static String getCountedYear(String strDate, String delay) {
//        try {
//            Date dd = strToDate(strDate);
//            Calendar currentDate = Calendar.getInstance();
//            currentDate.setTime(dd);
//            currentDate.add(Calendar.YEAR, Integer.parseInt(delay));
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            return sdf.format(currentDate.getTime());
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    // 获取给定日期字符串的年第一天
//    public static String getFirstDayOfYear(String strDate) {
//        int years = getYear(strDate);
//        return years + "-01-01";
//    }
//
//    // 得到两个日期之间的所有年初的列表
//    public static List<String> getFirstDayListOfYearInTwoDate(String fromDate,
//                                                              String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startYearDay = getFirstDayOfYear(startDate);
//        String endYearDay = getFirstDayOfYear(endDate);
//        daysList.add(startYearDay);
//        String nextYearDay = getCountedYear(startYearDay, "1");
//        while (compareTwoDate(nextYearDay, endYearDay) <= 0) {
//            daysList.add(getFirstDayOfYear(nextYearDay));
//            nextYearDay = getCountedYear(nextYearDay, "1");
//        }
//        return daysList;
//    }
//
//    // 获取给定日期字符串的年最后一天
//    public static String getLastDayOfYear(String strDate) {
//        int years = getYear(strDate);
//        return years + "-12-31";
//    }
//
//    //
//    public static String getDateUtilCurrentDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String sDate = sdf.format(new Date());
//        return sDate;
//    }
//
//    // 得到一个时间延后或前移几月的时间
//    public static String getDateUtilCountedMonth(String strDate, String delay) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            Date dd = strToDate(strDate);
//            Calendar currentDate = Calendar.getInstance();
//            currentDate.setTime(dd);
//            currentDate.add(Calendar.MONDAY, Integer.parseInt(delay));
//            return sdf.format(currentDate.getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // 获取给定日期字符串的月第一天
//    public static String getDateUtilFirstDayOfMonth(String strDate) {
//        Date dd = strToDate(strDate);
//        Calendar c = Calendar.getInstance();
//        c.setTime(dd);
//        c.set(Calendar.DATE, 1);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(c.getTime());
//    }
//
//    // 获取给定日期字符串的月最后一天
//    public static String getDateUtilLastDayOfMonth(String strDate) {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        Date dd = strToDate(strDate);
//        Calendar lastDate = Calendar.getInstance();
//        lastDate.setTime(dd);
//        lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
//        lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
//        lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
//        return sdf.format(lastDate.getTime());
//    }
//
//    //
//    public static String getDateUtilStrDate(String strDate) {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(strToDate(strDate));
//    }
//
//    // 得到两个日期之间的所有周几的列表
//    public static List<String> getDateUtilWeekDayListOfTwoDate(String fromDate,
//                                                               String toDate, String weekDay) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startWeekDay = getDayOFWeek(startDate, weekDay);
//        String endWeekDay = getDayOFWeek(endDate, weekDay);
//        daysList.add(startWeekDay);
//        String nextWeekDay = getCountedWeek(startWeekDay, "1");
//        while (compareTwoDate(nextWeekDay, endWeekDay) <= 0) {
//            daysList.add(nextWeekDay);
//            nextWeekDay = getCountedWeek(nextWeekDay, "1");
//        }
//        return daysList;
//    }
//
//    // 获得给定日期字符串的 -- "该周的日期"
//    public static String getDateUtilDayOFWeek(String strDate, String weekDay) {
//        Date dd = strToDate(strDate);
//        Calendar c = Calendar.getInstance();
//        c.setTime(dd);
//        if (weekDay.equals("1")) {// 返回星期一所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        } else if (weekDay.equals("2")) {// 返回星期二所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
//        } else if (weekDay.equals("3")) {// 返回星期三所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
//        } else if (weekDay.equals("4")) {// 返回星期四所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
//        } else if (weekDay.equals("5")) {// 返回星期五所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
//        } else if (weekDay.equals("6")) {// 返回星期六所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
//        } else if (weekDay.equals("7")) {// 返回中国星期日所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
//            c.add(GregorianCalendar.DATE, 1);
//        } else if (weekDay.equals("0")) {// 返回西方星期日所在的日期
//            c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        return sdf.format(c.getTime());
//    }
//
//    // 得到两个日期之间的所有月初的列表
//    public static List<String> getDateUtilFirstDayListOfMonthInTwoDate(
//            String fromDate, String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startMonthDay = getFirstDayOfMonth(startDate);
//        String endMonthDay = getFirstDayOfMonth(endDate);
//        daysList.add(startMonthDay);
//        String nextMonthDay = getCountedMonth(startMonthDay, "1");
//        while (compareTwoDate(nextMonthDay, endMonthDay) <= 0) {
//            daysList.add(nextMonthDay);
//            nextMonthDay = getCountedMonth(nextMonthDay, "1");
//        }
//        return daysList;
//    }
//
//    // 得到两个日期之间的所有季初的列表
//    public static List<String> getDateUtilFirstDayListOfSeasonInTwoDate(
//            String fromDate, String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startMonthDay = getFirstDayOfSeason(startDate);
//        String endMonthDay = getFirstDayOfSeason(endDate);
//        daysList.add(startMonthDay);
//        String nextMonthDay = getCountedMonth(startMonthDay, "3");
//        while (compareTwoDate(nextMonthDay, endMonthDay) <= 0) {
//            daysList.add(nextMonthDay);
//            nextMonthDay = getCountedMonth(nextMonthDay, "3");
//        }
//        return daysList;
//    }
//
//    // 获得给定日期字符串的季度最后一天
//    public static String getDateUtilLastDayOfSeason(String strDate) {
//        String array[][] = { { "01", "02", "03" }, { "04", "05", "06" },
//                { "07", "08", "09" }, { "10", "11", "12" } };
//        int years = getYear(strDate);
//        int season = getIntSeasonOfYear(strDate);
//        String end_month = array[season - 1][2];
//        return getLastDayOfMonth(years + "-" + end_month + "-01");
//    }
//
//    // 得到两个日期之间的所有年初的列表
//    public static List<String> getDateUtilFirstDayListOfYearInTwoDate(
//            String fromDate, String toDate) {
//        List<String> daysList = new ArrayList<String>();
//        String startDate = fromDate;
//        String endDate = toDate;
//        if (compareTwoDate(fromDate, toDate) > 0) {
//            startDate = toDate;
//            endDate = fromDate;
//        }
//        String startYearDay = getFirstDayOfYear(startDate);
//        String endYearDay = getFirstDayOfYear(endDate);
//        daysList.add(startYearDay);
//        String nextYearDay = getCountedYear(startYearDay, "1");
//        while (compareTwoDate(nextYearDay, endYearDay) <= 0) {
//            daysList.add(getFirstDayOfYear(nextYearDay));
//            nextYearDay = getCountedYear(nextYearDay, "1");
//        }
//        return daysList;
//    }
//
//    // 获取给定日期字符串的年最后一天
//    public static String getDateUtilLastDayOfYear(String strDate) {
//        int years = getYear(strDate);
//        return years + "-12-31";
//    }
//
//    /**
//     * 日期格式转换,用于判断条件只到月份，形如：1990-8 转换成1990-08
//     */
//    public static String convertStringFromDate(String target) {
//        String dateString = "";
//        Date date;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            date = sdf.parse(target);
//            int yearString = date.getYear() + 1900;
//            int moString = date.getMonth() + 1;
//            if (moString < 10) {
//                dateString = yearString + "-0" + moString;
//            } else {
//                dateString = yearString + "-" + moString;
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return dateString;
//    }
//
//    /**
//     * 用于页面显示格式为XXXX年XX月
//     *
//     */
//    public static String getYearAndMonth(String target) {
//        String dateString = "";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
//        Date date;
//        try {
//            date = simpleDateFormat.parse(target);
//            int yearString = date.getYear() + 1900;
//            int moString = date.getMonth() + 1;
//            if (moString < 10) {
//
//                dateString = yearString + "年0" + moString + "月";
//            } else
//                dateString = yearString + "年" + moString + "月";
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return dateString;
//    }
//
//    //
//    public static String convertFormFromDateToString(Date target) {
//        String dateString = "";
//        if (target != null && !target.equals("")) {
//            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//            dateString = sdf.format(target);
//        } else {
//            dateString = "";
//        }
//        return dateString;
//    }
//
//    /**
//     * 获取一年前今天的日期
//     */
//    public static String getNowOfLastYear() {
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String currentYearAndMonth = sdf.format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取半年前的日期
//     */
//    public static String getNowOfLastHalfYear() {
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 6);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String currentYearAndMonth = sdf.format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取一年前年份
//     */
//    public static String getPrimaYear() {
//        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy");
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar
//                .get(Calendar.YEAR) - 1);
//        String currentYearAndMonth = aSimpleDateFormat
//                .format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取两年前年份
//     */
//    public static String getPrimaTwoYear() {
//        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy");
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar
//                .get(Calendar.YEAR) - 2);
//        String currentYearAndMonth = aSimpleDateFormat
//                .format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取一月前的日期
//     */
//    public static String getPrimaMonth() {
////      GregorianCalendar aGregorianCalendar = new GregorianCalendar();
////      aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
////      String currentYearAndMonth = sdf.format(aGregorianCalendar.getTime());
////      return currentYearAndMonth;
//
//        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat(DATE_FORMAT_PAR);
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        //aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
//        aGregorianCalendar.add(GregorianCalendar.MONTH, -1);
//        String currentYearAndMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取下个月的日期
//     */
//    public static String getNextMonthDay() {
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) + 1);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String currentYearAndMonth = sdf.format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取下个周的日期
//     */
//    public static String getNextWeekDay() {
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.DATE, aGregorianCalendar.get(Calendar.DATE) + 7);
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String currentYearAndMonth = sdf.format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     * 获取当前日期
//     */
//    @Deprecated
//    public static String getNowYear() {
//        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//        String time = sdf.format(new Date());
//        return time;
//    }
//
//    /**
//     * 获取统计时间段开始日期
//     */
//    public static String getSecStartDate(String statisticsFREQUENCE,
//                                         String beginDate) {
//        if (statisticsFREQUENCE.equals("1")) {// 日
//            return beginDate;
//        }
//        if (statisticsFREQUENCE.equals("2")) {// 周
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = sdf.parse(beginDate);
//                Calendar firstcalendar = Calendar.getInstance();
//                firstcalendar.setTime(date);
//                if (firstcalendar.get(Calendar.DAY_OF_WEEK) == 1) {
//                    firstcalendar.add(Calendar.DATE, -6);
//                } else {
//                    firstcalendar.add(Calendar.DATE, 0 - firstcalendar.get(Calendar.DAY_OF_WEEK) + 2);
//                }
//                return sdf.format(firstcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("3")) {// 月
//            return beginDate.substring(0, beginDate.lastIndexOf("-")) + "-01";
//        }
//        if (statisticsFREQUENCE.equals("4")) {// 季
//
//            String beginDateMonth = beginDate.substring(
//                    beginDate.indexOf("-") + 1, beginDate.lastIndexOf("-"));
//            int month = Integer.parseInt(beginDateMonth);
//            if (month == 1 || month == 2 || month == 3) {// 一季
//                return beginDate.substring(0, 4) + "-01-01";
//            }
//            if (month == 4 || month == 5 || month == 6) {// 二季
//                return beginDate.substring(0, 4) + "-04-01";
//            }
//            if (month == 7 || month == 8 || month == 9) {// 三季
//                return beginDate.substring(0, 4) + "-07-01";
//            }
//            if (month == 10 || month == 11 || month == 12) {// 四季
//                return beginDate.substring(0, 4) + "-10-01";
//            }
//        }
//        if (statisticsFREQUENCE.equals("5")) {// 年
//            return beginDate.substring(0, beginDate.indexOf("-")) + "-01-01";
//        }
//        return null;
//    }
//
//    /**
//     * 获取统计时间段结束日期
//     */
//    public static String getSecEndDate(String statisticsFREQUENCE,
//                                       String endDate) {
//        if (statisticsFREQUENCE.equals("1")) {// 日
//            return endDate;
//        }
//        if (statisticsFREQUENCE.equals("2")) {// 周
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = sdf.parse(endDate);
//                Calendar lastcalendar = Calendar.getInstance();
//                lastcalendar.setTime(date);
//                if (lastcalendar.get(Calendar.DAY_OF_WEEK) != 1) {
//                    lastcalendar.add(Calendar.DATE, 0 - lastcalendar.get(Calendar.DAY_OF_WEEK) + 8);
//                }
//                return sdf.format(lastcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("3")) {// 月
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = sdf.parse(endDate);
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(date);
//                int year = Integer.parseInt(endDate.substring(0, endDate
//                        .indexOf("-")));
//                int month = Integer.parseInt(endDate.substring(endDate
//                        .indexOf("-") + 1, endDate.lastIndexOf("-")));
//                calendar.set(year, month - 1, 1);
//                int maxDayOfMonth = calendar
//                        .getActualMaximum(Calendar.DAY_OF_MONTH);
//
//                return endDate.substring(0, endDate.lastIndexOf("-")) + "-"
//                        + String.valueOf(maxDayOfMonth);
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("4")) {// 季
//
//            String endDateMonth = endDate.substring(endDate.indexOf("-") + 1,
//                    endDate.lastIndexOf("-"));
//            int month = Integer.parseInt(endDateMonth);
//            if (month == 1 || month == 2 || month == 3) {// 一季
//                return endDate.substring(0, 4) + "-03-31";
//            }
//            if (month == 4 || month == 5 || month == 6) {// 二季
//                return endDate.substring(0, 4) + "-06-30";
//            }
//            if (month == 7 || month == 8 || month == 9) {// 三季
//                return endDate.substring(0, 4) + "-09-30";
//            }
//            if (month == 10 || month == 11 || month == 12) {// 四季
//                return endDate.substring(0, 4) + "-12-31";
//            }
//        }
//        if (statisticsFREQUENCE.equals("5")) {// 月
//
//            return endDate.substring(0, 4) + "-12-31";
//        }
//        return null;
//    }
//
//    /**
//     * 获取上最近有数据的时间段开始日期
//     */
//    public static String getPriveSecBegin(String statisticsFREQUENCE,
//                                          String endDate) {
//
//        if (statisticsFREQUENCE.equals("1")) {// 日，往前算30日
//            try {
//                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = formatter.parse(endDate);
//                Calendar lastcalendar = Calendar.getInstance();
//                lastcalendar.setTime(date);
//                lastcalendar.add(Calendar.DATE, -30);
//                return formatter.format(lastcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("2")) {// 周，往前算21日，三周
//            try {
//                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = formatter.parse(endDate);
//                Calendar lastcalendar = Calendar.getInstance();
//                lastcalendar.setTime(date);
//                lastcalendar.add(Calendar.DATE, -21);
//                return formatter.format(lastcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("3")) {// 月，往前算一个月
//            try {
//                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = formatter.parse(endDate);
//                Calendar lastcalendar = Calendar.getInstance();
//                lastcalendar.setTime(date);
//                lastcalendar.add(Calendar.MONTH, -1);
//                return formatter.format(lastcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("4")) {// 季，往前算一季
//            try {
//                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = formatter.parse(endDate);
//                Calendar lastcalendar = Calendar.getInstance();
//                lastcalendar.setTime(date);
//                lastcalendar.add(Calendar.MONTH, -3);
//                return formatter.format(lastcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        if (statisticsFREQUENCE.equals("5")) {// 年，往前算一年
//            try {
//                SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAR);
//                Date date = formatter.parse(endDate);
//                Calendar lastcalendar = Calendar.getInstance();
//                lastcalendar.setTime(date);
//                lastcalendar.add(Calendar.YEAR, -1);
//                return formatter.format(lastcalendar.getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    public static String getLastMonth() {
//        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar
//                .get(Calendar.MONTH) - 1);
//        String currentYearAndMonth = aSimpleDateFormat
//                .format(aGregorianCalendar.getTime());
//        return currentYearAndMonth;
//    }
//
//    /**
//     *功能：截取两个日期之间的天数
//     * @param String
//     *            beginDate,String endDate
//     * @return int
//     * @throws ParseException
//     * @author Cy
//     * */
//    public static int getDay(String beginDate, String endDate)
//            throws ParseException {
//        SimpleDateFormat sim = new SimpleDateFormat(DATE_FORMAT_PAR);
//        Date d1 = null;
//        Date d2 = null;
//        try {
//            d1 = sim.parse(beginDate);
//            d2 = sim.parse(endDate);
//        } catch (java.text.ParseException e) {
//            e.printStackTrace();
//        }
//        return (int) ((d1.getTime() - d2.getTime()) / (3600L * 1000 * 24));
//    }
//
//    /**
//     * 计算两个日期之间有多少润日
//     *
//     * @param begin
//     * @param end
//     * @return 天数
//     * @author yehui
//     */
//    public static int nbLeapDay(Date begin, Date end) {
//        Date beginDate = null;
//        Date endDate = null;
//        if (begin.compareTo(end) > 0) {
//            beginDate = end;
//            endDate = begin;
//        } else {
//            beginDate = begin;
//            endDate = end;
//        }
//
//        if (getYear(beginDate) == getYear(endDate)) {
//            if (getMonth(beginDate) > 2 || getMonth(endDate) < 3) {
//                return 0;
//            } else if (isLeapYear(getYear(beginDate))) {
//                return 1;
//            }
//        } else {
//            int days = 0;
//            for (int i = getYear(beginDate); i <= getYear(endDate); i++) {
//                if (isLeapYear(i)
//                        && beginDate.compareTo(getDateFromString(i + "-2-28")) < 0
//                        && endDate.compareTo(getDateFromString(i + "-2-28")) > 0) {
//                    days++;
//                }
//            }
//            return days;
//        }
//        return 0;
//    }
//
//    /**
//     * n为正数：获取n个月后日期，n为负数：获取n个月前日期
//     *
//     * @author gongping
//     * @since 2012-07-19
//     * @return
//     */
//    public static Date getPrimaMonth(int n) {
//        return getPrimaMonth(null,n);
//    }
//
//    public static Date getPrimaMonth(Date curDate,int n) {
//        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
//        if (curDate != null)
//            aGregorianCalendar.setTime(curDate);
//        aGregorianCalendar.add(GregorianCalendar.MONTH, n);
//        return aGregorianCalendar.getTime();
//    }

}
