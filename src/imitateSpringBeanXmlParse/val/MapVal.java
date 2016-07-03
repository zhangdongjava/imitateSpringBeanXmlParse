package imitateSpringBeanXmlParse.val;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapVal implements AttrValue {

	public HashMap<String, AttrValue> hashMap = new HashMap<>();
	
	@Override
	public Object getVal() {
		HashMap<String, Object> values = new HashMap<>();
		Set<Entry<String, AttrValue>> entrys = hashMap.entrySet();
		for (Entry<String, AttrValue> entry : entrys) {
			values.put(entry.getKey(), entry.getValue().getVal());
		}
		return values;
	}
	
	public void addVal(String key,AttrValue val){
		hashMap.put(key, val);
	}

}
