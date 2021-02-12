/**
  * @filename ConvertConstant.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.constant;

 /**
 * @type ConvertConstant
 * @description 
 * @author qianye.zheng
 */
public final class ConvertConstant {

	/* 内部替换标签 */
	public static final String REPLACE_TAG = "_replace-tag_";
	
	public static final String LESS_THAN_SIGN = "<";
	
	public static final String GREATER_THAN_SIGN = ">";
	
	// 斜杠
	public static final String SLASH = "/";
	
	public static final String RPLACE_REGEX = LESS_THAN_SIGN + "/?" + REPLACE_TAG + GREATER_THAN_SIGN;
}
