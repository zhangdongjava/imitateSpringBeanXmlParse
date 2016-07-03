package imitateSpringBeanXmlParse;

public class BeanDefinitionHolder {

	public String name;
	
	public BeanDefinition beanDefinition;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BeanDefinition getBeanDefinition() {
		return beanDefinition;
	}
	public void setBeanDefinition(BeanDefinition beanDefinition) {
		this.beanDefinition = beanDefinition;
	}



}
