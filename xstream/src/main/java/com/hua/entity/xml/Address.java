/**
 * Address.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

import java.util.List;

/**
 * Address
 * 描述: 地址 (主要地址 + 订单地址)
 * @author  qye.zheng
 * 
 */
public final class Address
{
	private List<PrimaryAddress> primaryAddresses;
	
	private List<BillingAddress> billingAddresses;

	/**
	 * @return the primaryAddresses
	 */
	public List<PrimaryAddress> getPrimaryAddresses()
	{
		return primaryAddresses;
	}

	/**
	 * @param primaryAddresses the primaryAddresses to set
	 */
	public void setPrimaryAddresses(List<PrimaryAddress> primaryAddresses)
	{
		this.primaryAddresses = primaryAddresses;
	}

	/**
	 * @return the billingAddresses
	 */
	public List<BillingAddress> getBillingAddresses()
	{
		return billingAddresses;
	}

	/**
	 * @param billingAddresses the billingAddresses to set
	 */
	public void setBillingAddresses(List<BillingAddress> billingAddresses)
	{
		this.billingAddresses = billingAddresses;
	}

}

