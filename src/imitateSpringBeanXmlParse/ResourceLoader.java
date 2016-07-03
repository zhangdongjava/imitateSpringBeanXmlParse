package imitateSpringBeanXmlParse;

public class ResourceLoader {

	public  FileResource getResource(String filePath) {
		return new SystemFileResource(filePath);
	}
	
	

}
