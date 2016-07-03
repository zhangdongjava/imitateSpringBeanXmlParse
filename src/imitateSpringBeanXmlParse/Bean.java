package imitateSpringBeanXmlParse;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Bean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Map<String, String>> lists;
	
	private String aaa;

	public List<Map<String, String>> getLists() {
		return lists;
	}

	public void setLists(List<Map<String, String>> lists) {
		this.lists = lists;
	}
	
	public void test(){
		System.out.println("test");
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	@Override
	public String toString() {
		return "Bean [lists=" + lists + ", aaa=" + aaa + "]";
	}

	
	
}
