/**
  * @filename DateTimeHandler.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.exolab.castor.mapping.GeneralizedFieldHandler;

import com.hua.constant.Constant;

 /**
 * @type DateTimeHandler
 * @description 日期时间处理器
 * @author qianye.zheng
 */
//implements FieldHandler<Date>
public final class DateTimeHandler extends GeneralizedFieldHandler {

	private DateFormat dateFormat = new 
			SimpleDateFormat(Constant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss);
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public DateTimeHandler() {
	}

	/**
	 * @description 输出bean到xml
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Object convertUponGet(final Object value)
	{
	    if (null == value)  
	    {
	    	return null;  
	    }
	    
        return dateFormat.format((Date) value);  
	}

	/**
	 * @description 读取xml为bean
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Object convertUponSet(final Object value)
	{
        if (null == value) 
        {
        	return null;  
        }
        
        Date date = null;  
        try {  
            date = dateFormat.parse((String) value);  
        } catch (ParseException e) {  
            throw new IllegalArgumentException(e);  
        }  
        return date; 
	}

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Class<?> getFieldType()
	{
		return Date.class;
	}

}
