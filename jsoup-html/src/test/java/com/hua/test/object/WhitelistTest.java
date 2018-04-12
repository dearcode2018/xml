/**
 * 描述: 
 * WhitelistTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.object;

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

import org.jsoup.safety.Whitelist;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * WhitelistTest
 */
public final class WhitelistTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWhitelist() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
			
		} catch (Exception e) {
			log.error("testWhitelist =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddTags() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
			
		} catch (Exception e) {
			log.error("testAddTags =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddAttributes() {
		try {
			
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
		} catch (Exception e) {
			log.error("testAddAttributes =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddProtocols() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
			
		} catch (Exception e) {
			log.error("testAddProtocols =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAddEnforcedAttribute() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
			
		} catch (Exception e) {
			log.error("testAddEnforcedAttribute =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPreserveRelativeLinks() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
			
		} catch (Exception e) {
			log.error("testPreserveRelativeLinks =====> ", e);
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
