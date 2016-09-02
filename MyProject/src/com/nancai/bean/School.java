package com.nancai.bean;

import java.util.List;
import java.util.Map;


public class School {
	String id;
	String name;
	String type;
	String desc;
	List<Major> majorList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	@Override
	public String toString() {
		StringBuilder majors = new StringBuilder("");
		if(majorList != null && majorList.size() > 0){
			majors.append(",\"children\": [");
			for(int i = 0; i < majorList.size(); ++i){
				if(i != 0){
					majors.append(",");
				}
				majors.append(majorList.get(i).toString());
			}
			majors.append("]");
		}
		return "{\"name\":\"" + name + "\"," 
				+ "\"type\":\"" + type + "\"," 
				+ "\"id\":\"" + id + "\""
				+ majors.toString() + "}";
	}
	
	

}
