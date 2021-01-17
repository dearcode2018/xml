/**
 * BillingAddress.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * BillingAddress
 * 描述: 订单地址
 * @author  qye.zheng
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BillingAddress 
{
	// 接收人
	private String receiver;
	
	// 邮政编码
	private String postalCode;
	
	// 地址行
	private String addressLine;
	
}