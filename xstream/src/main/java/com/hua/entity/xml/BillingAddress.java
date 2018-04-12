/**
 * BillingAddress.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

/**
 * 
 * BillingAddress
 * 描述: 订单地址
 * @author  qye.zheng
 * 
 */
public class BillingAddress 
{
	// 接收人
	private String receiver;
	
	// 邮政编码
	private String postalCode;
	
	// 地址行
	private String addressLine;

	/**
	 * @return the receiver
	 */
	public String getReceiver()
	{
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver)
	{
		this.receiver = receiver;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	/**
	 * @return the addressLine
	 */
	public String getAddressLine()
	{
		return addressLine;
	}

	/**
	 * @param addressLine the addressLine to set
	 */
	public void setAddressLine(String addressLine)
	{
		this.addressLine = addressLine;
	}
	
}