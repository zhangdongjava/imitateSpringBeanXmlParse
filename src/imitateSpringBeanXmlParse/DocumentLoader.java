package imitateSpringBeanXmlParse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DocumentLoader {

	public Document buildDocument(FileResource fileResource){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();      
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Document doc = null;
		try {
			doc = db.parse(fileResource.getInputStream());
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}
	
	

}
