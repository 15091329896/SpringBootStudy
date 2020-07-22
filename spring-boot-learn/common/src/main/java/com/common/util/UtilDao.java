package com.common.util;

import com.common.bean.WeekDate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("JavadocReference")
public class UtilDao {

    private final static Logger logger=LoggerFactory.getLogger(UtilDao.class);

    public static SimpleDateFormat dateFormatDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateFormatDateNum=new SimpleDateFormat("yyyyMMdd0");
    public static SimpleDateFormat dateFormatDate=new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormatMonth=new SimpleDateFormat("yyyy-MM");
    public static SimpleDateFormat dateFormatTime=new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat dateFormatWeek=new SimpleDateFormat("EEEE", Locale.ENGLISH);


    public static String getWeekNoInMonth(String date, String weekNoInYear) {
        /**
         * 根据周和年得到开始和结束日期
         * 根据开始和结束日期进行匹配周的月的位置
         */
        String[] weekDate=UtilDao.getWeekDateFromWeekNo(Integer.valueOf(date.substring(0, 4)), Integer.valueOf(weekNoInYear));
        List<WeekDate> weekDateOfMonth=UtilDao.getWeekDateOfMonth(date);
        for (WeekDate weekDate2 : weekDateOfMonth) {
            if (weekDate2.getStartDate().equals(weekDate[0]) && weekDate2.getEndDate().equals(weekDate[1])) {
                return weekDate2.getWeekNO().toString();
            }
        }
        return null;
    }


    /**
     * 根据当前月的字符串得到上个月的字符串表示
     *
     * @param yearMonth 2020-05
     * @return 2020-04
     */
    public static String getLastMonth(String yearMonth) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
            Calendar c=Calendar.getInstance();
            c.setTime(format.parse(yearMonth));
            c.add(Calendar.MONTH, -1);
            Date lastMonthDate=c.getTime();
            String lastMonthString=format.format(lastMonthDate);
            return lastMonthString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getLastMonth解析时间失败 ");
        }
        return null;
    }

    /**
     * 根据当前月的字符串得到下个月的字符串表示
     *
     * @param yearMonth 2020-05
     * @return 2020-06
     */
    public static String getNextMonth(String yearMonth) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
            Calendar c=Calendar.getInstance();
            c.setTime(format.parse(yearMonth));
            c.add(Calendar.MONTH, 1);
            Date lastMonthDate=c.getTime();
            String lastMonthString=format.format(lastMonthDate);
            return lastMonthString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getNextMonth解析时间失败 ");
        }
        return null;
    }


    public static Date parseDate(String dateString) {
        try {
            return dateFormatDate.parse(dateString);
        } catch (ParseException e) {
            logger.info(" UtilDao 里面的 parseDate 函数解析日期字符串失败 ");
        }
        return null;
    }

    public static Date parseMonth(String monthString) {
        try {
            return dateFormatMonth.parse(monthString);
        } catch (ParseException e) {
            logger.info(" UtilDao 里面的 parseMonth 函数解析日期字符串失败 ");
        }
        return null;
    }

    /**
     * 获取上周的今天的date
     *
     * @param yearMonth
     * @return
     */
    public static String getThisDayInLastWeek(String date) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(format.parse(date));
            c.add(Calendar.WEEK_OF_YEAR, -1);
            Date date2=c.getTime();
            String resultString=format.format(date2);
            return resultString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getThisDayInLastWeek解析时间失败 ");
        }
        return null;
    }

    /**
     * 获取昨天的date
     *
     * @param yearMonth
     * @return
     */
    public static String getLastDay(String date) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(format.parse(date));
            c.add(Calendar.DATE, -1);
            Date date2=c.getTime();
            String resultString=format.format(date2);
            return resultString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getLastDay解析时间失败 ");
        }
        return null;
    }

    /**
     * 获取上周的date
     *
     * @param yearMonth
     * @return
     */
    public static String getLastWeek(String date) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(format.parse(date));
            c.add(Calendar.WEEK_OF_YEAR, -1);
            Date date2=c.getTime();
            String resultString=format.format(date2);
            return resultString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getLastDay解析时间失败 ");
        }
        return null;
    }

    /**
     * 获取下周的date
     *
     * @param yearMonth
     * @return
     */
    public static String getNextWeek(String date) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c=Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            c.setTime(format.parse(date));
            c.add(Calendar.WEEK_OF_YEAR, 1);
            Date date2=c.getTime();
            String resultString=format.format(date2);
            return resultString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getLastDay解析时间失败 ");
        }
        return null;
    }

    /**
     * 获取去年这个月的时间
     *
     * @param yearMonth
     * @return
     */
    public static String getThisMonthInLastYear(String yearMonth) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
            Calendar c=Calendar.getInstance();
            c.setTime(format.parse(yearMonth));
            c.add(Calendar.YEAR, -1);
            Date lastMonthDate=c.getTime();
            String lastMonthString=format.format(lastMonthDate);
            return lastMonthString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getLastMonth解析时间失败 ");
        }
        return null;
    }
//    /**
//     * 获取上个月的同一位置的周
//     * @param yearMonth
//     * @return
//     */
//    public static String getThisWeekInLastMonth(String yearWeek){
//    	/*
//    	 * 获取当前周的周一的日期
//    	 * 倒退一个月
//    	 * 计算出对应的周数
//    	 * 
//    	 */
//    	
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
//            Calendar c = Calendar.getInstance();
//            c.setTime(format.parse(yearWeek));
//            c.add(Calendar.MONTH, -1);
//            Date lastMonthDate = c.getTime();
//            String lastMonthString = format.format(lastMonthDate);
//            return lastMonthString;
//        } catch (ParseException e) {
//            logger.error(" UtilDao中的函数getLastMonth解析时间失败 ");
//        }
//        return null;
//    }

    public static String getLastYear(String year) {
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy");
            Calendar c=Calendar.getInstance();
            c.setTime(format.parse(year));
            c.add(Calendar.YEAR, -1);
            Date lastYearDate=c.getTime();
            String lastYearString=format.format(lastYearDate);
            return lastYearString;
        } catch (ParseException e) {
            logger.error(" UtilDao中的函数getLastYear解析时间失败 ");
        }
        return null;
    }

    public static String[] getWeekDateFromWeekNo(Integer year, Integer week) {
        String[] strings=new String[2];
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, Integer.valueOf(year));
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        String beginDate=sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        String endDate=sdf.format(cal.getTime());
        strings[0]=beginDate;
        strings[1]=endDate;
        return strings;
    }

    public static List<WeekDate> getWeekDateOfMonth(String yearMonth) {
        List<WeekDate> result=new ArrayList<WeekDate>();
        String str=yearMonth + "-05";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        sdf1.setLenient(false);
        SimpleDateFormat sdf2=new SimpleDateFormat("EEEE", Locale.ENGLISH);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String format=null;
        try {
            Date parse=sdf.parse(str);
            Calendar lastDate=Calendar.getInstance();
            lastDate.setTime(parse);
            lastDate.set(Calendar.DATE, 1);
            lastDate.add(Calendar.MONTH, 1);
            lastDate.add(Calendar.DATE, -1);
            format=sdf.format(lastDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int tmp=0;
        WeekDate weekDate=null;
        for (int i=1; i < 32; i++) {
            try {
                Date date=sdf1.parse(yearMonth + "-" + i);
                if (sdf2.format(date).equals("Monday") || sdf2.format(date).equals("Sunday")
                        || Integer.parseInt(sdf1.format(date).toString().substring(8, 10)) == 1
                        || Integer.parseInt(sdf1.format(date).toString().substring(8, 10)) == Integer.parseInt(format.substring(8, 10))
                ) {
                    if (!sdf2.format(date).equals("Sunday")) {
                        weekDate=new WeekDate();
                        weekDate.setWeekNO(tmp++);
                        weekDate.setStartDate(sdf1.format(date));
                    }
                    if (sdf2.format(date).equals("Sunday")) {
                        weekDate.setEndDate(sdf1.format(date));
                        result.add(weekDate);
                    }
                }

            } catch (ParseException e) {
            }
        }
        return result;
    }

    public static String getToken() {
        String respondBody=sendPost();
        String token=getTokenFromRespond(respondBody);
        return token;
    }

    private static String getTokenFromRespond(String jsonString) {
        JSONObject json=JSONObject.fromObject(jsonString);
        String data=json.getString("Data");
        json=JSONObject.fromObject(data);
        String token=json.getString("token");
        System.out.println(token);
        return token;
    }

    private static String sendPost() {
        String urlString="http://192.168.0.21/security-web/systemManage/system/login";
        String body="{\"account\":\"admin\",\"password\":\"zrrh/iW7aERpBeyk95x5Ow==\"}";
        return post(urlString, body);
    }


    public static String post(String urlStr, String body) {
        try {
            URL url=new URL(urlStr);
            HttpURLConnection httpConnection=(HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            // 设置Content-Type
            httpConnection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.129 Safari/537.36");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            // 设置是否向httpUrlConnection输出，post请求设置为true，默认是false
            httpConnection.setDoOutput(true);
            // 设置RequestBody
            PrintWriter printWriter=new PrintWriter(httpConnection.getOutputStream());
            printWriter.write(body);
            printWriter.flush();
            httpConnection.setConnectTimeout(20000);

            /*
             *获取响应
             */
            int responseCode=httpConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream=httpConnection.getInputStream();
                String token=getStringFromInputStream(inputStream);
                return token;
            }
            if (responseCode == 408) {
                return "请求失败";
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStringFromInputStream(InputStream input) {
        if (input == null) {
            logger.info(" InputStream = null ");
        }
        //字节数组
        byte[] bcache=new byte[2048];
        int readSize=0;//每次读取的字节长度
        int totalSize=0;//总字节长度
        ByteArrayOutputStream infoStream=new ByteArrayOutputStream();
        try {
            //一次性读取2048字节
            while ((readSize=input.read(bcache)) > 0) {
                totalSize+=readSize;
                if (totalSize > 1024 * 50) {
                    logger.info("输入流超出50K大小限制");
                }
                //将bcache中读取的input数据写入infoStream
                infoStream.write(bcache, 0, readSize);
            }
        } catch (IOException e1) {
            logger.info("输入流读取异常");
        } finally {
            try {
                //输入流关闭
                input.close();
            } catch (IOException e) {
                logger.info("输入流关闭异常");
            }
        }
        try {
            return infoStream.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.info("输出异常");
        }
        return null;
    }

    public static long getIPNum(String ipAddress) {
        String[] ip=ipAddress.split("\\.");
        long a=Integer.parseInt(ip[0]);
        long b=Integer.parseInt(ip[1]);
        long c=Integer.parseInt(ip[2]);
        long d=Integer.parseInt(ip[3]);
        long ipNum=a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }

    public static boolean telnet(String hostname, int port, int timeout) {
        Socket socket=new Socket();
        boolean isConnected=false;
        try {
            socket.connect(new InetSocketAddress(hostname, port), timeout); // 建立连接
            isConnected=socket.isConnected(); // 通过现有方法查看连通状态
            logger.info(hostname + " " + port + " 连通状态为 " + isConnected);    // true为连通
        } catch (IOException e) {
            logger.info(hostname + " " + port + " 连通状态为  false");        // 当连不通时，直接抛异常，异常捕获即可
        } finally {
            try {
                socket.close();   // 关闭连接
            } catch (IOException e) {
                logger.info(hostname + " " + port + " 连通状态为  false");
            }
        }
        return isConnected;
    }


    public static String getNextDateTimeFromTime(int scanTimeSpan, String startTime) {
        SimpleDateFormat fmt=new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
        Date start=null;
        Date now=null;
        try {
            start=fmt.parse(startTime);
            now=fmt.parse(fmt.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long min=(now.getTime() - start.getTime()) / (1000 * 60);
        long time=(((min / scanTimeSpan) + 1) * scanTimeSpan) * (1000 * 60) + start.getTime();

        Date now2=new Date();
        long min2=(now2.getTime() - start.getTime()) / (1000 * 60);
        long time2=(((min2 / scanTimeSpan) + 1) * scanTimeSpan) * (1000 * 60) + start.getTime();
        String year=sdf2.format(new Date(time2));
        Date date=new Date(time);
        return year + " " + fmt.format(date);
    }

    public static String executeShell(String param, Logger logger) {
        logger.info("执行参数------" + param);
        String result="";
        String command=param;
        String[] commands={"/bin/sh", "-c", command};

        try {
            Process p=Runtime.getRuntime().exec(commands);
            InputStream is=p.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=reader.readLine()) != null) {
                result=line;
            }
            logger.info("执行结果------" + result);
            p.waitFor();
            is.close();
            reader.close();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String getDoubleStringWithTwoPoint(Object object) {
        String doubleString=getString(object);
        if (doubleString == null) {
            return null;
        }
        String doubleStringWithTwoPoint=UtilDao.getDoubleStringWithTwoPoint(UtilDao.getDoubleFromString(doubleString));
        return doubleStringWithTwoPoint;
    }

    public static Double getDoubleWithTwoPoint(Object object) {
        String doubleString=getString(object);
        if (doubleString == null) {
            return null;
        }
        String doubleStringWithTwoPoint=UtilDao.getDoubleStringWithTwoPoint(UtilDao.getDoubleFromString(doubleString));
        return new Double(doubleStringWithTwoPoint);
    }

    public static String getDoubleStringWithTwoPoint(String doubleString) {
        if (doubleString == null) {
            return null;
        }
        String doubleStringWithTwoPoint=UtilDao.getDoubleStringWithTwoPoint(UtilDao.getDoubleFromString(doubleString));
        return doubleStringWithTwoPoint;
    }

    public static String getDoubleStringWithTwoPoint(Double double1) {
        if (double1 == null) {
            return null;
        }
        String formatDouble=new DecimalFormat("0.00").format(double1);
        return formatDouble;
    }

    public static Double getDoubleFromPercentString(String percentString) {
        if (percentString == null) {
            return null;
        }
        Double double1=new Double(percentString.substring(0, percentString.indexOf("%"))) / 100;
        String formatDouble=new DecimalFormat("0.00").format(double1);
        return double1;
    }

    public static String getPercentFromDouble(Double double1) {
        DecimalFormat df=new DecimalFormat("0.00%");
        String percentString=df.format(double1);
        return percentString;
    }

    public static Double getDoubleFromString(String doubleString) {
        if (doubleString == null) {
            return null;
        }
        Double double1=new Double(doubleString);
        return double1;
    }

    /**
     * 根据年得到这一年的时间段的两个端点dateTime
     */
    public static String[] getDateTimeSpaceByYear(String year) {
        String[] result=new String[2];
        StringBuffer start=new StringBuffer();
        StringBuffer end=new StringBuffer();
        start.append(year).append("-01-01 00:00:00");
        end.append(year).append("-12-31 23:59:59");
        result[0]=start.toString();
        result[1]=end.toString();
        return result;
    }

    public static int getMonthDayNum(String Monthdate) {
        Calendar calendar=Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM").parse(Monthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int actualMaximum=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return actualMaximum;
    }

    public static int getWeekNumOfMonth(String Monthdate) {
        Calendar calendar=Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM").parse(Monthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setFirstDayOfWeek(Calendar.FRIDAY);
        int actualMaximum=calendar.getMaximum(Calendar.WEEK_OF_MONTH);
        return actualMaximum;
    }

    /**
     * 根据年和月份得到这一月的时间段的两个端点dateTime
     */
    public static String[] getDateTimeSpaceByYearMonth(String yearMonth) {
        String[] result=new String[2];
        StringBuffer start=new StringBuffer();
        StringBuffer end=new StringBuffer();
        start.append(yearMonth).append("-01 00:00:00");
        end.append(yearMonth).append("-").append(getMonthDayNum(yearMonth)).append(" 23:59:59");
        result[0]=start.toString();
        result[1]=end.toString();
        return result;
    }

//	/**
//	 * 根据年和周数得到这一周的时间段的两个端点dateTime
//	 */
//	public String[] getDateTimeSpaceByYearWeek(String yearWeek) {
//		String[] result = new String[2];
//		StringBuffer start  = new StringBuffer();
//		StringBuffer end  = new StringBuffer();
//		StringBuffer sql = new StringBuffer();
//		sql.append(" select str_to_date(concat('" + yearWeek + "', '-1'), '%Y-%u-%w') weekStartDate, str_to_date(concat('" + yearWeek + "', '-0'), '%Y-%u-%w') weekEndDate ");
//		System.out.println(" getDateTimeSpaceByYearWeek --- sql = " + sql.toString());
//		List<Object> list = getSession().createSQLQuery(sql.toString()).list();
//		Object[] objects = (Object[]) list.get(0);
//		String startDate = UtilDao.getString(objects[0]);
//		String endDate = UtilDao.getString(objects[1]);
//		start.append(startDate).append(" 00:00:00");
//		end.append(endDate).append(" 23:59:59");
//		result[0] = start.toString();
//		result[1] = end.toString();
//		return result;
//    }


    public static String getCurrentDateTimeString() {
        return dateFormatDateTime.format(new Date());
    }

    public static String getCurrentDateString() {
        String currentDateString=dateFormatDate.format(new Date());
        return currentDateString;
    }

    public static String getCurrentTimeString() {
        return dateFormatTime.format(new Date());
    }

    /**
     * 将对象数组转为json字符串
     *
     * @param object
     * @return
     */
    public static String converseObjectArrayToJSON(Object object) {
        String jsonString="";
        JSONArray json=JSONArray.fromObject(object);
        jsonString=json.toString();
        return jsonString;
    }

    /**
     * 将json字符串转为JSON对象
     *
     * @param object
     * @return
     */
    public static JSONObject conversJsonStringToJsonObject(String jsonString) {
        JSONObject json=JSONObject.fromObject(jsonString);
        return json;
    }


    /**
     * 将对象转为json字符串
     *
     * @param object
     * @return
     */
    public static String converseObjectToJSON(Object object) {
        JSONObject json=JSONObject.fromObject(object);
        return json.toString();
    }


    public static String dealNullString(String string) {
        if (string == null || string.isEmpty() || string.equals("null")) {
            return null;
        }
        return string;
    }

    public static String dealDateTimeString(String string) {
        string=dealNullString(string);
        if (string != null) {
            string=string.length() > 19 ? string.substring(0, 19) : string;
        }
        return string;
    }

    public static String dealInputNullString(String string) {
        return string == null || string.equals("") || string.equals("null") ? " null " : "    '" + string + "' ";
    }


    public static String dealInsertNullString(String string) {
        return string == null || string.equals("") || string.equals("null") ? " null " : "    '" + string + "' ";
    }


    public static String dealInsertString(String string) {
        return string == null || string.equals("") || string.equals("null") ? " null " : "    '" + string + "' ";
    }

    public static String dealInsertLong(Long inputLong) {
        return inputLong == null || inputLong.toString().equals("") || inputLong.toString().equals("null") ? " null " : "    " + inputLong + " ";
    }

    public static String dealInsertNullLong(Long inputLong) {
        return inputLong == null || inputLong.toString().equals("") || inputLong.toString().equals("null") ? " null " : "    " + inputLong + " ";
    }

    public static String dealInsertNullLongComma(Long inputLong) {
        return inputLong == null || inputLong.toString().equals("") || inputLong.toString().equals("null") ? " null, " : "    " + inputLong + ",";
    }

    public static String dealInsertNullStringComma(String inputString) {
        return inputString == null || inputString.equals("") || inputString.equals("null") ? " ''," : "'" + inputString + "',";
    }

    public static String dealInsertNullDateTimeComma(String inputString) {
        return inputString == null || inputString.equals("") || inputString.equals("null") ? " null," : "'" + inputString + "',";
    }


    public static String getString(Object object) {
        if (object == null) {
            return null;
        }
        String string=object.toString();
        if (string == null || string.isEmpty() || string.equals("null")) {
            return null;
        }
        return string;
    }


    public static String getDateTimeString(Object object) {
        String string=getString(object);
        if (string != null) {
            return dealDateTimeString(string);
        }
        return null;
    }


    public static String getDateString(Object object) {
        String string=getString(object);
        if (string != null) {
            return dealDateTimeString(string);
        }
        return null;
    }

    public static Boolean dealBoolean(String string) {
        string=dealNullString(string);
        if (string != null) {
            return getString(string).equals("ture") ? true : false;
        }
        return null;
    }


    public static Boolean getBoolean(Object object) {
        if (object == null) {
            return null;
        }
        String string=object.toString();
        string=dealNullString(string);
        if (string != null) {
            return getString(string).matches("true|1") ? true : false;
        }
        return null;
    }


    public String dealInsertLongIDs(List<Long> IDs) {
        StringBuffer IDsString=new StringBuffer();
        for (Long long1 : IDs) {
            IDsString.append(long1.toString());
            IDsString.append(",");
        }
        return IDsString.substring(0, IDsString.length() - 1).toString();
    }

    public static String dealInsertBoolean(Boolean boolean1) {
        return boolean1 ? "1" : "0";
    }

    public static String dealInsertBoolean(String booleanStr) {
        if (booleanStr.equals("true")) {
            return "1";
        }
        return "0";
    }

    public static String dealReqBoolean(String stringTrue) {
        Boolean boolean1=Boolean.valueOf(stringTrue);
        return boolean1 ? "1" : "0";
    }

    public static Long dealLong(Object object) {
        if (object == null) {
            return null;
        }
        String string=object.toString();
        string=dealNullString(string);
        if (string != null) {
            try {
                return Long.valueOf(string);
            } catch (NumberFormatException e) {
                System.out.println("Long类型转换失败");
            }
        }
        return null;
    }


    public static Long getLong(Object object) {
        if (object == null) {
            return null;
        }
        String string=object.toString();
        string=dealNullString(string);
        if (string != null) {
            try {
                return Long.valueOf(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static Long getLongReturnZero(Object object) {
        if (object == null) {
            return 0L;
        }
        String string=object.toString();
        string=dealNullString(string);
        if (string != null) {
            try {
                return Long.valueOf(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }


    public static Long getLong(String string) {
        if (string == null) {
            return null;
        }
        string=dealNullString(string);
        if (string != null) {
            try {
                return Long.valueOf(string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static String executeShell(String param) {
        String result="";
        String command=param;
        String[] commands={"/bin/sh", "-c", command};

        try {
            Process p=Runtime.getRuntime().exec(commands);
            InputStream is=p.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line=reader.readLine()) != null) {
                result=line;
            }
            p.waitFor();
            is.close();
            reader.close();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Integer dealInt(String string) {
        string=dealNullString(string);
        if (string != null) {
            return Integer.parseInt(getString(string));
        }
        return null;
    }

    public static Integer parseIntReturnNull(String string) {
        string=dealNullString(string);
        if (string != null) {
            return Integer.parseInt(string);
        }
        return null;
    }

    public static Integer getIntegerReturnNull(Object object) {
        if (object == null) {
            return null;
        }
        String string=object.toString();
        string=dealNullString(string);
        if (string != null) {
            return Integer.parseInt(string);
        }
        return null;
    }

    public static Integer getIntegerReturnZero(Object object) {
        if (object == null) {
            return null;
        }
        String string=object.toString();
        string=dealNullString(string);
        if (string != null) {
            return Integer.parseInt(string);
        }
        return 0;
    }

    public static Integer parseIntReturnZero(String string) {
        string=dealNullString(string);
        if (string != null) {
            return Integer.parseInt(string);
        }
        return 0;
    }


    public static String formatDateStringToSiteBD(String date) {
        if (date.matches("[0-9]{4}-[0-9]{1}")) {
            return new StringBuffer().append(date.substring(0, 5)).append("0").append(date.substring(5)).toString();
        }
        if (date.matches("[0-9]{4}-[0-9]{1}-[0-9]{1}")) {
            return new StringBuffer().append(date.substring(0, 5)).append("0").append(date.charAt(5)).append("-0").append(date.charAt(7)).toString();
        }
        if (date.matches("[0-9]{4}-[0-9]{2}-[0-9]{1}")) {
            return new StringBuffer().append(date.substring(0, 7)).append("-0").append(date.charAt(8)).toString();
        }
        if (date.matches("[0-9]{4}-[0-9]{1}-[0-9]{2}")) {
            return new StringBuffer().append(date.substring(0, 5)).append("0").append(date.charAt(5)).append(date.substring(6)).toString();
        }
        return date;
    }

    public static Date getDateTimeByTime(String startTimeHHmmss) {
        StringBuffer startTimeBuffer=new StringBuffer();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        startTimeBuffer.append(dateFormat.format(new Date()).toString()).append(" ").append(startTimeHHmmss);
        try {
            return dateFormatTime.parse(startTimeBuffer.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据给出的日期计算出给出日期所在周的周一到周天的日期
     *
     * @param startDate
     * @return
     */
    public static List<String> getWeekDateFromDate(String dateString) {
        List<String> dateWeekList=new ArrayList<String>();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("日期解析失败");
        }
        String time="";
        //count 用来存取与当天日期的相差数
        int count=0;
        for (int i=1; i < 8; i++) {
            //新建日历
            Calendar cal=Calendar.getInstance();
            //在日历中找到当前日期
            cal.setTime(date);
            //当前日期是本周第几天，默认按照中国习惯Monday为一周的第一天(末尾的+1的由来)
            count=-cal.get(Calendar.DAY_OF_WEEK) + 1;
            //循环。当天与本周周一到周日相差的天数
            cal.add(Calendar.DATE, count + i);
            //转化格式
            time=dateFormat.format(cal.getTime());
            //存入list
            dateWeekList.add(time);
        }
        return dateWeekList;
    }


    /**
     * 得到当前的月的字符串
     *
     * @return
     */
    public static String getCurrentMonth() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
        String format=dateFormat.format(new Date());
        return format;
    }

    /**
     * 得到当前的月的字符串
     *
     * @return
     */
    public static String getMonthFromDate(String dateString) {
        Date parseDate=parseDate(dateString);
        String format=dateFormatMonth.format(parseDate);
        return format;
    }

    /**
     * 根据给出的日期计算出给出日期所在周的周一到周天的日期
     *
     * @param startDate
     * @return
     */
    public static String formatMonthFromDateString(String dateString) {
        try {
            Date date=dateFormatDate.parse(dateString);
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
            String format=dateFormat.format(date);
            return format;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }


    /**
     * 获取两个日期之间相差的天数
     *
     * @param startDateString
     * @param endDateString
     * @return Long类型的天数
     */
    public static Long getDateLength(String startDateString, String endDateString) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate=sdf.parse(startDateString);
            Date endDate=sdf.parse(endDateString);
            Long betweenDate=(endDate.getTime() - startDate.getTime()) / (60 * 60 * 24 * 1000);
            System.out.println(betweenDate);
            return betweenDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}	
