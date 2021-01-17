/**
  * @filename RPCClient.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

 /**
 * @type RPCClient
 * @description 
 * @author qianye.zheng
 */
public final class RPCClient
{

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	private RPCClient()
	{
	}
	
	/**
	 * 
	 * @description 
	 * @param address 服务地址
	 * @param path 类路径.方法名
	 * @param params 请求参数
	 * @return
	 * @author qianye.zheng
	 */
	public static final Object execute(final String address, final String path, final Object[] params)
	{
		Object result = null;
		try
		{
			// 客户端配置
			//final XmlRpcClientConfig clientConfig = new XmlRpcClientConfigImpl();
			final XmlRpcClientConfigImpl clientConfig = new XmlRpcClientConfigImpl();
			final URL url = new URL(address);
			// 设置服务端地址
			clientConfig.setServerURL(url);
			// 创建xml rpc 客户端
			XmlRpcClient client = new XmlRpcClient();
			// 绑定配置
			client.setConfig(clientConfig);
			
			// 执行请求
			result = client.execute(path, params);
			
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (XmlRpcException e)
		{
			e.printStackTrace();
		}
		
		
		return result;
	}
}
