package imitateSpringBeanXmlParse;

public class Test {
	
	public static void main(String[] args) {
		BeanApplication application = new BeanApplication("test.xml");
		System.out.println(application.getBean("test"));
	}

}
