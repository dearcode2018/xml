/**
 * Customer.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Customer
 * 描述: 客户 - 实体
 * @author  qye.zheng
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
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
	
}
