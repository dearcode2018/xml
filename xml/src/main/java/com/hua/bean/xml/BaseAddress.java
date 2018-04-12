/**
  * @filename BaseAddress.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.bean.xml;

 /**
 * @type BaseAddress
 * @description  
 * @author qye.zheng
 */
public abstract class BaseAddress {

	// 邮政编码
	private String postalCode;
	
	// 地址行
	private String addressLine;

	/**
	 * @return the postalCode
	 */
	public final String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public final void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the addressLine
	 */
	public final String getAddressLine() {
		return addressLine;
	}

	/**
	 * @param addressLine the addressLine to set
	 */
	public final void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	
}
