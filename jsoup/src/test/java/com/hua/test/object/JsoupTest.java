/**
 * 描述: 
 * JsoupTest.java
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

import java.io.File;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.Constant;
import com.hua.test.BaseTest;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JsoupTest
 */
public final class JsoupTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testJsoup() {
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
			log.error("testJsoup =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testClean() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			whitelist.addTags("html", "body");
			
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径，默认为false
			whitelist.preserveRelativeLinks(true);
			//whitelist.preserveRelativeLinks(false);
			
			String path = ProjectUtil.getAbsolutePath("/doc/clean.html", true);
			String bodyHtml = FileUtil.getString(path);
			String baseUri = "http://jsoup.hua.com";
			String result = Jsoup.clean(bodyHtml, baseUri, whitelist);
			
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testClean =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testParse() {
		try {
			String path = ProjectUtil.getAbsolutePath("/doc/parse.html", true);
			File file = new File(path);
			String baseUri = "http://jsoup.hua.com";
			Document document = Jsoup.parse(file, Constant.CHART_SET_UTF_8, baseUri);
			Element head = document.head();
			Elements elements = head.getElementsByTag("title");
			Element title = elements.first();
			System.out.println(title.toString());
			// 取出 文本
			System.out.println(title.html());
			
			//System.out.println(title.data());
			
		} catch (Exception e) {
			log.error("testParse =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testConnect() {
		try {
			String url = "http://www.baidu.com";
			Connection connection = Jsoup.connect(url);
			
			Connection.Response response = connection.execute();
			
			String body = response.body();
			
			System.out.println(body);
			
		} catch (Exception e) {
			log.error("testConnect =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testIsValid() {
		try {
			Whitelist whitelist = Whitelist.relaxed();
			// 添加标签
			whitelist.addTags("script", "font");
			whitelist.addTags("html", "body");
			// 添加属性
			whitelist.addAttributes("script", "lang", "src");
			// 添加协议
			whitelist.addProtocols("script", "src", "http", "https");
			
			// 添加强制属性
			whitelist.addEnforcedAttribute("script", "lang", "JavaScript");
			
			// 是否保存 相对路径，false-转换为绝对路径
			whitelist.preserveRelativeLinks(true);
			String path = ProjectUtil.getAbsolutePath("/doc/valid.html", true);
			String bodyHtml = FileUtil.getString(path);
			
			boolean valid = Jsoup.isValid(bodyHtml, whitelist);
			
			log.info("testIsValid =====> valid = " + valid);
			
		} catch (Exception e) {
			log.error("testIsValid =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testParseBodyFragment() {
		try {
			
			
		} catch (Exception e) {
			log.error("testParseBodyFragment =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCleanHtml1() {
		try {
			String bodyHtml = "<img src=\"http://a/b1.png\" onerror=alert(1) />";
			bodyHtml = "<img src=\"/a/b1.png\" onerror=alert(1) />";
			Whitelist whitelist = Whitelist.basicWithImages();
		    whitelist.addAttributes("font", new String[] { "size", "color" });
		    String[] attributesAllSupport = { "alt", "style", "id", "rsid", "class", "type", "href", "rel", "src", "data-media-type", "height", "width" };
		   String all = ":all";
		    for (String attribute : attributesAllSupport) {
		      whitelist = whitelist.addAttributes(":all", new String[] { attribute });
		    }
		    String[] extendTags = { "input", "span", "textarea", "font" };
		    whitelist.addTags(extendTags);
			// 添加属性
			whitelist.addAttributes("img", "src", "title");
			// 添加协议
			whitelist.addProtocols("img", "src", "http", "https");
			// 保存相对链接
			//whitelist.preserveRelativeLinks(true);
			
			String value = Jsoup.clean(bodyHtml, whitelist);
			System.out.println(value);
		} catch (Exception e) {
			log.error("testCleanHtml1 =====> ", e);
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
