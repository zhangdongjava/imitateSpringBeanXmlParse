package imitateSpringBeanXmlParse;

import imitateSpringBeanXmlParse.val.AttrValue;

/**
 * property对象
 * @author zzzz
 *
 */
public class PropertyAttr {
	
	private String name;
	
	private AttrValue valObj;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AttrValue getValObj() {
		return valObj;
	}
	
	public Object getVal() {
		if(valObj==null){
			return null;
		}
		return valObj.getVal();
	}

	public void setValObj(AttrValue valObj) {
		this.valObj = valObj;
	}

	@Override
	public String toString() {
		return "PropertyAttr [name=" + name + ", valObj=" + valObj + "]";
	}
	
	

}
