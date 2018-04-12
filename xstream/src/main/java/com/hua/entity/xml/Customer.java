/**
 * Customer.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Customer
 * 描述: 客户 - 实体
 * @author  qye.zheng
 * 
 */
public final class Customer
{
	
	private String id;
	
	private String gender;
	
	private String firstname;
	
	private String lastname;
	
	private String phoneNumber;
	
	private Address address;
	
	@XStreamAsAttribute  
    @XStreamAlias("xmlns")  
	private String xmlns;

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

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
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname()
	{
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
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
	 * @return the xmlns
	 */
	public final String getXmlns()
	{
		return xmlns;
	}

	/**
	 * @param xmlns the xmlns to set
	 */
	public final void setXmlns(String xmlns)
	{
		this.xmlns = xmlns;
	}
	
}
