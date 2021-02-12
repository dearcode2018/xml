/**
  * @filename ListValueType.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.util.List;

import lombok.Data;

/**
 * @type ListValueType
 * @description 
 * @author qianye.zheng
 */
@Data
public final class ListValueType {

	/* 标签名称，单独进行设置 */
	private String tag;
	
	/* 标签后缀的起始索引 */
	private int startIndex = 1;
	
	/* 值列表 */
	private List<Object> values;
	
}
