/**
 * 描述: 
 * BaseController.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * BaseController
 */
//@Controller
public abstract class BaseController {
	
	/* apache commons log */
    protected final Logger log = LogManager.getLogger(this.getClass().getName());
	
	
}
