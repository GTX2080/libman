package com.chen.library.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 日期处理工具类
 *
 * @author 
 */
public class DateUtil {
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 生成ISO-8601 规范的时间格式
     *
     * @param date
     * @return
     */
    public static String formatISO8601DateString(Date date) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        return DateFormatUtils.format(date, pattern);
    }


    /**
     * 获取原时间戳
     *
     * @param reverseTime
     * @return
     */
    public static Long recoverReverseTime(Long reverseTime) {
        long longTime = Long.MAX_VALUE - reverseTime;
        return longTime / 1000000;
    }

    /**
     * 生成页面普通展示时间
     *
     * @param date
     * @return
     */
    public static String formatNormalDateString(Date date) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 日期转换为字符串 yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getShotDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateStr(date, "yyyy-MM-dd");
    }

    /**
     * 日期转换为字符串 格式自定义
     *
     * @param date
     * @param f
     * @return
     */
    public static String dateStr(Date date, String f) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(f);
        String str = format.format(date);
        return str;
    }

    /**
     * 日期转换为字符串 格式自定义
     *
     * @param String (2019-04-23 / 2019-04-23 10:10:10)
     * @param f
     * @return String （2019年04月23日）
     */
    public static String dateStr(String str, String f) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        Date date = null;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = fmt.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(f);
        String formatStr = format.format(date);
        return formatStr;
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static Date getNow() {
        Calendar cal = Calendar.getInstance();
        Date currDate = cal.getTime();
        return currDate;
    }

    /**
     * 获得当前日期，精确到毫秒
     *
     * @return
     */
    public static Timestamp getNowInMillis() {
        Timestamp timeStamep = new Timestamp(getNow().getTime());
        return timeStamep;
    }

    public static Date getDateByStrTime(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     * @return date1>date2时结果<0, date1=date2时结果=0, date2>date1时结果>0
     */
    public static int daysBetween(Date date1, Date date2, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr(date1, format));
            Date d2 = sdf.parse(DateUtil.dateStr(date2, format));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf((time2 - time1) / 86400000L));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算两个日期之间相差的小时数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int hoursBetween(Date date1, Date date2) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr(date1, "yyyyMMdd"));
            Date d2 = sdf.parse(DateUtil.dateStr(date2, "yyyyMMdd"));
            cal.setTime(d1);
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf((time2 - time1) / 3600000L));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算两个日期相差的时间
     */
    public static void getBetweenDate() {
        String dateStart = "2017111520";
        String dateStop = "2017111620";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            // 毫秒ms
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print("两个时间相差：");
            System.out.print(diffDays + " 天, ");
            System.out.print(diffHours + " 小时, ");
            System.out.print(diffMinutes + " 分钟, ");
            System.out.print(diffSeconds + " 秒.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算两个日期之间相差的小时数
     *
     * @param date1
     * @param date2
     * @return date1>date2时结果<0, date1=date2时结果=0, date2>date1时结果>0
     */
    public static int hoursBetweenByDateStr(Date date1, Date date2) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr(date1, "yyyyMMddHH"));
            Date d2 = sdf.parse(DateUtil.dateStr(date2, "yyyyMMddHH"));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf(((time2 - time1) / 3600000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算两个日期之间相差的分钟数
     *
     * @param date1
     * @param date2
     * @return date1>date2时结果<0, date1=date2时结果=0, date2>date1时结果>0
     */
    public static int minuteBetweenByDateStr(Date date1, Date date2) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr(date1, "yyyyMMddHHmm"));
            Date d2 = sdf.parse(DateUtil.dateStr(date2, "yyyyMMddHHmm"));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf(((time2 - time1) / 60000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算两个日期之间相差的秒数
     *
     * @param date1
     * @param date2
     * @return date1>date2时结果<0, date1=date2时结果=0, date2>date1时结果>0
     */
    public static int secondBetweenByDateStr(Date date1, Date date2) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtil.dateStr(date1, "yyyyMMddHHmmss"));
            Date d2 = sdf.parse(DateUtil.dateStr(date2, "yyyyMMddHHmmss"));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf(((time2 - time1) / 1000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取YYYY格式
     *
     * @return
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     * 获取几年前，几年后的时间 YYYY-MM-DD格式
     *
     * @param i 前后几年的时间 （ -1 去年的今天  1明年的今天  ）
     * @return
     */
    public static String getBeforOrAfterYDay(int i) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, i);
        Date time = c.getTime();
        return sdfDay.format(time);
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @throws @author luguosui
     * @Title: compareDate
     * @Description: (日期比较 ， 如果s > = e 返回true 否则返回false)
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     * (日期比较，如果当前时间在区间内  返回true 否则返回false)
     *
     * @param s 开始时间
     * @param e 结束时间
     * @return boolean
     * @throws @author tian
     * @Title: betweenDate
     * @Description: (日期比较 ， 如果当前时间在区间内 返回true 否则返回false)
     */
    public static boolean betweenDate(String s, String e) {
        if (StringUtil.isEmpty(s) || StringUtil.isEmpty(e)) {
            return true;
        }
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        long times = fomatDate(s).getTime();
        long timee = fomatDate(e).getTime();
        long timen = fomatDate(getDay()).getTime();

        if (timen >= times && timen <= timee) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDateByYYYYMM(String s) {
        if (StringUtil.isEmpty(s)) {
            return false;
        }
        if (!s.contains("-")) {
            return false;
        }
        String[] ss = s.split("-");
        if (ss.length != 2) {
            return false;
        }
        String s1 = ss[1];
        try {
            int MM = Integer.parseInt(s1);
            if (MM < 1 || MM > 12) {
                return false;
            }
        } catch (NumberFormatException e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
        DateFormat fmt = new SimpleDateFormat("yyyy-MM");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
                    / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * <li>功能描述：时间相减得到天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        // System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }

    /**
     * 获取当前周
     *
     * @return
     */
    public static int getWeekToYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(new Date());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取当前周的第一天
     *
     * @return
     */
    public static String getWeekOfMonday() {
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(calendar.MONDAY);
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date monday = calendar.getTime();
        return sdfDay.format(monday);
    }

    /**
     * 获取当前周的最后一天
     *
     * @return
     */
    public static String getWeekOfSunday() {
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(calendar.MONDAY);
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
        Date sunday = calendar.getTime();
        return sdfDay.format(sunday);
    }

    /**
     * 获取指定时间所在周的每一天
     *
     * @return
     */
    public static List<String> getDayofWeek(String time) {
        List<String> dayweekList = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setFirstDayOfWeek(calendar.MONDAY);
        try {
            //设置当前时间
            calendar.setTime(sdfDay.parse(time));
            //设置当前周的第一天
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
            Date monday = calendar.getTime();
            dayweekList.add(sdfDay.format(monday));
            Calendar calendar1 = Calendar.getInstance();
            //设置时间
            calendar1.setTime(monday);
            //获取该周内的剩余时间
            for (int i = 0; i < 6; i++) {
                calendar1.add(Calendar.DAY_OF_MONTH, 1);
                dayweekList.add(sdfDay.format(calendar1.getTime()));
            }
        } catch (ParseException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        return dayweekList;
    }

    /**
     * 得到n天之后是周几
     *
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 获取当前年份前后十年
     *
     * @param 参数
     * @Function DateUtil.java
     * @Description 方法描述
     * @author zzc
     * @version v1.0.0
     * @date 2018年5月9日
     */
    public static List<Integer> getLeastTenYears() {
        String currentYear = DateUtil.getYear();
        // 获取当前年份前后十年的年份值
        int numYear = Integer.parseInt(currentYear);
        List<Integer> yearDict = new ArrayList<Integer>();
        for (int year = numYear - 5; year < numYear + 6; year++) {
            yearDict.add(year);
        }
        return yearDict;
    }

    /**
     * @return Object[][]
     * @description 获取当前年度前后各几年 * @param before 前几年 last 后几年
     */
    public static List<Map<String, String>> getYearArray(int before, int last) {
        String year = DateUtil.getYear();
        int numYear = Integer.parseInt(year);
        numYear = numYear - before;
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for (int i = 0; i <= before + last; i++) {
            Map<String, String> map = new HashMap<String, String>();
            numYear = numYear + 1;
            map.put("KEY", String.valueOf(numYear));
            map.put("VALUE", String.valueOf(numYear));
            result.add(map);
        }
        return result;
    }

    /**
     * 获取指定时间是中午上午中午还是下午
     *
     * @param date
     * @return
     */
    public static String getDuringDay(Date date) {

        SimpleDateFormat sf = new SimpleDateFormat("hh");
        String format = sf.format(date);

        int hour = Integer.parseInt(format);

        if (hour >= 1 && hour < 11) {
            return "上午";
        } else if (hour >= 11 && hour <= 13) {
            return "中午";
        } else if (hour >= 14 && hour <= 24) {
            return "下午";
        } else {
            return null;
        }
    }

    /**
     * 返回起止时间中所有的时间
     *
     * @param s
     * @param e
     * @return
     */
    public static List<String> collectLocalDates(String s, String e) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parses = new SimpleDateFormat("yyyy-MM-dd").parse(s);
            Date parsee = new SimpleDateFormat("yyyy-MM-dd").parse(e);
            String ss = format.format(parses);
            String ee = format.format(parsee);
            return collectLocalDates(LocalDate.parse(ss), LocalDate.parse(ee));

        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 收集起始时间 到 结束时间之间所有的时间并以字符串集合方式返回
     *
     * @param s
     * @param e
     * @return
     */
    public static List<String> collectLocalDates(LocalDate s, LocalDate e) {
        //用起止时间作为流的源头,按照每次加一天的方式创建一个无限流
        return Stream.iterate(s, localDate -> localDate.plusDays(1))
                //截断无限流,长度为起始时间和结束时间的差 + 1
                .limit(ChronoUnit.DAYS.between(s, e) + 1)
                //由于最后要的是字符串,所以用map转换
                .map(LocalDate::toString)
                //把流收集为list
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
//		collectLocalDates("2019-02-01 12:12:12", "2019-03-10").forEach(System.out::println);
        String getBeforOrAfterYDay = getBeforOrAfterYDay(-2);
        System.out.println(getBeforOrAfterYDay);

    }

}
