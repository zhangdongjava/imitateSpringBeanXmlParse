package imitateSpringBeanXmlParse;

import java.lang.reflect.Method;

public class ReflectUtil {
	
	public static Method getSetMethodByName(Object object,String fieldName){
		Method[] methods = object.getClass().getDeclaredMethods();
		String upMethod = ("set"+fieldName).toUpperCase();
		for (Method method2 : methods) {
			if(method2.getName().toUpperCase().equals(upMethod)){
				return method2;
			}
			
		}
		return null;
	}

}
