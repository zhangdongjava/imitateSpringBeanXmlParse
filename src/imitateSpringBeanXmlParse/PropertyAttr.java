package imitateSpringBeanXmlParse;

import imitateSpringBeanXmlParse.val.AttrValue;

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

	public void setValObj(AttrValue valObj) {
		this.valObj = valObj;
	}

	@Override
	public String toString() {
		return "PropertyAttr [name=" + name + ", valObj=" + valObj + "]";
	}
	
	

}
