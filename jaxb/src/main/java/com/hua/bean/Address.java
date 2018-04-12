/**
  * @filename Address.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;


 /**
 * @type Address
 * @description 地址
 * @author qianye.zheng
 */
public class Address {

	/* 国家 */
	private String nation;
	
	/* 省 */
    private String province;
    
    /* 市 */
    private String city;
    
    /* 县 */
    private String county;
    
    /* 街道 */
    private String street;

	/**
	 * @return the nation
	 */
	public final String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public final void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the province
	 */
	public final String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public final void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public final void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the county
	 */
	public final String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public final void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the street
	 */
	public final String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public final void setStreet(String street) {
		this.street = street;
	}
    
}
