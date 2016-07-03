package imitateSpringBeanXmlParse;

import org.w3c.dom.Document;

public class XmlBeanDefinitonReader {
	private BeanApplication application;
	
	public XmlBeanDefinitonReader(BeanApplication application){
		this.application = application;
	}
	
	public void loadBeanDefinitons(FileResource fileResource){
		DocumentLoader loader = new DocumentLoader();
		Document doc = loader.buildDocument(fileResource);
		DocumentReader documentReader = new DocumentReader();
		documentReader.register(doc, application);
	}

}
