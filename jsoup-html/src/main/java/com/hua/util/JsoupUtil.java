/**
 * JsoupUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.hua.constant.Constant;
import com.hua.constant.FormatConstant;

/**
 * JsoupUtil
 * 描述:  - 工具类
 * @author  qye.zheng
 */
public final class JsoupUtil
{
	// 日期时间格式-默认采用
	private static final DateFormat dateTimeFormat = 
			new SimpleDateFormat(FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss);

	/* 路径拆分正则表达式 */
	private static final String PATH_SPLIT_REGEX = "\\.";
	
	static
	{
		
		setDefaultDateFormat();
	
	}
	
	/**
	 * 构造方法
	 * 描述: 私有 - 禁止实例化
	 * @author  qye.zheng
	 */
	private JsoupUtil()
	{
	}
	
	/* TODO  公共部分  ================================= */
	
	/**
	 * 
	 * 描述: 设置日期格式，若有特殊日期时间格式
	 * 在调用读、写方法之前，先调用此方法设置格式
	 * 该设置会影响全局日期解析
	 * @author  qye.zheng
	 * @param dateFormat
	 */
	public static final void setDateFormat(final DateFormat dateFormat)
	{
		
	}	
	
	/**
	 * 
	 * 描述: 使用默认的日期格式 
	 * @author  qye.zheng
	 */
	public static final void setDefaultDateFormat()
	{
	
	}
	
	/**
	 * 读-支持 byte[] String File InputStream Reader URL  6种参数
	 * 
	 * @warning: 流在使用完成之后 会关闭
	 */
	
	/* read value 返回单个对象 ================================= */
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValue(final String jsonString, final Class<T> clazz)
	{
		T t = null;
		try
		{
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param data
	 * @return
	 */
	public static final <T> T readValue(final byte[] data, final Class<T> clazz)
	{
		T t = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValue(final File file, final Class<T> clazz)
	{
		T t = null;
		try
		{
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}

	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param inputStream
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValue(final InputStream inputStream, final Class<T> clazz)
	{
		T t = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(inputStream);
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param reader
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValue(final Reader reader, final Class<T> clazz)
	{
		T t = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(reader);
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param url 链接对象
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValue(final URL url, final Class<T> clazz)
	{
		T t = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/* read values 返回List ================================= */
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValues(final String jsonString, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param data
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValues(final byte[] data, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValues(final File file, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param inputStream
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValues(final InputStream inputStream, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(inputStream);
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param reader
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValues(final Reader reader, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(reader);
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param url 链接对象
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValues(final URL url, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 根据字段名称读取为JsonNode，ObjectReader.treeAsTokens()
	 * 得到JsonParser，然后ObjectReader.readValue(JsonParser jp, Class<T>)
	 */
	
	/* TODO 读 特定功能  ================================= */	
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param jsonString
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValueByPath(final String jsonString, final String path, final Class<T> clazz)
	{
		T t = null;
		try
		{
			// 将 path 拆开
			final String[] fieldNames = path.split(PATH_SPLIT_REGEX);


		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return t;
	}

	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param inputStream
	 * @param path 路径，例如 a.b.c
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValueByPath(final InputStream inputStream, final String path, final Class<T> clazz)
	{
		T t = null;
		try
		{
			// 将 path 拆开
			final String[] fieldNames = path.split(PATH_SPLIT_REGEX);

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(inputStream);
		}
		
		return t;
	}	
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param reader
	 * @param path 路径，例如 a.b.c
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValueByPath(final Reader reader, final String path, final Class<T> clazz)
	{
		T t = null;
		try
		{
			// 将 path 拆开
			final String[] fieldNames = path.split(PATH_SPLIT_REGEX);

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(reader);
		}
		
		return t;
	}		

	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param file
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValueByPath(final File file, final String path, final Class<T> clazz)
	{
		T t = null;
		try {
			final InputStream inputStream = new FileInputStream(file);
			t = readValueByPath(inputStream, path, clazz);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param data
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValueByPath(final byte[] data, final String path, final Class<T> clazz)
	{
		T t = null;
		try {
			// 默认使用 UTF-8编码
			final String jsonString = new String(data, Constant.CHART_SET_UTF_8);
			t = readValueByPath(jsonString, path, clazz);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param url
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> T readValueByPath(final URL url, final String path, final Class<T> clazz)
	{
		T t = null;
		try {
			final InputStream inputStream = url.openStream();
			t = readValueByPath(inputStream, path, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param jsonString
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValuesByPath(final String jsonString, final String path, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{
			// 将 path 拆开
			final String[] fieldNames = path.split(PATH_SPLIT_REGEX);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param inputStream
	 * @param path 路径，例如 a.b.c
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValuesByPath(final InputStream inputStream, final String path, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{

			// 将 path 拆开
			final String[] fieldNames = path.split(PATH_SPLIT_REGEX);

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(inputStream);
		}
		
		return list;
	}	
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param reader
	 * @param path 路径，例如 a.b.c
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValuesByPath(final Reader reader, final String path, final Class<T> clazz)
	{
		List<T> list = null;
		try
		{
			// 将 path 拆开
			final String[] fieldNames = path.split(PATH_SPLIT_REGEX);

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(reader);
		}
		
		return list;
	}	

	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param data
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValuesByPath(final byte[] data, final String path, final Class<T> clazz)
	{
		List<T> list = null;
		try {
			// 默认使用 UTF-8编码
			final String jsonString = new String(data, Constant.CHART_SET_UTF_8);
			list = readValuesByPath(jsonString, path, clazz);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param file
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValuesByPath(final File file, final String path, final Class<T> clazz)
	{
		List<T> list = null;
		try {
			final InputStream inputStream = new FileInputStream(file);
			list = readValuesByPath(inputStream, path, clazz);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param url
	 * @param path 路径，例如 a.b.c 或 a
	 * @param clazz
	 * @return
	 */
	public static final <T> List<T> readValuesByPath(final URL url, final String path, final Class<T> clazz)
	{
		List<T> list = null;
		try {
			final InputStream inputStream = url.openStream();
			list = readValuesByPath(inputStream, path, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/* write object ================================= */
	
	/**
	 * 
	 * 描述: 输出对象到文件
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final File file, final Object value)
	{
		boolean flag = false;
		try
		{

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到输出流
	 * @author  qye.zheng
	 * @param outputStream
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final OutputStream outputStream, final Object value)
	{
		boolean flag = false;
		try
		{
			// 对象写出器

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(outputStream);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到 写入器
	 * @author  qye.zheng
	 * @param writer
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final Writer writer, final Object value)
	{
		boolean flag = false;
		try
		{
			// 对象写出器

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(writer);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字节数组)
	 * @author  qye.zheng
	 * @param value
	 * @return
	 */
	public static final byte[] writeAsBytes(final Object value)
	{
		byte[] data = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字符串)
	 * @author  qye.zheng
	 * @param value
	 * @return
	 */
	public static final String writeAsString(final Object value)
	{
		String data = null;
		try
		{
	
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	/* TODO 写 特定功能  ================================= */
	
	/**
	 * 说明:
	 * include 和 exclude 方法 需要配合 JavaBean使用注解 @JsonFilter("Bean限定名") 来使用
	 * 
	 * 属性过滤器: 可以在ObjectMapper初始化时，可以创建一个通用的过滤器，设置为全局性，然后标注到Bean 
	 * 
	 */
	
	/**
	 * 
	 * 描述: 输出对象到文件
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @return
	 */
	public static final boolean writeValueInclude(final File file, final Object value, 
			final String... includeFields)
	{
		boolean flag = false;
		try
		{

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到输出流
	 * @author  qye.zheng
	 * @param outputStream
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @return
	 */
	public static final boolean writeValueInclude(final OutputStream outputStream, final Object value, 
			final String... includeFields)
	{
		boolean flag = false;
		try
		{

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(outputStream);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到 写入器
	 * @author  qye.zheng
	 * @param writer
	 * @param value
	 * @return
	 */
	public static final boolean writeValueInclude(final Writer writer, final Object value, 
			final String... includeFields)
	{
		boolean flag = false;
		try
		{

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(writer);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字节数组)
	 * @author  qye.zheng
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @return
	 */
	public static final byte[] writeIncludeAsBytes(final Object value, 
			final String... includeFields)
	{
		 byte[] result = null;
		try
		{
	
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字符串)
	 * @author  qye.zheng
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @return
	 */
	public static final String writeIncludeAsString(final Object value, 
			final String... includeFields)
	{
		String result = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 
	 * 描述: 输出对象到文件
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param value
	 * @param excludeFields 排除指定字段，为空则包含所有字段
	 * @return
	 */
	public static final boolean writeValueExclude(final File file, final Object value, 
			final String... excludeFields)
	{
		boolean flag = false;
		try
		{
	
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到输出流
	 * @author  qye.zheng
	 * @param outputStream
	 * @param value
	 * @param excludeFields 排除指定字段，为空则包含所有字段
	 * @return
	 */
	public static final boolean writeValueExclude(final OutputStream outputStream, final Object value, 
			final String... excludeFields)
	{
		boolean flag = false;
		try
		{

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(outputStream);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到 写入器
	 * @author  qye.zheng
	 * @param writer
	 * @param value
	 * @param excludeFields 排除指定字段，为空则包含所有字段
	 * @return
	 */
	public static final boolean writeValueExclude(final Writer writer, final Object value, 
			final String... excludeFields)
	{
		boolean flag = false;
		try
		{

			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{ // 关闭流
			IOUtil.close(writer);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字节数组)
	 * @author  qye.zheng
	 * @param value
	 * @param excludeFields 排除指定字段，为空则包含所有字段
	 * @return
	 */
	public static final byte[] writeExcludeAsBytes(final Object value, 
			final String... excludeFields)
	{
		byte[] result = null;
		try
		{
	
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字符串)
	 * @author  qye.zheng
	 * @param value
	 * @param excludeFields 排除指定字段，为空则包含所有字段
	 * @return
	 */
	public static final String writeExcludeAsString(final Object value, 
			final String... excludeFields)
	{
		String result = null;
		try
		{

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}
