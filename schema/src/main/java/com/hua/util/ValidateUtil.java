/**
  * @filename ValidateUtil.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.xml.sax.SAXException;

import com.hua.constant.Constant;

 /**
 * @type ValidateUtil
 * @description  DTD / XSD 验证
 * 根据xsd文档验证一个xml文档是否格式良好、格式正确.
 * @author qianye.zheng
 */
public final class ValidateUtil {

	
	/**
	 * 
	 * @description 
	 * @param reader xml 文档输入流
	 * @return
	 * @author qianye.zheng
	 */
	private static final OMElement  getOMElement(final Reader reader)
	{
		OMElement element = null;
		XMLStreamReader streamReader = null;
		try {
			streamReader = XMLInputFactory.newInstance().createXMLStreamReader(reader);
			final StAXOMBuilder builder = new StAXOMBuilder(streamReader);
			element = builder.getDocumentElement();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} finally
		{
			IOUtil.close(reader);
			try {
				streamReader.close();
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
		}
		
		return element;
	}
	
	/**
	 * 
	 * @description 验证
	 * @param xmlReader 文档输入流
	 * @param xsdReader xsd 文档输入流
	 * @return
	 * @author qianye.zheng
	 */
	public static final boolean validate(final Reader xmlReader, final Reader xsdReader)
	{
		// 获取 OMElement
		final OMElement element = getOMElement(xmlReader);
		boolean flag = false;
		// 获取 schema 工厂 http://www.w3.org/2001/XMLSchema-instance
		final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		// 获取XSD文件
		final Source xsdSource = new StreamSource(xsdReader);
		try {
			final Schema schema = factory.newSchema(xsdSource);
			/**
			 * 将 dom 对象转成流对象，以便对DOM树对象验证
			 */
			final String input = element.toString();
			//final String input = element.getText();
			final ByteArrayInputStream btInputStream = new ByteArrayInputStream(input.getBytes(Constant.CHART_SET_UTF_8));
			final Validator validator = schema.newValidator();
			final Source xmlSource = new StreamSource(btInputStream);
			// 若抛异常，则验证失败
			validator.validate(xmlSource);
			flag = true;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally
		{
			IOUtil.close(xsdReader);
			IOUtil.close(xmlReader);
		}
		
		return flag;
	}
	
}
