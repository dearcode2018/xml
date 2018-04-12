/**
  * @filename UserHandler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.hua.bean.Address;
import com.hua.bean.Company;
import com.hua.bean.User;
import com.hua.constant.Constant;
import com.hua.constant.sys.UserType;
import com.hua.util.DateTimeUtil;
import com.hua.util.IOUtil;
import com.hua.util.StringUtil;

 /**
 * @type UserHandler
 * @description 
 * @author qianye.zheng
 */
public final class UserHandler
{


	/**
	 * 
	 * @description 
	 * @param filePath
	 * @return
	 * @author qianye.zheng
	 */
	public static final User readValue(final String filePath)
	{
		/* xml 标签路径 a.b.c */
		String path = "";
		User user = null;
		try {
			final Reader reader = new FileReader(filePath);
			final XMLInputFactory factory = XMLInputFactory.newFactory();
			final XMLEventReader eventReader = factory
					.createXMLEventReader(reader);
			XMLEvent event = null;
			int eventType = -1;
			String value = null;
			StartElement startElement = null;
			String field = null;
			QName qName = null;
			// 循环遍历
			while (eventReader.hasNext()) {
				event = eventReader.nextEvent();
				eventType = event.getEventType();
				switch (eventType) {
				// 开始文档
				case XMLStreamConstants.START_DOCUMENT: {
					// 构造对象
					user = new User();

					break;
				}
				// 开始元素
				case XMLStreamConstants.START_ELEMENT: {
					startElement = event.asStartElement();
					field = startElement.getName().getLocalPart();
					if (StringUtil.isEmpty(path)) { // 根标签
						path = field;
					} else {
						path += Constant.DOT_MARK + field;
					}
					switch (path) {
					case "user": {
						qName = new QName("id");
						user.setId(startElement.getAttributeByName(qName)
								.getValue());
						qName = new QName("valid");
						user.setValid(Boolean.valueOf(startElement
								.getAttributeByName(qName).getValue()));

						break;
					}
					case "user.type": { // UserType
						qName = new QName("code");
						user.setType(UserType.get(startElement
								.getAttributeByName(qName).getValue()));

						break;
					}
					case "user.addresses": {
						final List<Address> addresses = new ArrayList<Address>();
						user.setAddresses(addresses);

						break;
					}
					case "user.addresses.address": {
						final Address address = new Address();
						user.getAddresses().add(address);

						break;
					}
					case "user.company": {
						final Company company = new Company();
						qName = new QName("id");
						company.setId(startElement.getAttributeByName(qName)
								.getValue());
						user.setCompany(company);

						break;
					}
					default: {
					
						break;
					}
					}

					break;
				}
				// CDATA / 文本、空串
				case XMLStreamConstants.CHARACTERS: {
					final Characters characters = event.asCharacters();
					value = characters.getData();
					switch (path) {
					case "user.username": {
						user.setUsername(value);

						break;
					}
					case "user.nickname": {
						user.setNickname(value);

						break;
					}
					case "user.age": {
						user.setAge(Integer.parseInt(value));

						break;
					}
					case "user.password": {
						user.setPassword(value);

						break;
					}
					case "user.type": { // UserType
						user.setType(UserType.get(value));

						break;
					}
					case "user.lastLoginTime": { // 日期时间字段 如何转换，在此体现
						user.setLastLoginTime(DateTimeUtil.parseDateTime(value));

						break;
					}
					case "user.lastLoginIp": {
						user.setLastLoginIp(value);

						break;
					}
					case "user.addresses.address.nation": {
						// 取最后一个对象来设置值
						final Address address = user.getAddresses().get(
								user.getAddresses().size() - 1);
						address.setNation(value);

						break;
					}
					case "user.addresses.address.province": {
						// 取最后一个对象来设置值
						final Address address = user.getAddresses().get(
								user.getAddresses().size() - 1);
						address.setProvince(value);

						break;
					}
					case "user.addresses.address.city": {
						// 取最后一个对象来设置值
						final Address address = user.getAddresses().get(
								user.getAddresses().size() - 1);
						address.setCity(value);

						break;
					}
					case "user.addresses.address.county": {
						// 取最后一个对象来设置值
						final Address address = user.getAddresses().get(
								user.getAddresses().size() - 1);
						address.setCounty(value);

						break;
					}
					case "user.addresses.address.street": {
						// 取最后一个对象来设置值
						final Address address = user.getAddresses().get(
								user.getAddresses().size() - 1);
						address.setStreet(value);

						break;
					}
					case "user.company.name": {
						final Company company = user.getCompany();
						company.setName(value);

						break;
					}
					case "user.company.location": {
						final Company company = user.getCompany();
						company.setLocation(value);

						break;
					}
					case "user.company.position": {
						final Company company = user.getCompany();
						company.setPosition(value);

						break;
					}
					case "user.company.salary": {
						final Company company = user.getCompany();
						company.setSalary(Double.parseDouble(value));

						break;
					}
					case "user.company.remark": {
						final Company company = user.getCompany();
						company.setRemark(value);

						break;
					}
					default: {
						//System.out.println("path no found: " + path);

						break;
					}
					}

					break;
				}
				case XMLStreamConstants.END_ELEMENT: {
					/**
					 * 多属性、多级标签情况下，可以采用标签路径来分段识别 在该标签结束之后，移除.和该标签，保留上一个路径 例如
					 * a.b.c 移除c 后变成 a.b 然后，在switch中可以用a.b.c完整路径来匹配标签去设置值，这样子，
					 * 有多少个标签实质上就有多个个标签路径来一一映射
					 * 
					 */
					// 可能为空 或 直接是跟标签
					if (StringUtil.isNotEmpty(path)
							&& path.contains(Constant.DOT_MARK)) {
						path = path.substring(0,
								path.lastIndexOf(Constant.DOT_MARK));
					}

					break;
				}
				default: {
					break;
				}
				}
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (XMLStreamException e)
		{
			e.printStackTrace();
		}
		
		return user;
	}
	
	/**
	 * 
	 * @description 
	 * @param user
	 * @param file
	 * @author qianye.zheng
	 */
	public static final void writeValue(final User user, final File file)
	{
		try
		{
			final Writer writer = new FileWriter(file);
			final XMLOutputFactory factory = XMLOutputFactory.newFactory();
			final XMLStreamWriter streamWriter = factory.createXMLStreamWriter(writer);
			// 设置默认 命名空间
			streamWriter.setDefaultNamespace(User.DEFAULT_NAMESPACE);
			
			streamWriter.writeStartDocument();
			
			streamWriter.writeStartElement("user");
			streamWriter.writeAttribute("id", user.getId());
			streamWriter.writeAttribute("valid", String.valueOf(user.isValid()));
			
			streamWriter.writeStartElement("username");
			streamWriter.writeCharacters(user.getUsername());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("nickname");
			streamWriter.writeCharacters(user.getNickname());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("age");
			streamWriter.writeCharacters(String.valueOf(user.getAge()));
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("password");
			streamWriter.writeCharacters(user.getPassword());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("type");
			streamWriter.writeAttribute("code", user.getType().getCode());
			streamWriter.writeEndElement();			
			
			streamWriter.writeStartElement("lastLoginTime");
			streamWriter.writeCharacters(DateTimeUtil.format(user.getLastLoginTime()));
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("lastLoginIp");
			streamWriter.writeCharacters(user.getLastLoginIp());
			streamWriter.writeEndElement();
			
			/** ===== begin 地址数组  ===== */
			streamWriter.writeStartElement("addresses");
			for (Address address : user.getAddresses())
			{
				// 地址对象1
				streamWriter.writeStartElement("address");
				streamWriter.writeStartElement("nation");
				streamWriter.writeCharacters(address.getNation());
				streamWriter.writeEndElement();
				streamWriter.writeStartElement("province");
				streamWriter.writeCharacters(address.getProvince());
				streamWriter.writeEndElement();
				streamWriter.writeStartElement("city");
				streamWriter.writeCharacters(address.getCity());
				streamWriter.writeEndElement();
				streamWriter.writeStartElement("county");
				streamWriter.writeCharacters(address.getCounty());
				streamWriter.writeEndElement();
				streamWriter.writeStartElement("street");
				streamWriter.writeCharacters(address.getStreet());
				streamWriter.writeEndElement();
				streamWriter.writeEndElement();
			}
			streamWriter.writeEndElement();
			/** ===== end of 地址数组 ===== */
		
			/** ===== begin 所属公司 ===== */
			final Company company = user.getCompany();
			
			streamWriter.writeStartElement("company");
			streamWriter.writeAttribute("id", company.getId());
			
			streamWriter.writeStartElement("name");
			streamWriter.writeCharacters(company.getName());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("location");
			streamWriter.writeCharacters(company.getLocation());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("position");
			streamWriter.writeCharacters(company.getPosition());
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("salary");
			streamWriter.writeCharacters(String.valueOf(company.getSalary()));
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("remark");
			streamWriter.writeCharacters(company.getRemark());
			streamWriter.writeEndElement();
			
			streamWriter.writeEndElement();
			/** ===== end of 所属公司 ===== */
			
			streamWriter.writeEndElement();
			
			streamWriter.writeEndDocument();
			
			streamWriter.flush();
			// 关闭资源
			streamWriter.close();
			IOUtil.close(writer);
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{

		}
	}
}
