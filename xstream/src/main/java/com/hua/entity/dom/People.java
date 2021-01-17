/**
 * People.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity.dom;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述: 
 * @author qye.zheng
 * People
 * 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public final class People extends BaseTag {
	
	private static final long serialVersionUID = 1L;
	
    private Address address;
    
}
