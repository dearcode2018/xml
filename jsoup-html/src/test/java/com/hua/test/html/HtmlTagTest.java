/**
 * 描述: 
 * HtmlTagTest.java
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

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * HtmlTagTest
 */
public final class HtmlTagTest extends BaseTest {

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
			
			Document document = Jsoup.parse(html);
			
			Elements elements = document.getElementsByTag("img");
			Iterator<Element> it = elements.iterator();
			Element element = null;
			String srcValue = null;
			while (it.hasNext())
			{
				element = it.next();
				srcValue = element.attr("src");
				System.out.println("srcValue = " + srcValue);
			}
			
			
		} catch (Exception e) {
			log.error("testFindTagRecycle =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 循环寻找标签的value值
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFindTagRecycleAndReplace() {
		try {
			// /o2oWeb/data/uploadfiles/
			String html = "<p><img alt=\"cat1.jpg\" src=\"/o2oWeb/data/uploadfiles/1451879890023099171.jpg\" title=\"1451879890023099171.jpg\"/></p>";
			html = "<p><img alt=\"cat2.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd23099172.png\" title=\"1451879890023099171.jpg\"/>"
					+ "<img alt=\"cat3.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd230919173.png\" title=\"1451879890023099171.jpg\"/>"
					+ "<img alt=\"cat4.jpg\" src=\"/o2oWeb/data/uploadfiles/14518798900ddd231099174.png\" title=\"1451879890023099171.jpg\"/>"
					+ "</p>";
			
			Document document = Jsoup.parse(html);
			
			Elements elements = document.getElementsByTag("img");
			Iterator<Element> it = elements.iterator();
			Element element = null;
			String srcValue = null;
			while (it.hasNext())
			{
				element = it.next();
				srcValue = element.attr("src");
				System.out.println("srcValue = " + srcValue);
				// 修改属性值
				element.attr("src", "http://a.c/a.gif");
			}
			/* 输出完整的html */
			System.out.println(document.toString());
			//System.out.println(document.html());
			//System.out.println(document.val());
			//System.out.println(document.data());
			//System.out.println(document.text());
			//System.out.println(document.normalise().toString());
			//System.out.println(document.body().toString());
			
		} catch (Exception e) {
			log.error("testFindTagRecycleAndReplace =====> ", e);
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
