/**
  * @filename CdataConvert.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;


/**
 * @type CdataConvert
 * @description CDATA 转换器
 * @author qianye.zheng
 */
public class CdataConvert extends AbstractSingleValueConverter {
    
    private static final String[] CDATA = {"<![CDATA[", "]]>"};
 
    /**
     * @description 
     * @param type
     * @return
     * @author qianye.zheng
     */
    @SuppressWarnings({ "rawtypes"})
    @Override
    public boolean canConvert(Class type) {
        return CharSequence.class.isAssignableFrom(type);
    }
    
    /**
     * @description 
     * @param str
     * @return
     * @author qianye.zheng
     */
    @Override
    public Object fromString(String str) {
        // 去掉 <![CDATA[]]>
        if (str.startsWith(CDATA[0])) {
            str = str.substring(CDATA[0].length(), str.lastIndexOf(CDATA[1]));
        }
        return str;
    }
    
    /**
     * @description 
     * @return
     * @author qianye.zheng
     */
    @Override
    public String toString(final Object obj) {
        return CDATA[0] + obj + CDATA[1];
    }
}
