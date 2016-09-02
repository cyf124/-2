package com.nancai.bean;

import java.util.List;

public class SchoolList {
	String name;
	List<School> children;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<School> getChildren() {
		return children;
	}
	public void setChildren(List<School> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		StringBuilder schools = new StringBuilder("");
		if(children != null && children.size() > 0){
			schools.append(",\"children\": [");
			for(int i = 0; i < children.size(); ++i){
				if(i != 0){
					schools.append(",");
				}
				schools.append(children.get(i).toString());
			}
			schools.append("]");
		}
		return "{\"name\":\"" + name + "\"" + schools.toString() + "}";
	}
	
}
