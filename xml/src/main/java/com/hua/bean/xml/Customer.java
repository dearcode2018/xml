/**
 * Customer.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.bean.xml;

import com.hua.bean.BaseBean;


/**
 * Customer
 * 描述: 客户 - 实体
 * @author  qye.zheng
 * 
 */
@SuppressWarnings({"serial"})
public final class Customer extends BaseBean
{
	
	/* 客户名称 */
	private String name;
	
	/* 性别 */
	private String gender;
	
	/* 手机号码 */
	private String phoneNumber;
	
	/* 地址 */
	private Address address;

	/* 备注 */
	private String remark;

	/**
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public Address getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address)
	{
		this.address = address;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
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
