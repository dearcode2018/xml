/**
  * @filename DateHandler.java
  * @description 日期处理器
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.exolab.castor.mapping.FieldHandler;
import org.exolab.castor.mapping.GeneralizedFieldHandler;

import com.hua.constant.Constant;

 /**
 * @type DateHandler
 * @description  
 * @author qianye.zheng
 */
// implements FieldHandler<Date>
public final class DateHandler extends GeneralizedFieldHandler {

	private DateFormat dateFormat = new 
			SimpleDateFormat(Constant.DATE_FORMAT_yyyy_MM_dd);
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public DateHandler() {
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
