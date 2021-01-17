/**
 * 描述: 
 * CustomerTest.java
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.xmlbeans.BillingAddressType;
import com.hua.xmlbeans.CustomerType;
import com.hua.xmlbeans.CustomersDocument;
import com.hua.xmlbeans.PrimaryAddressType;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * CustomerTest
 */
public final class CustomerTest extends BaseTest {

	/**
	 * 
	 * 描述: 读取 xml 文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadXml() {
		try {
			final String path = ClassPathUtil.getClassPath("/conf/xml/customers.xml");
			final File file = new File(path);
			final CustomersDocument doc = CustomersDocument.Factory.parse(file);
			CustomerType[] customers = doc.getCustomers().getCustomerArray();  
			for (int i = 0; i < customers.length; i++) {   
                CustomerType customer = customers[i];   
                println("Customer" + i);   
                println("Customer ID:" + customer.getId());   
                println("First name:" + customer.getFirstname());   
                println("Last name:" + customer.getLastname());   
                println("Gender:" + customer.getGender());   
                println("PhoneNumber:" + customer.getPhoneNumber());   
                // Primary address   
                PrimaryAddressType primaryAddress = customer.getAddress().getPrimaryAddress();   
                println("PrimaryAddress:");   
                println("PostalCode:" + primaryAddress.getPostalCode());   
                println("AddressLine1:" + primaryAddress.getAddressLine());   
                // Billing address   
 
                BillingAddressType billingAddress = customer.getAddress().getBillingAddress();   
                println("BillingAddress:");   
                println("Receiver:" + billingAddress.getReceiver());   
                println("PostalCode:" + billingAddress.getPostalCode());   
                println("AddressLine1:" + billingAddress.getAddressLine());   
              } 
			
			//CustomersDocument a = null;
		} catch (Exception e) {
			log.error("testReadXml =====> ", e);
		}
	}
	
	 private void println(String str) {   
		  
         System.out.println(str);   

   } 
	
	/**
	 * 
	 * 描述: 输出 xml 文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWriteXml() {
		try {
			
			
		} catch (Exception e) {
			log.error("testWriteXml =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSchema() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSchema =====> ", e);
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
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		System.out.println("afterMethod()");
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
