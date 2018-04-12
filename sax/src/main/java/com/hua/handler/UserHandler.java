/**
  * @filename UserHandler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.hua.bean.Address;
import com.hua.bean.Company;
import com.hua.bean.User;
import com.hua.constant.Constant;
import com.hua.constant.sys.UserType;
import com.hua.util.DateTimeUtil;
import com.hua.util.StringUtil;

 /**
 * @type UserHandler
 * @description 
 * @author qianye.zheng
 */
public final class UserHandler extends DefaultHandler
{
	
	/**
	 * 多属性、多级标签情况下，可以采用标签路径来分段识别
	 * 在该标签结束之后，移除.和该标签，保留上一个路径 例如 a.b.c 移除c
	 * 后变成 a.b
	 * 然后，在switch中可以用a.b.c完整路径来匹配标签去设置值，这样子，
	 * 有多少个标签实质上就有多个个标签路径来一一映射
	 * 
	 */
	
	/* xml 标签路径 a.b.c */
	private String path = "";
	
	private User user;
	
	/**
	 * 
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public UserHandler()
	{
	}

	/**
	 * @description 
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	public void startDocument() throws SAXException
	{
		// 构造对象
		user = new User();
		//path = "user";
	}	
	
	/**
	 * @description 
	 * @param uri
	 * @param localName
	 * @param qName
	 * @param attributes
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (StringUtil.isEmpty(path))
		{ // 根标签
			path = localName;
		} else
		{
			path += Constant.DOT_MARK + localName;
		}
		//System.out.println(path);
		switch (path) {
		case "user": {
			user.setId(attributes.getValue("id"));
			user.setValid(Boolean.valueOf(attributes.getValue("valid")));

			break;
		}
		case "user.type": { // UserType
			user.setType(UserType.get(attributes.getValue("code")));

			break;
		}
		case "user.addresses":
		{
			System.out.println("UserHandler.set().user.addresses");
			final List<Address> addresses = new ArrayList<Address>();
			user.setAddresses(addresses);
			
			break;
		}
		case "user.addresses.address":
		{
			final Address address = new Address();
			user.getAddresses().add(address);
			
			break;
		}
		case "user.company":
		{
			final Company company = new Company();
			company.setId(attributes.getValue("id"));
			user.setCompany(company);
			
			break;
		}		
		default: {
			//System.out.println("path no found: " + path);
			
			break;
		}
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param ch
	 * @param start
	 * @param length
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		final String value = new String(ch, start, length);
		System.out.println(path);
		if (null != path)
		{
			// 调用子类的set方法
			set(path, value);
		}
	}	
	
	/**
	 * @description 
	 * @param uri
	 * @param localName
	 * @param qName
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		super.endElement(uri, localName, qName);
		/**
		 * 多属性、多级标签情况下，可以采用标签路径来分段识别
		 * 在该标签结束之后，移除.和该标签，保留上一个路径 例如 a.b.c 移除c
		 * 后变成 a.b
		 * 然后，在switch中可以用a.b.c完整路径来匹配标签去设置值，这样子，
		 * 有多少个标签实质上就有多个个标签路径来一一映射
		 * 
		 */
		// 可能为空 或 直接是跟标签
		if (StringUtil.isNotEmpty(path) && path.contains(Constant.DOT_MARK))
		{
			path = path.substring(0, path.lastIndexOf(Constant.DOT_MARK));
		}
	}	
	
	/**
	 * 注意，多级标签下，有自标签的应该放在startElement中初始化，
	 * 而含有文本结点的才放在此处去设置值
	 */
	/**
	 * @description 设置Bean的值
	 * @param path
	 * @param value
	 * @author qianye.zheng
	 */
	public final void set(final String path, final String value)
	{
		if (null != path)
		{
			switch (path)
			{
				case "user.username":
				{
					user.setUsername(value);
					
					break;
				}
				case "user.nickname":
				{
					user.setNickname(value);
					
					break;
				}
				case "user.age":
				{
					user.setAge(Integer.parseInt(value));
					
					break;
				}
				case "user.password":
				{
					user.setPassword(value);
					
					break;
				}
				case "user.type":
				{ // UserType
					user.setType(UserType.get(value));
					
					break;
				}
				case "user.lastLoginTime":
				{ // 日期时间字段 如何转换，在此体现
					user.setLastLoginTime(DateTimeUtil.parseDateTime(value));
					
					break;
				}
				case "user.lastLoginIp":
				{
					user.setLastLoginIp(value);
					
					break;
				}
				case "user.addresses.address.nation":
				{
					// 取最后一个对象来设置值
					final Address address = user.getAddresses().get(user.getAddresses().size() - 1);
					address.setNation(value);
					
					break;
				}
				case "user.addresses.address.province":
				{
					// 取最后一个对象来设置值
					final Address address = user.getAddresses().get(user.getAddresses().size() - 1);
					address.setProvince(value);
					
					break;
				}
				case "user.addresses.address.city":
				{
					// 取最后一个对象来设置值
					final Address address = user.getAddresses().get(user.getAddresses().size() - 1);
					address.setCity(value);
					
					break;
				}
				case "user.addresses.address.county":
				{
					// 取最后一个对象来设置值
					final Address address = user.getAddresses().get(user.getAddresses().size() - 1);
					address.setCounty(value);
					
					break;
				}
				case "user.addresses.address.street":
				{
					// 取最后一个对象来设置值
					final Address address = user.getAddresses().get(user.getAddresses().size() - 1);
					address.setStreet(value);
					
					break;
				}
				case "user.company.name":
				{
					final Company company = user.getCompany();
					company.setName(value);
					
					break;
				}
				case "user.company.location":
				{
					final Company company = user.getCompany();
					company.setLocation(value);
					
					break;
				}
				case "user.company.position":
				{
					final Company company = user.getCompany();
					company.setPosition(value);
					
					break;
				}
				case "user.company.salary":
				{
					final Company company = user.getCompany();
					company.setSalary(Double.parseDouble(value));
					
					break;
				}
				case "user.company.remark":
				{
					final Company company = user.getCompany();
					company.setRemark(value);
					
					break;
				}
				default:
				{
					System.out.println("path no found: " + path);
					
					break;
				}
			}
		}
	}

	/**
	 * 
	 * @description 
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
    public void endDocument()
            throws SAXException
    {
    }

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}		

	
	/**
	 * @description 
	 * @param ch
	 * @param start
	 * @param length
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException
	{
		super.ignorableWhitespace(ch, start, length);
	}

	/**
	 * @description 
	 * @param target
	 * @param data
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void processingInstruction(String target, String data)
			throws SAXException
	{
		super.processingInstruction(target, data);
	}

	/**
	 * @description 
	 * @param name
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void skippedEntity(String name) throws SAXException
	{
		super.skippedEntity(name);
	}

	/**
	 * @description 
	 * @param e
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void warning(SAXParseException e) throws SAXException
	{
		super.warning(e);
	}

	/**
	 * @description 
	 * @param e
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void error(SAXParseException e) throws SAXException
	{
		super.error(e);
	}

	/**
	 * @description 
	 * @param e
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXException
	{
		super.fatalError(e);
	}
	
}
