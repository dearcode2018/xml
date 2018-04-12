/**
 * 描述: 
 * JaxbTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.xml;

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import com.hua.jaxb.customer.AddressType;
import com.hua.jaxb.customer.BillingAddressType;
import com.hua.jaxb.customer.CustomerType;
import com.hua.jaxb.customer.Customers;
import com.hua.jaxb.customer.ObjectFactory;
import com.hua.jaxb.customer.PrimaryAddressType;
import com.hua.test.BaseTest;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * JaxbTest
 */
public final class JaxbTest extends BaseTest
{
	
	/**
	 * 
	 * 描述: 编组 - JavaBean -> xml
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMarshal() {
		try {
			// com.hua.jaxb.customer.*下生成的代码
			// 对象工厂
			ObjectFactory factory = new ObjectFactory();
			
			Customers customers = factory.createCustomers();
			CustomerType customerType = factory.createCustomerType();
			customerType.setId(2005);
			customerType.setGender("male");
			
			AddressType addressType = factory.createAddressType();
			
			PrimaryAddressType primaryAddressType = factory.createPrimaryAddressType();
			primaryAddressType.setPostalCode("245642");
			primaryAddressType.setAddressLine("广东省广州市天河区平云路252号");
			
			BillingAddressType billingAddressType = factory.createBillingAddressType();
			billingAddressType.setReceiver("王某人");
			billingAddressType.setPostalCode("564564");
			billingAddressType.setAddressLine("广东省广州市增城区新塘镇北海路立新路5545号");
			
			addressType.setPrimaryAddress(primaryAddressType);
			addressType.setBillingAddress(billingAddressType);
			
			customerType.setAddress(addressType);
			
			customers.getCustomer().add(customerType);
			
			// 指定 xjc 生成的java对象所在的包
			JAXBContext jaxbContext = JAXBContext.newInstance("com.hua.jaxb.customer");

			//
			Marshaller marshaller = jaxbContext.createMarshaller();

			// 
			Writer writer = new StringWriter();
			
			marshaller.marshal(customers, writer);

			// 输出xml
			System.out.println(writer.toString()); 
			
			// 或者
			//marshaller.marshal(customers, System.out);
			
		} catch (Exception e) {
			log.error("testMarshal =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 解组 - xml -> JavaBean 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnmarshal() {
		try {
			// com.hua.jaxb.customer.*下生成的代码
			// 对象工厂
			ObjectFactory factory = new ObjectFactory();
			
			Customers customers = factory.createCustomers();
			CustomerType customerType = factory.createCustomerType();
			customerType.setId(2005);
			customerType.setGender("male");
			
			AddressType addressType = factory.createAddressType();
			
			PrimaryAddressType primaryAddressType = factory.createPrimaryAddressType();
			primaryAddressType.setPostalCode("245642");
			primaryAddressType.setAddressLine("广东省广州市天河区平云路252号");
			
			BillingAddressType billingAddressType = factory.createBillingAddressType();
			billingAddressType.setReceiver("王某人");
			billingAddressType.setPostalCode("564564");
			billingAddressType.setAddressLine("广东省广州市增城区新塘镇北海路立新路5545号");
			
			addressType.setPrimaryAddress(primaryAddressType);
			addressType.setBillingAddress(billingAddressType);
			
			customerType.setAddress(addressType);
			
			customers.getCustomer().add(customerType);
			
			// 指定 xjc 生成的java对象所在的包
			JAXBContext jaxbContext = JAXBContext.newInstance("com.hua.jaxb.customer");

			//
			Marshaller marshaller = jaxbContext.createMarshaller();

			//
			Writer writer = new StringWriter();
			
			marshaller.marshal(customers, writer);

			// 输出xml
			System.out.println(writer.toString()); 
			
			// 或者
			//marshaller.marshal(customers, System.out);
			
		} catch (Exception e) {
			log.error("testUnmarshal =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 测试 xjc 命令行方式生成 java 对象
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testXjc() {
		try {
			// com.hua.jaxb.customer.*下生成的代码
			// 对象工厂
			ObjectFactory factory = new ObjectFactory();
			
			Customers customers = factory.createCustomers();
			CustomerType customerType = factory.createCustomerType();
			customerType.setId(2005);
			customerType.setGender("male");
			
			AddressType addressType = factory.createAddressType();
			
			PrimaryAddressType primaryAddressType = factory.createPrimaryAddressType();
			primaryAddressType.setPostalCode("245642");
			primaryAddressType.setAddressLine("广东省广州市天河区平云路252号");
			
			BillingAddressType billingAddressType = factory.createBillingAddressType();
			billingAddressType.setReceiver("王某人");
			billingAddressType.setPostalCode("564564");
			billingAddressType.setAddressLine("广东省广州市增城区新塘镇北海路立新路5545号");
			
			addressType.setPrimaryAddress(primaryAddressType);
			addressType.setBillingAddress(billingAddressType);
			
			customerType.setAddress(addressType);
			
			customers.getCustomer().add(customerType);
			
			// 指定 xjc 生成的java对象所在的包
			JAXBContext jaxbContext = JAXBContext.newInstance("com.hua.jaxb.customer");

			//
			Marshaller marshaller = jaxbContext.createMarshaller();

			//
			Writer writer = new StringWriter();
			
			marshaller.marshal(customers, writer);

			// 输出xml
			System.out.println(writer.toString()); 
			
			// 或者
			//marshaller.marshal(customers, System.out);
			
		} catch (Exception e) {
			log.error("testXjc =====> ", e);
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
}
