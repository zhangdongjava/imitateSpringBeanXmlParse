package imitateSpringBeanXmlParse;

import java.util.LinkedList;
import java.util.List;

public class BeanDefinition {
	
	private  Object object;

	private String className;
	
	private List<PropertyAttr> perproties = new LinkedList<>();

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void addProperValue(PropertyAttr property){
		perproties.add(property);
	}

	@Override
	public String toString() {
		return "BeanDefinition [object=" + object + ", className=" + className + ", perproties=" + perproties + "]";
	}

	public List<PropertyAttr> getPerproties() {
		return perproties;
	}
	
	
}
