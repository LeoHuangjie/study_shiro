package com.hj.util;

import com.google.common.collect.Maps;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author huangjie
 * @time 2019-06-14 15:06
 */
public class DateUtil {

    private static final String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm";
    private static final String DATE_FORMAT_PAR = "yyyy-MM-dd";


    /**
     * date转String
     */



    /**
     * 计算两个日期之间的天数
     *
     * @param begin
     *            开始的日期
     * @param end
     *            结束的日期
     * @param type
     *            类型：0 计闰日；1不计闰日
     * @return 天数（可以为负数）
     */
    public static int countDayByDate(Date begin, Date end, int type) {
        int countDay = 0;

        if (type == 0) {
            countDay = countDayByDate(begin, end);
        } else {
            countDay = countDayNumberNoSpecialDay(end, begin);
        }

        return countDay;
    }


    /**
     * 忽略时间
     *
     * 计算两个日期之间的天数(计闰日)
     *
     * @param begin
     *            开始的日期 later结束的日期
     * @return 天数（可以为负数）
     */
    public static int countDayByDate(Date begin, Date later) {
        return (int) ((later.getTime() - begin.getTime()) / (24 * 3600 * 1000));
    }



    /**
     * 计算两个日期之间的天数差，扣除闰日
     *
     * @param t1
     *            输入日期i
     * @param t
     *            输入日期
     * @return 输入日期i与输入日期t的天数差
     */
    public static int countDayNumberNoSpecialDay(Date t1, Date t) {
        Map<String, Integer> yearOrMonOrDate = getYearOrMonOrDate(t);
        Integer date = yearOrMonOrDate.get("date");
        Integer mon = yearOrMonOrDate.get("mon");
        Integer year = yearOrMonOrDate.get("year");
        int dayCount = dayCountByMonth(mon) + date;

        Map<String, Integer> yearOrMonOrDate1 = getYearOrMonOrDate(t1);
        Integer date1 = yearOrMonOrDate1.get("date");
        Integer mon1 = yearOrMonOrDate1.get("mon");
        Integer year1 = yearOrMonOrDate1.get("year");
        int dayCount1 = dayCountByMonth(mon1) + date1;

        return (year1 - year) * 365 + dayCount1 - dayCount;
    }


    /**
     * 根据日期 获取年 月 日 一年的第几天  一周的第几天（按西方的） 一月的第几天
     * @param date 传入的日期
     * @return
     */
    public static Map<String, Integer> getYearOrMonOrDate (Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //Calendar里取出来的month比实际的月份少1，所以要加上
        int mon = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        //这一天在是这个月的第多少天
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        //这一天在是这个年的第多少天
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        //当前日期是一周的第几天
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        Map<String, Integer> timeMap = Maps.newHashMap();
        timeMap.put("day",day);
        timeMap.put("mon",mon);
        timeMap.put("year",year);
        timeMap.put("dayOfMonth",dayOfMonth);
        timeMap.put("dayOfYear",dayOfYear);
        timeMap.put("dayOfWeek",dayOfWeek);
        return timeMap;
    }


    /**
     * 判断是否是同天
     *
     * @param dateOne
     * @param dateTwo
     * @return
     */
    public static boolean compare(Date dateOne, Date dateTwo) {
        if (dateOne == null || dateTwo == null){
            return false;
        }
        Map<String, Integer> dateOneMap = getYearOrMonOrDate(dateOne);
        Map<String, Integer> dateTowMap = getYearOrMonOrDate(dateTwo);
        return dateOneMap.get("year").equals(dateTowMap.get("year"))
                && dateOneMap.get("mon").equals(dateTowMap.get("mon"))
                && dateOneMap.get("dayOfMonth").equals(dateTowMap.get("dayOfMonth"));
    }


    /**
     * 得到两个日期之间的所有天的列表 (包含传入的开始时间和结束时间)
     * @param fromDate 开始时间
     * @param toDate 结束时间
     * @return
     */
    public static List<String> getDayListOfTwoDate(String fromDate, String toDate) {
        List<String> daysList = new ArrayList<String>();
        String startDate = fromDate;
        String endDate = toDate;
        if (compareTwoDate(fromDate, toDate) > 0) {
            startDate = toDate;
            endDate = fromDate;
        }
        daysList.add(startDate);
        String nextDay = getCountedDay(startDate, "1");
        while (compareTwoDate(nextDay, endDate) < 0) {
            daysList.add(nextDay);
            nextDay = getCountedDay(nextDay, "1");
        }
        daysList.add(endDate);
        return daysList;
    }


    /**
     * 得到一个时间延后或前移几天的时间
     * @param strDate
     * @param delay
     * @return
     */
    public static String getCountedDay(String strDate, String delay) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
            String mdate = "";
            Date d = strToDate(strDate);
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = sdf.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 比较两个日期
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int compareTwoDate(String fromDate, String toDate) {
        try {
            Date fDate = strToDate(fromDate);
            Date tDate = strToDate(toDate);
            if (fDate.getTime() > tDate.getTime()) {
                return 1;
            } else if (fDate.getTime() < tDate.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }


    /**
     * 比较两个时间段是否有交集
     * @param formDate1 时间段1的开始时间
     * @param toDate1 时间段1的结束时间
     * @param fromDate2 时间段2的开始时间
     * @param toDate2 时间段2的结束时间
     * @return true 有交集， false 没有交集
     */
    public static Boolean compareHaveIntersection (String formDate1, String toDate1, String fromDate2, String toDate2) {
        int compareFF = compareTwoDate(formDate1, fromDate2);
        int compareTF = compareTwoDate(toDate1, fromDate2);
        int compareFT = compareTwoDate(formDate1, toDate2);
        int compareTT = compareTwoDate(toDate1, toDate2);

        if (compareFF < 0 && compareTF > 1) {
            return true;
        } else if (compareFF > 0 &&  compareTT < 0) {
            return true;
        } else if (compareFT < 0 && compareTT > 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 将短时间格式字符串yyyy-MM-dd转换为时间
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PAR);
        return sdf.parse(strDate, pos);
    }


    public static String dateToString (Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_STR);
        return sdf.format(date);
    }


    /**
     * 计算指定的日期之前的天数
     *
     * @param date
     *            日期 days 天数
     * @return 指定日期
     */
    public static Date getAfterDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
                - days);
        return calendar.getTime();
    }



    /**
     * 计算指定年的月份的天数
     *
     * @param year
     *            年 month 月
     * @return 天数 如果传入的月不合法则返回-1
     */
    public static int getDaysFromYM(int year, int month) {
        if (month >= 13 || month < 0) {
            return -1;
        }
        int iReturn = 0;
        switch (month) {

            case 2:
                iReturn = isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 8:
            case 10:
                iReturn = 30;
            default:
                iReturn = 31;
        }
        return iReturn;
    }



    /**
     * 判断是否是闰年
     *
     * @param year
     *            要判断的年数
     */
    public static boolean isLeapYear(int year) {
        return ((year % 400 == 0) || ((year % 4 == 0) && (!(year % 100 == 0)))) ? true
                : false;
    }



    /**
     * 根据月份数值得到mon+1月前的总天数，如mon=1，即得到2月之前的天数
     *
     * @param mon
     *            月份数值
     * @return 返回的计算天数
     */
    public static int dayCountByMonth(int mon) {
        int ret = 0;
        switch (mon) {
            case 1:
                ret = 31;
                break;
            case 2:
                ret = 31 + 28;
                break;
            case 3:
                ret = 31 + 28 + 31;
                break;
            case 4:
                ret = 31 + 28 + 31 + 30;
                break;
            case 5:
                ret = 31 + 28 + 31 + 30 + 31;
                break;
            case 6:
                ret = 31 + 28 + 31 + 30 + 31 + 30;
                break;
            case 7:
                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31;
                break;
            case 8:
                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                break;
            case 9:
                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;
            case 10:
                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;
            case 11:
                ret = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                break;
        }
        return ret;
    }


    public static void main(String[] args) {
        //得到两个日期之间的所有天的列表
        getDayListOfTwoDate("2016-12-10 08:00","2016-12-10 18:00");

        //根据日期 获取年 月 日 一年的第几天  一周的第几天（按西方的） 一月的第几天
        getYearOrMonOrDate(new Date());

        //计算两个日期之间的天数
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
        try {
            Date parse = sdf.parse("2016-12-10 08:00");
            Date parse1 = sdf.parse("2016-12-11 18:00");
            int i = countDayByDate(parse, parse1);
            System.out.println(i);


            //判断是否是同一天
            boolean compare = compare(parse, parse1);
            System.out.println(compare);

        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

}
