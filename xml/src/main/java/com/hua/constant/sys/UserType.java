/**
* UserType.java
* 
* @author qye.zheng
* 	version 1.0
 */
package com.hua.constant.sys;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @type UserType
 * @description  用户类型
 * @author qianye.zheng
 */
public enum UserType {

	ADMIN("001", "超级管理员"),
	
	MANAGER("002", "普通管理员"),
	
	OPERATOR("003", "业务操作员"),
	
	VIP("004", "VIP用户"),
	
	NORMAL("005", "普通用户"),
	
	VISITOR("101", "游客")
	;
	
	private static final Map<String, UserType> codeObjectMap = 
			new HashMap<String, UserType>();
	
	/* 类型编码 */
	private String code;
	
	/* 类型名称 */
	private String name;
	
	static
	{
		codeObjectMap.put("001", UserType.ADMIN);
		codeObjectMap.put("002", UserType.MANAGER);
		codeObjectMap.put("003", UserType.OPERATOR);
		codeObjectMap.put("004", UserType.VIP);
		codeObjectMap.put("005", UserType.NORMAL);
		codeObjectMap.put("101", UserType.VISITOR);
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param code
	 * @param name
	 * @author qianye.zheng
	 */
	private UserType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @description 
	 * @param code
	 * @return
	 * @author qianye.zheng
	 */
	public static final UserType get(final String code)
	{
		return codeObjectMap.get(code);
	}
	
}
