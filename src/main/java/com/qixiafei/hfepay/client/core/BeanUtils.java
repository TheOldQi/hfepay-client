package com.qixiafei.hfepay.client.core;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <P>Description: 和Java类相关的工具类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/7/11</P>
 * <P>UPDATE DATE: 2017/7/11</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.7.0
 */
final class BeanUtils {

    /**
     * 不允许实例化.
     */
    private BeanUtils() {

    }

    /**
     * 利用反射将javaBean转换成HashMap.
     *
     * @param obj 要转换的对象
     * @return 对象对应的map，key是字段名，value是字段值
     * @throws IllegalAccessException 反射可能抛出的访问权限异常
     */
    public static Map<String, Object> beanToMap(Object obj) throws IllegalAccessException {
        try {
            return beanToMap(obj, null);
        } catch (InstantiationException e) {
            // 这块不可能抛出这个异常
            throw new RuntimeException("不可能被抛出的异常");
        }
    }

    /**
     * 利用反射将javaBean转换成Map.
     *
     * @param obj     要转换的对象
     * @param mapImpl map的具体实现，比如TreeMap,LinkedMap等，可以传递空
     * @return 对象对应的map，key是字段名，value是字段值
     * @throws IllegalAccessException 反射可能抛出的访问权限异常
     * @throws InstantiationException 按照mapImpl类型实例化时出错
     */
    public static <T extends Map> Map<String, Object> beanToMap(Object obj, Class<T> mapImpl) throws
            IllegalAccessException, InstantiationException {
        if (obj == null) {
            return null;
        }
        // 遍历获得类本身及继承的所有字段信息.
        final List<Field> fieldList = new ArrayList<>();
        Class tempClass = obj.getClass();
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
        }

        final Map<String, Object> result;
        if (mapImpl == null) {
            result = new HashMap<>(fieldList.size() << 1);
        } else {
            result = mapImpl.newInstance();
        }
        for (Field f : fieldList) {
            f.setAccessible(true);
            result.put(f.getName(), f.get(obj));
        }
        return result;
    }

}
