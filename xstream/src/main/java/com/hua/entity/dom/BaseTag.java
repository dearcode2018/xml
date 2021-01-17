/**
 * BaseTag.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity.dom;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述: 标签 公共属性
 * @author qye.zheng
 * BaseTag
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseTag extends BaseAttr {
	
	private static final long serialVersionUID = 1L;

    /* 名称属性 */
	private String tagName;
	
	/* 标签文本 */
	private String text;
	
	public BaseTag() {}
	
	/** 有参构造方法 */
	public BaseTag(final String id, final String name) {}

	
}
