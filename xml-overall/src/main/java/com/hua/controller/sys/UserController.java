/**
  * @filename UserController.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.controller.sys;

import javax.validation.Valid;

import com.hua.bean.ResultBean;
import com.hua.bean.User;
import com.hua.controller.BaseController;

 /**
 * @type UserController
 * @description  
 * @author qye.zheng
 */

public final class UserController extends BaseController
{
	
	/**
	 * 
	 * @description 
	 * @param user
	 * @return
	 * @author qianye.zheng
	 */
	public final ResultBean insert(@Valid final User user)
	{
		log.info("login =====> enter ...");
		
		return null;
	}	


}
