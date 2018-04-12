/**
 * BaseTag.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity.dom;


/**
 * 描述: 标签 公共属性
 * @author qye.zheng
 * BaseTag
 * 
 */
public class BaseTag extends BaseAttr {
	
	/* 名称属性 */
	private String tagName;
	
	/* 标签文本 */
	private String text;
	
	/** 无参构造方法 */
	public BaseTag() {
		tagName = this.getClass().getSimpleName();
	}
	
	/** 有参构造方法 */
	public BaseTag(final String id, final String name) {}

	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
}
