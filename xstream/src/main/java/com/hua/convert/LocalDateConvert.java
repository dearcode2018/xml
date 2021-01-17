/**
  * @filename LocalDateConvert.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.hua.constant.FormatConstant;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;


/**
 * @type LocalDateConvert
 * @description 日期转换器
 * @author qianye.zheng
 */
public class LocalDateConvert extends AbstractSingleValueConverter {
    
    private static final String FORMAT = FormatConstant.DATE_FORMAT_yyyy_MM_dd;
 
    /**
     * @description 
     * @param type
     * @return
     * @author qianye.zheng
     */
    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
        return LocalDate.class == type;
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
        return LocalDate.parse(str, formatter);
    }
    
    /**
     * @description 
     * @return
     * @author qianye.zheng
     */
    @Override
    public String toString(final Object obj) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
        return formatter.format((LocalDate) obj);
    }
}
