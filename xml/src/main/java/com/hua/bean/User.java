/**
 * 描述: 
 * User.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.hua.constant.sys.UserType;

/**
 * 
 * @type User
 * @description  用户
 * @author qianye.zheng
 */
public class User implements Serializable {

	/* long */
	private static final long serialVersionUID = 1L;
	
	/* 默认 命名空间 */
	public static final String DEFAULT_NAMESPACE = "http://www.hua.com/user";
	
	/* 唯一标识符 [必填] */
	private String id;
	
	/* 登录-用户名 (唯一) [必填] */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 年龄 [1, 150] */
	private int age;
	
	/* 登录-密码  [必填] */
	private String password;
	
	
	/**
	 * DTD 文档中的默认值，在Java Bean中可以不用设置
	 * 在根据DTD对xml文档进行校验时，会直接读取DTD
	 * 中的默认值，只要xml文档中没有明确声明，则无论
	 * Java Bean 定义中是否声明了默认值，以DTD规格为准.
	 */
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean valid = true;
	
	/**
	 * 若 xml框架不支持枚举类型，可以考虑转换为字符串类型
	 */
	/**
	 * DTD 文档中的默认值，在Java Bean中可以不用设置
	 * 在根据DTD对xml文档进行校验时，会直接读取DTD
	 * 中的默认值，只要xml文档中没有明确声明，则无论
	 * Java Bean 定义中是否声明了默认值，以DTD规格为准.
	 */
	/* 用户类型，默认是游客 */
	private UserType type = UserType.VISITOR;
	
	/* 上一次登录-时间 */
	private Date lastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	/* 地址数组 作为xml中数组/对象方式  [必填] 至少一个 */
	private List<Address> addresses;
	
	/* 所属公司 [必填] */
	private Company company;
	
	/** 无参构造方法 */
	public User() {
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname()
	{
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid()
	{
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}

	/**
	 * @return the age
	 */
	public final int getAge()
	{
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public final void setAge(int age)
	{
		this.age = age;
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
