/**
  * @filename BaseHandler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

 /**
 * @type BaseHandler
 * @description 
 * @author qianye.zheng
 */
public abstract class BaseHandler<T> extends DefaultHandler
{
	/* xml 文档的路径 */
	private String path;
	
	/* 前置标签，用来进行状态控制 */
	private String preTag;
	
	private Class<?> clazz;
	
	private T t;
	
	/**
	 * @description 构造方法
	 * @param path
	 * @author qianye.zheng
	 */
	public BaseHandler(final String path, final Class<?> clazz)
	{
		this.path = path;
		this.clazz = clazz;
	}
	
	/**
	 * @return the path
	 */
	public final String getPath()
	{
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public final void setPath(String path)
	{
		this.path = path;
	}

	/**
	 * @return the t
	 */
	public T get()
	{
		return t;
	}

	/**
	 * @return the preTag
	 */
	protected final String getPreTag()
	{
		return preTag;
	}

	/**
	 * @param preTag the preTag to set
	 */
	protected final void setPreTag(String preTag)
	{
		this.preTag = preTag;
	}
	
	/**
	 * @description 
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	@SuppressWarnings({"unchecked"})
	public void startDocument() throws SAXException
	{
		super.startDocument();
		try
		{
			// 构造对象
			t = (T) clazz.newInstance();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @description 
	 * @param uri
	 * @param localName
	 * @param qName
	 * @param attributes
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		super.startElement(uri, localName, qName, attributes);
		// 设置 前置标签
		preTag = localName;
	}

	/**
	 * @description 
	 * @param uri
	 * @param localName
	 * @param qName
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		super.endElement(uri, localName, qName);
		/*
		 * 一定要置空，否则读到一下行，该方法还会被调用一次，
		 * 会导致 第二次设置字段为空值.
		 */
		preTag = null;
	}
	
	/**
	 * @description 
	 * @param ch
	 * @param start
	 * @param length
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException
	{
		super.ignorableWhitespace(ch, start, length);
	}

	/**
	 * @description 
	 * @param target
	 * @param data
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void processingInstruction(String target, String data)
			throws SAXException
	{
		super.processingInstruction(target, data);
	}

	/**
	 * @description 
	 * @param name
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void skippedEntity(String name) throws SAXException
	{
		super.skippedEntity(name);
	}

	/**
	 * @description 
	 * @param e
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void warning(SAXParseException e) throws SAXException
	{
		super.warning(e);
	}

	/**
	 * @description 
	 * @param e
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void error(SAXParseException e) throws SAXException
	{
		super.error(e);
	}

	/**
	 * @description 
	 * @param e
	 * @throws SAXException
	 * @author qianye.zheng
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXException
	{
		super.fatalError(e);
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		final String value = new String(ch, start, length);
		if (null != preTag)
		{
			// 调用子类的set方法
			set(preTag, value);
		}
	}
	
	/**
	 * 
	 * @description 父类的characters()方法会回调此方法
	 * @param field
	 * @param value
	 * @author qianye.zheng
	 */
	public abstract void set(final String field, final String value);
}
