package imitateSpringBeanXmlParse;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class BeanApplication {
	
	private HashMap<String, BeanDefinition> beanDefinitonMap = new HashMap<>();
	
	public BeanApplication(String filePath){
		ResourceLoader loader = new ResourceLoader();
		new XmlBeanDefinitonReader(this).loadBeanDefinitons(loader.getResource(filePath));
	}

	public void register(String name,BeanDefinition object){
		beanDefinitonMap.put(name, object);
	}
	
	public Object getBean(String name){
		Object obj = null;
		BeanDefinition beanDefiniton = beanDefinitonMap.get(name);
		if(beanDefiniton==null){
			return null;
		}
		try {
			obj = this.getClass().getClassLoader().loadClass(beanDefiniton.getClassName()).newInstance();
			setProperties(obj,beanDefiniton);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}

	private void setProperties(Object obj, BeanDefinition beanDefiniton) {
		List<PropertyAttr> poprts = beanDefiniton.getPerproties();
		for (PropertyAttr propertyAttr : poprts) {
			try {
				Method method = ReflectUtil.getSetMethodByName(obj, propertyAttr.getName());
				if(method==null){
					throw new RuntimeException(propertyAttr.getName()+" not found seter method!");
				}
				try {
					method.invoke(obj, propertyAttr.getValObj().getVal());
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
}
