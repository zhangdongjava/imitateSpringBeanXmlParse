package imitateSpringBeanXmlParse.val;

public class GenericAttrValue implements AttrValue {

	private String value;
	
	public GenericAttrValue(String value){
		this.value = value;
	}

	@Override
	public Object getVal() {
		return value;
	}

	@Override
	public String toString() {
		return "GenericAttrValue [value=" + value + "]";
	}
	
	

}
