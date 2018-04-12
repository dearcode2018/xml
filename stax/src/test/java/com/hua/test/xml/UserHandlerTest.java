/**
 * 描述: 
 * UserHandlerTest.java
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
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.Address;
import com.hua.bean.Company;
import com.hua.bean.User;
import com.hua.constant.sys.UserType;
import com.hua.parser.UserHandler;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * UserHandlerTest
 */
public final class UserHandlerTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUserParser() {
		try {
			
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			User user = UserHandler.readValue(path);
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testUserParser =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 此测试说明，stax并没有针对含有dtd的xml
	 * 文档做校验，xsd同样也没做校验
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUserParserWithDTD() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/User-DTD.xml", true);
			User user = UserHandler.readValue(path);
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testUserParserWithDTD =====> ", e);
		}
	}		
	
	
	/**
	 * 
	 * 描述: 此测试说明，stax并没有针对含有dtd的xml
	 * 文档做校验，xsd同样也没做校验
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUserParserWithXSD() {
		try {
			
			String path = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			User user = UserHandler.readValue(path);
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testUserParserWithXSD =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadValue() {
		try {
			
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			User user = UserHandler.readValue(path);
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
	public void testWriteValue() {
		try {
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
			
			String path = ProjectUtil.getAbsolutePath("/doc/UserWrite.xml", true);
			File file = new File(path);
			
			UserHandler.writeValue(user, file);
			
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
	public void testWriteValueWithDTD() {
		try {
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
			
			String path = ProjectUtil.getAbsolutePath("/doc/UserWrite.xml", true);
			File file = new File(path);
			
			UserHandler.writeValue(user, file);
			
		} catch (Exception e) {
			log.error("testWriteValueWithDTD =====> ", e);
		}
	}	

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWriteValueWithXSD() {
		try {
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
			
			String path = ProjectUtil.getAbsolutePath("/doc/UserWrite.xml", true);
			File file = new File(path);
			
			UserHandler.writeValue(user, file);
			
		} catch (Exception e) {
			log.error("testWriteValueWithXSD =====> ", e);
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
