/**
 * BillingAddress.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.bean.xml;

/**
 * 
 * BillingAddress
 * 描述: 订单地址
 * @author  qye.zheng
 * 
 */
public class BillingAddress extends BaseAddress
{
	// 接收人
	private String receiver;

	/**
	 * @return the receiver
	 */
	public String getReceiver()
	{
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver)
	{
		this.receiver = receiver;
	}
	
}