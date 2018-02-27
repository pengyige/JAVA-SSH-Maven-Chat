package cn.pengyi.utils;

import java.lang.reflect.Field;
import java.util.Map;

public class BeanToMap {
	public static void transformBeanToMap(Object object,Map<String, Object>map) 
	        throws IllegalArgumentException, IllegalAccessException {
	        //1.获取该对象的所有域对象
			Field[] declaredFields = object.getClass().getDeclaredFields();
	       
			//2.遍历域对象
			for(Field field:declaredFields){
				//2.1允许访蚊
	            field.setAccessible(true);
	            Object value = field.get(object);
	            map.put(field.getName(), value);
	        }
	    }
}
