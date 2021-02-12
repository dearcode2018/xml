/**
  * @filename FieldConvertEngine.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.convert;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.hua.annotation.FieldConvert;
import com.hua.util.EmptyUtil;
import com.hua.util.JacksonUtil;
import com.hua.util.StringUtil;

/**
 * @type FieldConvertEngine
 * @description 字段转换引擎
 * @author qianye.zheng
 */
@SuppressWarnings({"unchecked"})
public final class FieldConvertEngine {
    
    private FieldConvertEngine() {}
    
    /**
     * 
     * @description 序列化
     * @param <T>
     * @param clazz
     * @param target
     * @return
     * @author qianye.zheng
     */
    public static final <T> String serialize(final Class<T> clazz, final T target) {
        return JacksonUtil.writeAsString(getValue(clazz, target));
    }
    
    /**
     * 
     * @description 
     * @param clazz
     * @param target
     * @return
     * @author qianye.zheng
     */
    private static final Map<String, Object> getValue(final Class<?> clazz, final Object target) {
        final Field[] fields = clazz.getDeclaredFields();
        final Map<String, Object> map = new HashMap<>(fields.length);
        String name = null;
        for (Field field : fields) {
            try {
            field.setAccessible(true);
            final FieldConvert convert = field.getDeclaredAnnotation(FieldConvert.class);
            if (null == convert) { // 不使用转换器，直接设置
                map.put(field.getName(), field.get(target));
                continue;
            }
            name = StringUtil.isNotEmpty(convert.aliase()) ? convert.aliase() : field.getName();
            switch (convert.strategy()) {
                case CAMLE: // 驼峰
                    name = toUnderline(field.getName());
                    map.put(name, setValue(convert, field.get(target)));
                    break;
                    
                case ALIASE: // 别名
                    name = convert.aliase();
                    map.put(name, setValue(convert, field.get(target)));
                    break;
                    
                case AGGREGATE: // 聚合
                    final List<Object> list = (List<Object>) field.get(target);
                    int i = convert.start();
                    for (Object e : list) {
                        map.put(convert.prefix() + i, e);
                        i++;
                    }
                    break;
                    
                case OBJECT: // 对象
                    map.put(name, getValue(field.getType(), field.get(target)));
                    break;
                    
                case OBJECTS: // 对象列表
                    final List<Object> objs = (List<Object>) field.get(target);
                    if (EmptyUtil.isEmpty(objs)) {
                        continue;
                    }
                    final List<Object> resultObjs = Lists.newArrayListWithCapacity(objs.size());
                    map.put(name, resultObjs);
                    final Type type = field.getGenericType();
                    if (type instanceof ParameterizedType) {
                        final ParameterizedType parameterizedType = (ParameterizedType) type;
                        final Class<?> subClazz = Class.forName(parameterizedType.getActualTypeArguments()[0].getTypeName());
                        for (Object e : objs) {
                            resultObjs.add(getValue(subClazz, e));
                        }
                    }
                    break;
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return map;
    }
    
    
    /**
     * 
     * @description 
     * @param convert
     * @param value
     * @return
     * @author qianye.zheng
     */
    private static final Object setValue(final FieldConvert convert, final Object value) {
        if (convert.bool() && convert.bools().length > 0) {
            return Boolean.valueOf(value.toString()).booleanValue() ? convert.bools()[0] : convert.bools()[1];
        }
        return value;
    }
    
    /**
     * 
     * @description 驼峰格式转成下划线格式
     * @param camel
     * @return
     * @author qianye.zheng
     */
    private static final String toUnderline(final String camel) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, camel);
    }
    
}
