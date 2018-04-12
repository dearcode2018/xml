/**
  * @filename UserTypeHandler.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import org.exolab.castor.mapping.GeneralizedFieldHandler;

import com.hua.constant.sys.UserType;

 /**
 * @type UserTypeHandler
 * @description  
 * @author qianye.zheng
 */
public class UserTypeHandler extends GeneralizedFieldHandler {

	/**
	 * @description 
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Object convertUponGet(Object value) {
		String result = null;
		if (value instanceof UserType)
		{
			result = ( (UserType) value).getCode();
		}
		
		return result;
	}

	/**
	 * @description 
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Object convertUponSet(Object value) {
		return UserType.get((String) value);
	}

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Class<?> getFieldType() {
		return UserType.class;
	}

}
