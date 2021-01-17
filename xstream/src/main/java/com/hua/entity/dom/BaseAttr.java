/**
 * BaseAttr.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity.dom;

import com.hua.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述: 通用属性
 * @author qye.zheng
 * BaseAttr
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseAttr extends BaseEntity {
	
	private static final long serialVersionUID = -2609044216524481513L;

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
	
}
