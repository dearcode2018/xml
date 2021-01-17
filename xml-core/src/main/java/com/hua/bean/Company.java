/**
  * @filename Company.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

 /**
 * @type Company
 * @description  公司信息
 * @author qianye.zheng
 */
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* 唯一标识符 [必填] */
	private String id;
	
	/* 公司名称 [必填] */
	private String name;

	/* 公司地址 */
	private String location;
	
	/* 在该公司担任的职位 [必填] */
	private String position;
	
	/* 月薪 [2000, 50000] */
	private double salary;
	
	/* 备注 */
	private String remark;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the salary
	 */
	public final double getSalary()
	{
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public final void setSalary(double salary)
	{
		this.salary = salary;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public String toString() {
		
		return new ReflectionToStringBuilder(this).toString();
	}
}
