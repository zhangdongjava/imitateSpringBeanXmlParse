package imitateSpringBeanXmlParse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocumentReader {
	private BeanApplication register;
	
	public void register(Document document,BeanApplication application){
		this.register = application;
		BeanParserDelegate delegate = new BeanParserDelegate();
		NodeList roots = document.getChildNodes();
		for (int i=0;i<roots.getLength();i++) {
			Node root =  roots.item(i);
			parseBeans(root,delegate);
		}
		
	}

	private void parseBeans(Node root, BeanParserDelegate delegate) {
		NodeList childs = root.getChildNodes();
		for (int i=0;i<childs.getLength();i++) {
			Node node =  childs.item(i);
			if(node instanceof Element){
				BeanDefinitionHolder bean = delegate.getBeanDefiniton((Element)node);
				register.register(bean.getName(), bean.getBeanDefinition());
			}
			
		}
	}
	
	

}
