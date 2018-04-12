/**
  * @filename UserHandler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import com.hua.bean.User;
import com.hua.util.DateTimeUtil;

 /**
 * @type UserHandler
 * @description 
 * @author qianye.zheng
 */
public final class UserHandler extends BaseHandler<User>
{
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public UserHandler() {
		super("", User.class);
	}
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public UserHandler(final String path)
	{
		// 传入泛型参数即可
		super(path, User.class);
	}

	/**
	 * @description 设置Bean的值
	 * @param field
	 * @param value
	 * @author qianye.zheng
	 */
	@Override
	public final void set(final String field, final String value)
	{
		final User user = get();
		if (null != field)
		{
			switch (field)
			{
				case "id":
				{
					user.setId(value);
					
					break;
				}
				case "username":
				{
					user.setUsername(value);
					
					break;
				}
				case "nickname":
				{
					user.setNickname(value);
					
					break;
				}
				case "password":
				{
					user.setPassword(value);
					
					break;
				}
				case "valid":
				{ // boolean
					user.setValid(Boolean.valueOf(value));
					
					break;
				}
				case "lastLoginTime":
				{ // 日期时间字段 如何转换，在此体现
					user.setLastLoginTime(DateTimeUtil.parseDateTime(value));
					
					break;
				}
				case "lastLoginIp":
				{
					user.setLastLoginIp(value);
					
					break;
				}
				default:
				{
					//System.out.println("element: " + field + "no match field");
					break;
				}
			}
		}
	}
	
	/**
	 * @return the user
	 */
	public final User get()
	{
		return super.get();
	}
	
}
