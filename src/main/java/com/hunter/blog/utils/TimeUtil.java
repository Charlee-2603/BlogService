package com.hunter.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/12 13:32
 */
public class TimeUtil {

    /**
     * 日期转换成字符串形式, 如time = "2016-3-16 4:12:16"
     */
    public static final String getSystemTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
