/**
 * 描述: 
 * JdomTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.dom;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.Format.TextMode;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

import com.hua.constant.Constant;
import com.hua.entity.dom.Address;
import com.hua.entity.dom.BaseAttr;
import com.hua.entity.dom.People;
import com.hua.test.BaseTest;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdomTest
 */
public final class JdomTest extends BaseTest {

	/**
	 * 
	 * 描述: 简单生成xml文件
	 * @author qye.zheng 
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			// 对象不能重复添加，重复添加将抛异常
			// xml 文件头，自动加上，encoding的值取决于格式对象所设置的编码
			log.info("testWriteXml =====> path = " + PATH);
			final String filePath = PATH + "/" + "people.xml";
			// 文档对象 - 最外层标签
			final Document doc = new Document();
			final Element rootElement = new Element("addresses");
			// 设置根元素
			doc.setRootElement(rootElement);
			// 联系人元素
			final Element linkman = new Element("linkman");
			
			// 加入 根元素中
			rootElement.addContent(linkman);
			
			// 名称元素
			final Element name = new Element("name");
			name.setText("郑乾业");
			// id 属性
			final Attribute idAttr = new Attribute("id", "zqy2008");
			// 设置元素的属性
			name.setAttribute(idAttr);
			// email元素
			final Element email = new Element("email");
			email.setText("dearzqy@163.com");
			// 加入 联系人元素中
			linkman.addContent(name);
			// 加入 联系人元素中
			linkman.addContent(email);
			
			// XMLOutput
			final XMLOutputter out = new XMLOutputter();
			// 获取格式对象
			Format format = out.getFormat();
			// 设置编码 - 中文
			format.setEncoding(Constant.CHART_SET_UTF_8);
			// 文件输出流
			//final OutputStream output = new FileOutputStream(filePath);
			// 控制台输出流
			final OutputStream output = System.out;
			// 输出 xml 文件
			out.output(doc, output);
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 生成xml文件
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWriteXml() {
		try {
			
			final List<People> peoples = new ArrayList<People>();
			final People p1 = new People();
			final Address a1 = new Address();
			a1.setId("gd-gz-tianhe-2008");
			a1.setText("广东省广州市天河区");
			p1.setName("张东");
			p1.setAddress(a1);
			peoples.add(p1);
			
			final People p2 = new People();
			final Address a2 = new Address();
			a2.setId("gd-gz-tianhe-2008");
			a2.setText("广西省北海市龙岗区");
			p2.setName("李海");
			p2.setAddress(a2);
			peoples.add(p2);
			
			// 对象不能重复添加，重复添加将抛异常
			// xml 文件头，自动加上，encoding的值取决于格式对象所设置的编码
			log.info("testWriteXml =====> path = " + PATH);
			final String filePath = PATH + "/" + "write.xml";
			// 文档对象 - 最外层标签
			final Document doc = new Document();
			final Element rootElement = new Element("Peoples");
			// 设置根元素
			doc.setRootElement(rootElement);
			Element peopleEl = null;
			Element addressEl = null;
			Attribute attr = null;
			People p = null;
			Address addr = null;
			
			// 
			for (int i = 0; i < peoples.size(); i++) {
				p = peoples.get(i);
				peopleEl = new Element(p.getTagName());
				attr = new Attribute(BaseAttr.KEY_NAME, p.getName());
				peopleEl.setAttribute(attr);
				addr = p.getAddress();
				addressEl = new Element(addr.getTagName());
				addressEl.setText(addr.getText());
				peopleEl.addContent(addressEl);
				// 加入 root 元素下
				rootElement.addContent(peopleEl);
			}
			
			// XMLOutput
			final XMLOutputter out = new XMLOutputter();
			// 获取格式对象
			Format format = out.getFormat();
			// 设置编码 - 中文
			format.setEncoding(Constant.CHART_SET_UTF_8);
			format.setTextMode(TextMode.PRESERVE);
			// 输出流
			final OutputStream output = new FileOutputStream(filePath);
			
			// 输出 xml 文件
			out.output(doc, output);
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解析xml
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadXml() {
		try {
			// org.jdom2.input.SAXBuilder
			final SAXBuilder builder = new SAXBuilder();
			
			
			
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
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
}
