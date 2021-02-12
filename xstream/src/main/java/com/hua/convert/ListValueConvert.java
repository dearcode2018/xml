/**
  * @filename BooleanYNConvert.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import java.util.List;

import com.hua.constant.ConvertConstant;
import com.hua.entity.ListValueType;
import com.hua.util.StringUtil;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;


/**
 * @type ListValueConvert
 * @description 列表转换器
 * @author qianye.zheng
 */
public class ListValueConvert extends AbstractSingleValueConverter {
    
    private static final int START_INDEX = 1;
 
    /**
     * @description 
     * @param type
     * @return
     * @author qianye.zheng
     */
    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
        return ListValueType.class == type;
    }
    
    /**
     * @description 
     * @param str
     * @return
     * @author qianye.zheng
     */
    @Override
    public Object fromString(String str) {
       throw new UnsupportedOperationException();
    }
    
    /**
     * @description 
     * @return
     * @author qianye.zheng
     */
    @Override
    public String toString(final Object obj) {
    	final StringBuilder builder = StringUtil.getBuilder();
    	if (obj instanceof ListValueType) {
    		final ListValueType valueType = ((ListValueType) obj);
			final List<Object> values = valueType.getValues();
    		int index = START_INDEX;
    		for (Object value : values) {
    			builder.append(ConvertConstant.LESS_THAN_SIGN);
    			builder.append(valueType.getTag() + index);
    			builder.append(ConvertConstant.GREATER_THAN_SIGN);
    			builder.append(value.toString());
    			builder.append(ConvertConstant.LESS_THAN_SIGN);
    			builder.append(ConvertConstant.SLASH);
    			builder.append(valueType.getTag()+ index);
    			builder.append(ConvertConstant.GREATER_THAN_SIGN);
    			index++;
    		}
    	}
    	
    	return builder.toString();
    }
}
