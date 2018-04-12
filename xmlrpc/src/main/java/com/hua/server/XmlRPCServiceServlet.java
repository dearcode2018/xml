/**
  * @filename XmlRPCServiceServlet.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.server;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.XmlRpcServletServer;

import com.hua.handler.impl.ServiceHandlerImpl;

 /**
 * @type XmlRPCServiceServlet
 * @description 
 * @author qianye.zheng
 */
@SuppressWarnings({"serial"})
public class XmlRPCServiceServlet extends HttpServlet
{

	/* Servlet Server */
	private XmlRpcServletServer servletServer;
	
	/**
	 * @description 
	 * @param config
	 * @throws ServletException
	 * @author qianye.zheng
	 */
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		try
		{
			// 创建xml rpc 服务对象
			servletServer = new XmlRpcServletServer();
			//
			final PropertyHandlerMapping mapping = new PropertyHandlerMapping();
			// 一般使用 接口全限定名
			final String key = "com.hua.handler.ServiceHandler";
			mapping.addHandler(key, ServiceHandlerImpl.class);
			
			servletServer.setHandlerMapping(mapping);
			
			final XmlRpcServerConfigImpl sererConfig = (XmlRpcServerConfigImpl) servletServer.getConfig();
			
			// 是否允许扩展
			sererConfig.setEnabledForExceptions(true);
			// 内容长度是否可选
			sererConfig.setContentLengthOptional(false);
		} catch (XmlRpcException e)
		{

		}
	}
	
	/**
	 * @description 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @author qianye.zheng
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		servletServer.execute(req, resp);
	}
	
	/**
	 * @description 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @author qianye.zheng
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		servletServer.execute(req, resp);
	}
}
