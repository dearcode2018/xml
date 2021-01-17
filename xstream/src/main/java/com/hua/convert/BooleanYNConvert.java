/**
  * @filename BooleanYNConvert.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;


/**
 * @type BooleanYNConvert
 * @description 布尔 Y/N 转换器
 * @author qianye.zheng
 */
public class BooleanYNConvert extends AbstractSingleValueConverter {
    
    // true-Y, false-N
    private static final String[] FORMAT = {"Y", "N"};
 
    /**
     * @description 
     * @param type
     * @return
     * @author qianye.zheng
     */
    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
        return boolean.class == type || Boolean.class == type;
    }
    
    /**
     * @description 
     * @param str
     * @return
     * @author qianye.zheng
     */
    @Override
    public Object fromString(String str) {
        if (FORMAT[0].equals(str)) {
            return true;
        }
        return false;
    }
    
    /**
     * @description 
     * @return
     * @author qianye.zheng
     */
    @Override
    public String toString(final Object obj) {
        final boolean flag = (boolean) obj;
        return flag ? FORMAT[0] : FORMAT[1];
    }
}
