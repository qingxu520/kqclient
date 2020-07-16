package co.goho.qingxu.kq.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {


    private static final List<String> formarts = new ArrayList<String>(4);
    static{

        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd HH:mm:ss");

    }

    public static Date convert(String source) {
        if ("".equals(source)||"null".equals(source)) {
            return null;
        }
        String value = source.trim();
        if ("".equals(value)||"null".equals(value)) {
            return null;
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){

            return parseDate(source, formarts.get(0));

        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){

            return parseDate(source, formarts.get(1));
        }
        else {
            throw new IllegalArgumentException("错误的时间格式，时间值 '" + source + "'");
            //return convert("1700");
        }
    }

    public static  Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }


    public static String getStrDate(){
        /**
         * @Title:获取当前时间
         *@Author: srs
         *@Description:
         *@Params: * @param
         *@return:
         *@Date: 2019/3/12
         *
         */


        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = dtf2.format(ldt);
        return strDate;
    }
}
