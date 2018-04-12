/**
 * 描述: 
 * TagRegexTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.html;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * TagRegexTest
 */
public final class TagRegexTest extends BaseTest {

	/**
	 * 
	 * 描述: 循环寻找标签的value值
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFindTagRecycle() {
		try {
			// /o2oWeb/data/uploadfiles/
			String html = "<p><img alt=\"cat1.jpg\" src=\"/o2oWeb/data/uploadfiles/1451879890023099171.jpg\" title=\"1451879890023099171.jpg\"/></p>";
			html = "<p><img alt=\"cat2.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd23099172.png\" title=\"1451879890023099171.jpg\"/>"
					+ "<img alt=\"cat3.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd230919173.png\" title=\"1451879890023099171.jpg\"/>"
					+ "<img alt=\"cat4.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd231099174.png\" title=\"1451879890023099171.jpg\"/>"
					+ "</p>";
			final String regex = "[\\s\\S]+(/o2oWeb/data/uploadfiles/[\\w\\.\\w]+)[\\s\\S]+";
			//regex = "(/o2oWeb/data/uploadfiles/[\\w\\.\\w]+)+";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(html);
			boolean giveUp = false;
			// 匹配的值
			String matchValue = null;
			String filePath = null;
			while (matcher.matches() && !giveUp)
			{
				giveUp = false;
				
				matchValue = matcher.group(0);
				// 去除前缀 : /o2oWeb
				filePath = matchValue.substring("/o2oWeb".length());
				log.info("找到匹配值matchValue: " + matchValue);
				log.info("找到匹配值filePath: " + filePath);
				
				//html = html.replace(oldChar, newChar);
				
				
				// 再次匹配
				matcher = pattern.matcher(html);
			}
		} catch (Exception e) {
			log.error("testFindTagValue =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 寻找标签的value值
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFindTagValue() {
		try {
			// /o2oWeb/data/uploadfiles/
			String html = "<p><img alt=\"cat1.jpg\" src=\"/o2oWeb/data/uploadfiles/1451879890023099171.jpg\" title=\"1451879890023099171.jpg\"/></p>";
			html = "<p><img alt=\"cat2.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd23099172.png\" title=\"1451879890023099171.jpg\"/>"
					+ "<img alt=\"cat3.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd230919173.png\" title=\"1451879890023099171.jpg\"/>"
					+ "<img alt=\"cat4.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd231099174.png\" title=\"1451879890023099171.jpg\"/>"
					+ "</p>";
			String regex = "([\\s\\S]*(/o2oWeb/data/uploadfiles/[\\w\\.\\w]+)[\\s\\S]*)*";
			//regex = "(/o2oWeb/data/uploadfiles/[\\w\\.\\w]+)+";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(html);
			if (matcher.matches())
			{
				log.info("testFindTagValue =====> " + matcher.groupCount());
				for (int i = 0; i< matcher.groupCount(); i++)
				{
					System.out.println(matcher.group(i));
				}
			}
			
		} catch (Exception e) {
			log.error("testFindTagValue =====> ", e);
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
			String value = "abcaa";
			
			value.replace("a", "AA");
			System.out.println(value);
			
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
