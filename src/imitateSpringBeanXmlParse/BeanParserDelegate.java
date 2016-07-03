package imitateSpringBeanXmlParse;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import imitateSpringBeanXmlParse.val.AttrValue;
import imitateSpringBeanXmlParse.val.EntryVal;
import imitateSpringBeanXmlParse.val.GenericAttrValue;
import imitateSpringBeanXmlParse.val.ListVal;
import imitateSpringBeanXmlParse.val.MapVal;

public class BeanParserDelegate {

	private static final String PROPERTY_NAME = "property";
	private static final String LIST_NAME = "list";
	private static final String MAP_NAME = "map";
	private static final String VALUE_NAME = "value";
	private static final String ENTRY_NAME = "entry";
	public BeanDefinitionHolder getBeanDefiniton(Element element) {
		BeanDefinitionHolder holder = new BeanDefinitionHolder();
		BeanDefinition definition = new BeanDefinition();
		String className =  element.getAttribute("class");
		if(className==null || className.trim().equals("")){
			throw new RuntimeException("class not empty" +element );
		}
		String name = element.getAttribute("name");
		if(name==null || name.trim().equals("")){
			name = className+"#0";
		}
		definition.setClassName(className);
		holder.setName(name);
		holder.setObj(definition);
		setBeanDefinitionHolder(definition,element);
		return holder;
	}

	private void setBeanDefinitionHolder(BeanDefinition definition, Element element) {
		parsePropertyElements(element,definition);
	}

	private void parsePropertyElements(Element element, BeanDefinition definition){
		NodeList childs = element.getChildNodes();
		for (int i=0;i<childs.getLength();i++) {
			Node node =  childs.item(i);
			if(node instanceof Element && node.getNodeName().equals(PROPERTY_NAME)){
				parsePropertyElement((Element)node,definition);
			}

		}
	}

	private void parsePropertyElement(Element element, BeanDefinition definition) {
		PropertyAttr propertyAttr = new PropertyAttr();
		propertyAttr.setName(element.getAttribute("name"));
		AttrValue val = getPropertyVal(element);
		propertyAttr.setValObj(val);
		definition.addProperValue(propertyAttr);
	}

	private AttrValue getPropertyVal(Element element) {
		if(element.hasAttribute("value")){
			return new GenericAttrValue(element.getAttribute("value"));
		}else{
			return parsePropertySubElement(element);
		}
	}
	
	/**
	 * 解析Property元素子标签
	 * @param element
	 * @return
	 */
	private AttrValue parsePropertySubElement(Element element) {
		int index = 0;
		NodeList childs = element.getChildNodes();
		Node node =  childs.item(index);
		while(!(node instanceof Element)){
			index++;
			node =  childs.item(index);
		}
		return parseElement((Element)node);
	}
	
	/**
	 * 解析元素标签
	 * @param node
	 * @return
	 */
	private AttrValue parseElement(Element node){
		if(node.getNodeName().equals(LIST_NAME)){
			return parseListElement((Element)node);
		}else if(node.getNodeName().equals(MAP_NAME)){
			return parseMapElement((Element)node);
		}else if(node.getNodeName().equals(VALUE_NAME)){
			String value = node.getTextContent();
			return new GenericAttrValue(value);
		}
		return new GenericAttrValue(null);
	}
	
	/**
	 * 解析map标签
	 * @param element
	 * @return
	 */
	private AttrValue parseMapElement(Element element) {
		MapVal mapVal = new MapVal();
		NodeList childs = element.getChildNodes();
		for (int i=0;i<childs.getLength();i++) {
			Node node =  childs.item(i);
			if(node instanceof Element && node.getNodeName().equals(ENTRY_NAME)){
				Element el = (Element)node;
				AttrValue	val = parseEntryElement(el);
				mapVal.addVal(el.getAttribute("key"), val);
			}

		}
		return mapVal;
	}
	
	/**
	 * 解析map标签
	 * @param element
	 * @return
	 */
	private AttrValue parseEntryElement(Element element) {
		AttrValue value = null;
		value = parsePropertySubElement(element);
		return new EntryVal(value);
	}
	
	
	/**
	 * 解析list标签
	 * @param element
	 * @return
	 */
	private AttrValue parseListElement(Element element) {
		ListVal listVal = new ListVal();
		NodeList childs = element.getChildNodes();
		for (int i=0;i<childs.getLength();i++) {
			Node node =  childs.item(i);
			if(node instanceof Element){
				Element el = (Element)node;
				listVal.addValues(parseElement(el));
			}

		}
		return listVal;
	}





}
