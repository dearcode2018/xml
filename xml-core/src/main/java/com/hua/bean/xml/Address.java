/**
 * Address.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.bean.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Address
 * 描述: 地址 (主要地址 + 订单地址)
 * @author  qye.zheng
 * 
 */
public final class Address
{
	/* 首要地址 */
	private List<PrimaryAddress> primaryAddresses = new ArrayList<PrimaryAddress>();
	
	/* 订单地址 */
	private List<BillingAddress> billingAddresses = new ArrayList<BillingAddress>();
	
	/* 更新时间 */
	private Date updateDt;
	
	/* 备注 */
	private String remark;
	
	
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

	/**
	 * @return the updateDt
	 */
	public final Date getUpdateDt() {
		return updateDt;
	}

	/**
	 * @param updateDt the updateDt to set
	 */
	public final void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	/**
	 * @return the remark
	 */
	public final String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark) {
		this.remark = remark;
	}

}

