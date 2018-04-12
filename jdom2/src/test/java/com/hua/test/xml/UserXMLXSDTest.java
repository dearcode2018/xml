/**
 * 描述: 
 * UserXMLXSDTest.java
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
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
 * UserXMLXSDTest
 */
public final class UserXMLXSDTest extends BaseTest {


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
			final SAXBuilder saxBuilder = new SAXBuilder();
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			// 读入指定文件  
			final Document document = saxBuilder.build(new FileInputStream(path));
			Element rootElement = document.getRootElement();
			// 将根节点下的所有子节点放入List中  
			final List<Element> elements = rootElement.getChildren();
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
	@Test
	public void testReadValueWithXSD() {
		try {
			// 建立构造器  
			final SAXBuilder saxBuilder = new SAXBuilder();
			/*
			 * 设置验证类型 XSD 验证，必须设置了验证类型之后，才进行验证
			 * 否则 可能只是进行简单的默认值填充而已
			 */
			saxBuilder.setXMLReaderFactory(XMLReaders.XSDVALIDATING);
			String path = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			// 读入指定文件  
			final Document document = saxBuilder.build(new FileInputStream(path));
			User user = new User();
			
			Element rootElement = document.getRootElement();
			List<Element> eList = null;
			Attribute attribute = null;
			// 获取 id 属性
			attribute = rootElement.getAttribute("id");
			user.setId(attribute.getValue());
			
			// 获取 valid 属性
			attribute = rootElement.getAttribute("valid");
			user.setValid(attribute.getBooleanValue());
			
			// 将根节点下的所有子节点放入List中  
			final List<Element> elements = rootElement.getChildren();
			Element element = null;
			int i = 0;
			element = elements.get(i++);
			user.setUsername(element.getTextTrim());
			
			element = elements.get(i++);
			user.setNickname(element.getTextTrim());
			
			element = elements.get(i++);
			user.setAge(Integer.parseInt(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setPassword(element.getTextTrim());
			
			element = elements.get(i++);
			attribute = element.getAttribute("code");
			user.setType(UserType.get(attribute.getValue()));
			
			element = elements.get(i++);
			user.setLastLoginTime(DateTimeUtil.parseDateTime(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setLastLoginIp(element.getTextTrim());
			
			// 地址列表
			element = elements.get(i++);
			List<Element> eAddresses = element.getChildren();
			List<Address> addresses = new ArrayList<Address>();
			Address address = null;
			int j = 0;
			for (Element eAddress : eAddresses)
			{
				 j = 0;
				address = new Address();
				eList = eAddress.getChildren();
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
			eList = element.getChildren();
			Company company = new Company();
			// 获取 id 属性
			attribute = element.getAttribute("id");
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
	@Test
	public void testReadWithIllegalValue() {
		try {
			// 建立构造器  
			final SAXBuilder saxBuilder = new SAXBuilder();
			/*
			 * 设置验证类型 XSD 验证，必须设置了验证类型之后，才进行验证
			 * 否则 可能只是进行简单的默认值填充而已
			 */
			saxBuilder.setXMLReaderFactory(XMLReaders.XSDVALIDATING);
			String path = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			// 读入指定文件  
			final Document document = saxBuilder.build(new FileInputStream(path));
			User user = new User();
			
			Element rootElement = document.getRootElement();
			List<Element> eList = null;
			Attribute attribute = null;
			// 获取 id 属性
			attribute = rootElement.getAttribute("id");
			user.setId(attribute.getValue());
			
			// 获取 valid 属性
			attribute = rootElement.getAttribute("valid");
			user.setValid(attribute.getBooleanValue());
			
			// 将根节点下的所有子节点放入List中  
			final List<Element> elements = rootElement.getChildren();
			Element element = null;
			int i = 0;
			element = elements.get(i++);
			user.setUsername(element.getTextTrim());
			
			element = elements.get(i++);
			user.setNickname(element.getTextTrim());
			
			element = elements.get(i++);
			user.setAge(Integer.parseInt(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setPassword(element.getTextTrim());
			
			element = elements.get(i++);
			attribute = element.getAttribute("code");
			user.setType(UserType.get(attribute.getValue()));
			
			element = elements.get(i++);
			user.setLastLoginTime(DateTimeUtil.parseDateTime(element.getTextTrim()));
			
			element = elements.get(i++);
			user.setLastLoginIp(element.getTextTrim());
			
			// 地址列表
			element = elements.get(i++);
			List<Element> eAddresses = element.getChildren();
			List<Address> addresses = new ArrayList<Address>();
			Address address = null;
			int j = 0;
			for (Element eAddress : eAddresses)
			{
				 j = 0;
				address = new Address();
				eList = eAddress.getChildren();
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
			eList = element.getChildren();
			Company company = new Company();
			// 获取 id 属性
			attribute = element.getAttribute("id");
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
			log.error("testReadWithIllegalValue =====> ", e);
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
			user.setUsername("张三");
			user.setNickname("少年张三丰");
			user.setPassword("123456");
			user.setValid(false);
			user.setLastLoginTime(DateTimeUtil.getTimestamp());
			user.setLastLoginIp("192.168.5.66");
			
			final Document document = new Document(); 
			final Element rootElement = new Element("user");
			document.setRootElement(rootElement);
			
			final List<Element> elements = new ArrayList<Element>();
			/*
			 * 注意，此时elements是空集合，addContent
			 * 执行后，将拷贝到 rootElement中，此时为空
			 * 因此，应该在添加完所有的子元素后再添加到
			 * 根元素
			 */
			//rootElement.addContent(elements);
			Element element = null;
			
			element = new Element("id");
			element.setText(user.getId());
			elements.add(element);
			
			element = new Element("username");
			element.setText(user.getUsername());
			elements.add(element);
			
			element = new Element("nickname");
			element.setText(user.getNickname());
			elements.add(element);
			
			element = new Element("password");
			element.setText(user.getPassword());
			elements.add(element);
			
			element = new Element("valid");
			element.setText(String.valueOf(user.isValid()));
			elements.add(element);
			
			element = new Element("lastLoginTime");
			element.setText(DateTimeUtil.format(user.getLastLoginTime()));
			elements.add(element);
			
			element = new Element("lastLoginIp");
			element.setText(user.getLastLoginIp());
			elements.add(element);
			
			/*
			 * 放在添加子元素之后，再添加到父元素
			 * 这样添加才能生效
			 */
			rootElement.addContent(elements);
			
			// XMLOutput
			final XMLOutputter out = new XMLOutputter();
			// 获取格式对象
			//final Format format = out.getFormat();
			final Format format = Format.getPrettyFormat();
			// 设置编码 - 中文
			format.setEncoding(Constant.CHART_SET_UTF_8);
			// format 为 PreetyFormat 对象时，设置该属性，Pretty输出将失效
			//format.setTextMode(TextMode.PRESERVE);
			// 设置输出格式
			out.setFormat(format);
			OutputStream 	outputStream = new FileOutputStream(file);
			// 输出 xml 文件
			out.output(document, outputStream);
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
