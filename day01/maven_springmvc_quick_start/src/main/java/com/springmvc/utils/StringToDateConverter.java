package com.springmvc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转化成日期
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     *
     * @param source 传入进来的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        // 判断
        if(source == null) {
            throw new RuntimeException("没有传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 把字符串转化成一个日期
        try {
            // 把日期转化成字符串
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
