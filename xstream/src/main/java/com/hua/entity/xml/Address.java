/**
 * Address.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Address
 * 描述: 地址 (主要地址 + 订单地址)
 * @author  qye.zheng
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public final class Address
{
	private List<PrimaryAddress> primaryAddresses;
	
	private List<BillingAddress> billingAddresses;

}

