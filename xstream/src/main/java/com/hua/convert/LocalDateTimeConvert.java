/**
  * @filename LocalDateTimeTimeConvert.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.hua.constant.FormatConstant;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;


/**
 * @type LocalDateTimeTimeConvert
 * @description 日期时间转换器
 * @author qianye.zheng
 */
public class LocalDateTimeConvert extends AbstractSingleValueConverter {
    
    private static final String FORMAT = FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss;
 
    /**
     * @description 
     * @param type
     * @return
     * @author qianye.zheng
     */
    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
        return LocalDateTime.class == type;
    }
    
    /**
     * @description 
     * @param str
     * @return
     * @author qianye.zheng
     */
    @Override
    public Object fromString(String str) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
        return LocalDateTime.parse(str, formatter);
    }
    
    /**
     * @description 
     * @return
     * @author qianye.zheng
     */
    @Override
    public String toString(final Object obj) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
        return formatter.format((LocalDateTime) obj);
    }
    
}
