/**
 * PrimaryAddress.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * PrimaryAddress
 * 描述: 首要地址
 * @author  qye.zheng
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PrimaryAddress 
{
	// 邮政编码
	private String postalCode;
	
	// 地址行
	private String addressLine;
	
}