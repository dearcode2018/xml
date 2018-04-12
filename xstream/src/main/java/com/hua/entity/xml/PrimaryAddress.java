/**
 * PrimaryAddress.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

/**
 * 
 * PrimaryAddress
 * 描述: 首要地址
 * @author  qye.zheng
 * 
 */
public class PrimaryAddress 
{
	
	// 邮政编码
	private String postalCode;
	
	// 地址行
	private String addressLine;

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