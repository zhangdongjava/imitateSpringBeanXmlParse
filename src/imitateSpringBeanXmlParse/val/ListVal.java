package imitateSpringBeanXmlParse.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListVal implements AttrValue {

	private List<AttrValue> values = new LinkedList<>();

	@Override
	public Object getVal() {
		List<Object> list = new ArrayList<>();
		for (AttrValue object : values) {
			list.add(object.getVal());
		}
		return list;
	}

	public void addValues(AttrValue ... attrValues ){
		values.addAll(Arrays.asList(attrValues));
	}

}
