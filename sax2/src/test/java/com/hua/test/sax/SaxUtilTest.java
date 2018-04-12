package com.hua.test.sax;
/**
 * 描述: 
 * SaxUtilTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */


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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.User;
import com.hua.handler.UserHandler;
import com.hua.test.BaseTest;
import com.hua.util.ProjectUtil;
import com.hua.util.SaxUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SaxUtilTest
 */
public final class SaxUtilTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadValue() {
		try {
			/*String path = ProjectUtil.getAbsolutePath("/doc/User.xml", true);
			UserHandler handler = new UserHandler(path);
			User user =SaxUtil.readValue(handler);
			System.out.println(user.toString());*/
		} catch (Exception e) {
			log.error("testReadValue =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 此测试说明，sax并没有针对含有dtd的xml
	 * 文档做校验，xsd同样也没做校验
	 * 只会验证 其中的dtd验证文件是否存在，而实际上并不做验证
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadValueWithDTD() {
		try {
			String filePath = ProjectUtil.getAbsolutePath("/doc/User-DTD.xml", true);
			UserHandler handler = new UserHandler();
			SaxUtil.readValue(handler, filePath);
			User user = handler.getUser();
			System.out.println(user.toString());
		} catch (Exception e) {
			log.error("testReadValueWithDTD =====> ", e);
		}
	}	

	/**
	 * 
	 * 描述: 此测试说明，sax并没有针对含有dtd的xml
	 * 文档做校验，xsd同样也没做校验
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadValueWithXSD() {
		try {
			String filePath = ProjectUtil.getAbsolutePath("/doc/User-XSD.xml", true);
			UserHandler handler = new UserHandler();
			SaxUtil.readValue(handler, filePath);
			User user = handler.getUser();
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
	public void test() {
		try {
			String str = "";
			
			System.out.println(str.substring(0, -1));
			
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
