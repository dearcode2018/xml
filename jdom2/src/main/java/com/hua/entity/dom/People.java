/**
 * People.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity.dom;


/**
 * 描述: 
 * @author qye.zheng
 * People
 * 
 */
public final class People extends BaseTag {
	
	private Address address;
	
	/** 无参构造方法 */
	public People() {}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
