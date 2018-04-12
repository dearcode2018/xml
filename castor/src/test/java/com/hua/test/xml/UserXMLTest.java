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
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.User;
import com.hua.handler.UserHandler;
import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.DateTimeUtil;
import com.hua.util.FileUtil;
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
	public void testUserXML() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			
		} catch (Exception e) {
			log.error("testUserXML =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 解编组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRead() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			File file = new File(path);
			Reader reader = new FileReader(file); 
			/*
			 * 使用 映射文件，直接使用 Unmarshaller静态方法去转换
			 * 并没有使用到映射文件
			 */
			Unmarshaller unmarshaller = new Unmarshaller(mapping);
			User user = (User) unmarshaller.unmarshal(reader);
			
			//User user = (User) Unmarshaller.unmarshal(User.class, reader);
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testRead =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解编组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadWithDTD() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			String path = ProjectUtil.getAbsolutePath("/doc/User-DTD.xml", true);
			File file = new File(path);
			Reader reader = new FileReader(file); 
			/*
			 * 使用 映射文件，直接使用 Unmarshaller静态方法去转换
			 * 并没有使用到映射文件
			 */
			Unmarshaller unmarshaller = new Unmarshaller(mapping);
			User user = (User) unmarshaller.unmarshal(reader);
			
			//User user = (User) Unmarshaller.unmarshal(User.class, reader);
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testReadWithDTD =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解编组
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadWithXSD() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			String path = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			File file = new File(path);
			Reader reader = new FileReader(file); 
			/*
			 * 使用 映射文件，直接使用 Unmarshaller静态方法去转换
			 * 并没有使用到映射文件
			 */
			Unmarshaller unmarshaller = new Unmarshaller(mapping);
			User user = (User) unmarshaller.unmarshal(reader);
			
			//User user = (User) Unmarshaller.unmarshal(User.class, reader);
			
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testReadWithXSD =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testRead2() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			File file = new File(path);
			Reader reader = new FileReader(file); 
			String str = FileUtil.getString(file);
			System.out.println(str);
			User user = (User) Unmarshaller.unmarshal(User.class, reader);
			System.out.println(user.toString());
		} catch (Exception e) {
			log.error("testRead2 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWrite() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			OutputStream outputStream = System.out;
			Writer writer = new OutputStreamWriter(outputStream);
			
			User user = new User();
			user.setId("20150628");
			user.setUsername("张三");
			user.setNickname("少年张三丰");
			user.setPassword("123456");
			user.setValid(false);
			user.setLastLoginTime(DateTimeUtil.getTimestamp());
			user.setLastLoginIp("192.168.5.66");
			Marshaller marshaller = new Marshaller();
			
			// 使用映射文件
			marshaller.setMapping(mapping);
			marshaller.setWriter(writer);
			//marshaller.setRootElement("user");
			marshaller.marshal(user);
			
		} catch (Exception e) {
			log.error("testWrite =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWriteWithoutMapping() {
		try {
			/**
			 * 字段处理器 接口
			 * org.exolab.castor.mapping.FieldHandler<T>
			 */
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			OutputStream outputStream = System.out;
			Writer writer = new OutputStreamWriter(outputStream);
			
			User user = new User();
			user.setId("20150628");
			user.setUsername("张三");
			user.setNickname("少年张三丰");
			user.setPassword("123456");
			user.setValid(false);
			user.setLastLoginTime(DateTimeUtil.getTimestamp());
			user.setLastLoginIp("192.168.5.66");
			
			Marshaller.marshal(user, writer);
			System.out.println();
		} catch (Exception e) {
			log.error("testWriteWithoutMapping =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHandlerWrite() {
		try {
			
			String url = ClassPathUtil.getClassSubpath("/conf/xml/UserMapping.xml");
			Mapping mapping = new Mapping();
			mapping.loadMapping(url);
			
			OutputStream outputStream = System.out;
			Writer writer = new OutputStreamWriter(outputStream);
			
			User user = new User();
			user.setId("20150628");
			user.setUsername("张三");
			user.setNickname("少年张三丰");
			user.setPassword("123456");
			user.setValid(false);
			user.setLastLoginTime(DateTimeUtil.getTimestamp());
			user.setLastLoginIp("192.168.5.66");
			
			String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			UserHandler handler = new UserHandler(path);
			
			Marshaller.marshal(user, handler);
			System.out.println();
		} catch (Exception e) {
			log.error("testHandlerWrite =====> ", e);
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
