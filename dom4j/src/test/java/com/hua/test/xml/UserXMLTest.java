/**
 * 描述: 
 * UserXMLTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.xml;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.Address;
import com.hua.bean.Company;
import com.hua.bean.User;
import com.hua.constant.Constant;
import com.hua.constant.sys.UserType;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;
import com.hua.util.IOUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * UserXMLTest
 */
public final class UserXMLTest extends BaseTest {


	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadValue() {
		try {
			// 建立构造器  
			final SAXReader saxReader = new SAXReader();
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			// 读入指定文件  
			final Document document = saxReader.read(new File(path));
			Element rootElement = document.getRootElement();
			// 将根节点下的所有子节点放入List中  
			@SuppressWarnings({"unchecked"})
			final List<Element> elements = rootElement.elements();
			Element element = null;
			
			User user = new User();
			
			element = elements.get(0);
			user.setId(element.getTextTrim());
			
			element = elements.get(1);
			user.setUsername(element.getTextTrim());
			
			element = elements.get(2);
			user.setNickname(element.getTextTrim());
			
			element = elements.get(3);
			user.setPassword(element.getTextTrim());
			
			element = elements.get(4);
			user.setValid(Boolean.valueOf((element.getTextTrim())));
			
			element = elements.get(5);
			user.setLastLoginTime(DateTimeUtil.parseDateTime(element.getTextTrim()));
			
			element = elements.get(6);
			user.setLastLoginIp(element.getTextTrim());
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testReadValue =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@SuppressWarnings({"unchecked"})
	@Test
	public void testReadValueWithDTD() {
		try {
			/**
			 * 是否进行验证 DTD / XSD
			 */
			 boolean validating = true;
			// 建立构造器  
			final SAXReader saxReader = new SAXReader(validating);
			String path = ProjectUtil.getAbsolutePath("/doc/User-DTD.xml", true);
			// 读入指定文件  
			final Document document = saxReader.read(new File(path));
			Element rootElement = document.getRootElement();
			// 将根节点下的所有子节点放入List中  
			final List<Element> elements = rootElement.elements();
			Element element = null;
			Attribute attribute = null;
			int i = 0;
			User user = new User();
			// 获取属性 - id
			attribute = rootElement.attribute("id");
			user.setId(attribute.getValue());

			// 获取属性 - valid
			attribute = rootElement.attribute("valid");
			user.setValid(Boolean.valueOf(attribute.getValue()));			
			
			element = elements.get(i++);
			user.setUsername(element.getTextTrim());
			
			element = elements.get(i++);
			user.setNickname(element.getTextTrim());
			
			element = elements.get(i++);
			user.setAge(Integer.parseInt(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setPassword(element.getTextTrim());
			
			element = elements.get(i++);
			attribute = element.attribute("code");
			user.setType(UserType.get(attribute.getValue()));
			
			element = elements.get(i++);
			user.setLastLoginTime(DateTimeUtil.parseDateTime(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setLastLoginIp(element.getTextTrim());
			
			List<Element> eList = null;
			// 地址列表
			element = elements.get(i++);
			List<Element> eAddresses = element.elements();
			List<Address> addresses = new ArrayList<Address>();
			Address address = null;
			int j = 0;
			for (Element eAddress : eAddresses)
			{
				 j = 0;
				address = new Address();
				eList = eAddress.elements();
				address.setNation(eList.get(j++).getTextTrim());
				address.setProvince(eList.get(j++).getTextTrim());
				address.setCity(eList.get(j++).getTextTrim());
				address.setCounty(eList.get(j++).getTextTrim());
				address.setStreet(eList.get(j++).getTextTrim());
				
				addresses.add(address);
			}
			user.setAddresses(addresses);
			
			// 所属公司
			element = elements.get(i++);
			eList = element.elements();
			Company company = new Company();
			// 获取 id 属性
			attribute = element.attribute("id");
			company.setId(attribute.getValue());
			int k = 0;
			company.setName(eList.get(k++).getTextTrim());
			company.setLocation(eList.get(k++).getTextTrim());
			company.setPosition(eList.get(k++).getTextTrim());
			company.setSalary(Double.parseDouble(eList.get(k++).getTextTrim()));
			company.setRemark(eList.get(k++).getTextTrim());
			
			user.setCompany(company);
			
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testReadValueWithDTD =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@SuppressWarnings({"unchecked"})
	@Test
	public void testReadValueWithXSD() {
		try {
			/**
			 * 是否进行验证 DTD / XSD
			 */
			 boolean validating = true;
			// 建立构造器  
			final SAXReader saxReader = new SAXReader(validating);
			String path = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			// 读入指定文件  
			final Document document = saxReader.read(new File(path));
			Element rootElement = document.getRootElement();
			// 将根节点下的所有子节点放入List中  
			final List<Element> elements = rootElement.elements();
			Element element = null;
			Attribute attribute = null;
			int i = 0;
			User user = new User();
			// 获取属性 - id
			attribute = rootElement.attribute("id");
			user.setId(attribute.getValue());

			// 获取属性 - valid
			attribute = rootElement.attribute("valid");
			user.setValid(Boolean.valueOf(attribute.getValue()));			
			
			element = elements.get(i++);
			user.setUsername(element.getTextTrim());
			
			element = elements.get(i++);
			user.setNickname(element.getTextTrim());
			
			element = elements.get(i++);
			user.setAge(Integer.parseInt(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setPassword(element.getTextTrim());
			
			element = elements.get(i++);
			attribute = element.attribute("code");
			user.setType(UserType.get(attribute.getValue()));
			
			element = elements.get(i++);
			user.setLastLoginTime(DateTimeUtil.parseDateTime(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setLastLoginIp(element.getTextTrim());
			
			List<Element> eList = null;
			// 地址列表
			element = elements.get(i++);
			List<Element> eAddresses = element.elements();
			List<Address> addresses = new ArrayList<Address>();
			Address address = null;
			int j = 0;
			for (Element eAddress : eAddresses)
			{
				 j = 0;
				address = new Address();
				eList = eAddress.elements();
				address.setNation(eList.get(j++).getTextTrim());
				address.setProvince(eList.get(j++).getTextTrim());
				address.setCity(eList.get(j++).getTextTrim());
				address.setCounty(eList.get(j++).getTextTrim());
				address.setStreet(eList.get(j++).getTextTrim());
				
				addresses.add(address);
			}
			user.setAddresses(addresses);
			
			// 所属公司
			element = elements.get(i++);
			eList = element.elements();
			Company company = new Company();
			// 获取 id 属性
			attribute = element.attribute("id");
			company.setId(attribute.getValue());
			int k = 0;
			company.setName(eList.get(k++).getTextTrim());
			company.setLocation(eList.get(k++).getTextTrim());
			company.setPosition(eList.get(k++).getTextTrim());
			company.setSalary(Double.parseDouble(eList.get(k++).getTextTrim()));
			company.setRemark(eList.get(k++).getTextTrim());
			
			user.setCompany(company);
			
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testReadValueWithXSD =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@SuppressWarnings({"unchecked"})
	@Test
	public void testReadValueWithXSD2() {
		try {
			/**
			 * 是否进行验证 DTD / XSD
			 */
			 boolean validating = true;
			// 建立构造器  
			final SAXReader saxReader = new SAXReader(validating);
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(validating);
			// 设置命名空间支持
			factory.setNamespaceAware(true);
			
			SAXParser parser = factory.newSAXParser();
			
			
			String path = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			// 读入指定文件  
			final Document document = saxReader.read(new File(path));
			Element rootElement = document.getRootElement();
			// 将根节点下的所有子节点放入List中  
			final List<Element> elements = rootElement.elements();
			Element element = null;
			Attribute attribute = null;
			int i = 0;
			User user = new User();
			// 获取属性 - id
			attribute = rootElement.attribute("id");
			user.setId(attribute.getValue());

			// 获取属性 - valid
			attribute = rootElement.attribute("valid");
			user.setValid(Boolean.valueOf(attribute.getValue()));			
			
			element = elements.get(i++);
			user.setUsername(element.getTextTrim());
			
			element = elements.get(i++);
			user.setNickname(element.getTextTrim());
			
			element = elements.get(i++);
			user.setAge(Integer.parseInt(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setPassword(element.getTextTrim());
			
			element = elements.get(i++);
			attribute = element.attribute("code");
			user.setType(UserType.get(attribute.getValue()));
			
			element = elements.get(i++);
			user.setLastLoginTime(DateTimeUtil.parseDateTime(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setLastLoginIp(element.getTextTrim());
			
			List<Element> eList = null;
			// 地址列表
			element = elements.get(i++);
			List<Element> eAddresses = element.elements();
			List<Address> addresses = new ArrayList<Address>();
			Address address = null;
			int j = 0;
			for (Element eAddress : eAddresses)
			{
				 j = 0;
				address = new Address();
				eList = eAddress.elements();
				address.setNation(eList.get(j++).getTextTrim());
				address.setProvince(eList.get(j++).getTextTrim());
				address.setCity(eList.get(j++).getTextTrim());
				address.setCounty(eList.get(j++).getTextTrim());
				address.setStreet(eList.get(j++).getTextTrim());
				
				addresses.add(address);
			}
			user.setAddresses(addresses);
			
			// 所属公司
			element = elements.get(i++);
			eList = element.elements();
			Company company = new Company();
			// 获取 id 属性
			attribute = element.attribute("id");
			company.setId(attribute.getValue());
			int k = 0;
			company.setName(eList.get(k++).getTextTrim());
			company.setLocation(eList.get(k++).getTextTrim());
			company.setPosition(eList.get(k++).getTextTrim());
			company.setSalary(Double.parseDouble(eList.get(k++).getTextTrim()));
			company.setRemark(eList.get(k++).getTextTrim());
			
			user.setCompany(company);
			
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testReadValueWithXSD2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWriteValue() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/UserWrite.xml", true);
			File file = new File(path);
			User user = new User();
			user.setId("20150628");
			user.setValid(false);
			user.setUsername("张三");
			user.setNickname("少年张三丰");
			user.setAge(23);
			user.setPassword("123456");
			user.setType(UserType.get("101"));
			user.setLastLoginTime(DateTimeUtil.getTimestamp());
			user.setLastLoginIp("192.168.5.66");
			
			List<Address> addresses = new ArrayList<Address>();
			Address address = null;
			
			address = new Address();
			address.setNation("中国");
			address.setProvince("广东");
			address.setCity("广州");
			address.setCounty("天河");
			address.setStreet("体育西路123号");
			addresses.add(address);
			
			address = new Address();
			address.setNation("中国");
			address.setProvince("上海");
			address.setCity("浦东新区");
			address.setCounty("惠南镇");
			address.setStreet("沪南公路256号");
			addresses.add(address);
			
			user.setAddresses(addresses);
			
			Company company = new Company();
			company.setId("200512345");
			company.setName("广东农业科技有限公司");
			company.setLocation("广州市越秀区解放路123号");
			company.setPosition("科技研究员");
			company.setSalary(3500.68);
			company.setRemark("主导农业科技研发");
			
			user.setCompany(company);
			
			final Document document = DocumentHelper.createDocument(); 
			final Element rootElement = DocumentHelper.createElement("user");
			// 设置 user 标签 属性
			rootElement.addAttribute("id", user.getId());
			rootElement.addAttribute("valid", String.valueOf(user.isValid()));
			
			document.setRootElement(rootElement);
			
			Element element = null;
			
			element = DocumentHelper.createElement("username");
			element.setText(user.getUsername());
			rootElement.add(element);
			
			element = DocumentHelper.createElement("nickname");
			element.setText(user.getNickname());
			rootElement.add(element);
			
			element = DocumentHelper.createElement("age");
			element.setText(String.valueOf(user.getAge()));
			rootElement.add(element);
			
			element = DocumentHelper.createElement("password");
			element.setText(user.getPassword());
			rootElement.add(element);
			
			element = DocumentHelper.createElement("lastLoginTime");
			element.setText(DateTimeUtil.format(user.getLastLoginTime()));
			rootElement.add(element);
			
			element = DocumentHelper.createElement("lastLoginIp");
			element.setText(user.getLastLoginIp());
			rootElement.add(element);
			
			Element e = null;
			/** ===== begin 地址数组 ===== */
			Element eAddress = null;
			element = DocumentHelper.createElement("addresses");
			for (Address addr : user.getAddresses())
			{
				// 单个地址对象
				eAddress = DocumentHelper.createElement("address");
				e = DocumentHelper.createElement("nation");
				e.setText(addr.getNation());
				eAddress.add(e);
				
				e = DocumentHelper.createElement("province");
				e.setText(addr.getProvince());
				eAddress.add(e);
				
				e = DocumentHelper.createElement("city");
				e.setText(addr.getCity());
				eAddress.add(e);
				
				e = DocumentHelper.createElement("county");
				e.setText(addr.getCounty());
				eAddress.add(e);
				
				e = DocumentHelper.createElement("street");
				e.setText(addr.getStreet());
				eAddress.add(e);
				
				// 放入地址数组
				element.add(eAddress);
			}
			rootElement.add(element);
			/** ===== end of 地址数组 ===== */

			/** ===== begin 所属公司 ===== */			
			element = DocumentHelper.createElement("company");
			company = user.getCompany();
			element.addAttribute("id", company.getId());
			
			e = DocumentHelper.createElement("name");
			e.setText(company.getName());
			element.add(e);
			
			e = DocumentHelper.createElement("location");
			e.setText(company.getLocation());
			element.add(e);
			
			e = DocumentHelper.createElement("position");
			e.setText(company.getPosition());
			element.add(e);
			
			e = DocumentHelper.createElement("salary");
			e.setText(String.valueOf(company.getSalary()));
			element.add(e);
			
			e = DocumentHelper.createElement("remark");
			e.setText(company.getRemark());
			element.add(e);
			
			rootElement.add(element);
			/** ===== end of 所属公司 ===== */
			
			OutputStream 	outputStream = new FileOutputStream(file);
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			// 设置编码
			outputFormat.setEncoding(Constant.CHART_SET_UTF_8);
			XMLWriter writer = new XMLWriter(outputStream, outputFormat);
			writer.write(document);
		
			writer.close();
			IOUtil.close(outputStream);
		} catch (Exception e) {
			log.error("testWriteValue =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
