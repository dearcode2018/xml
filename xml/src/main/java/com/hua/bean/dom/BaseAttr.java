/**
 * BaseAttr.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.bean.dom;

import com.hua.entity.BaseEntity;

/**
 * 描述: 通用属性
 * @author qye.zheng
 * BaseAttr
 * 
 */
public class BaseAttr extends BaseEntity {
	
	/* key : id */
	public static final String KEY_ID = "id";
	
	/* key : name */
	public static final String KEY_NAME = "name";
	
	/* key : value */
	public static final String KEY_VALUE = "value";

	/* id 属性 */
	private String id;
	
	/* 名称属性 */
	private String name;
	
	/* 值属性 */
	private String value;

	/** 无参构造方法 */
	public BaseAttr() {}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
