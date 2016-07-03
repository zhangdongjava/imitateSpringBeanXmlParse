package imitateSpringBeanXmlParse.val;

public class EntryVal implements AttrValue {

	private AttrValue attrValue;

	public EntryVal(AttrValue attrValue) {
		this.attrValue = attrValue;
	}

	@Override
	public Object getVal() {
		return attrValue.getVal();
	}

}
