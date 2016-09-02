package com.nancai.bean;


public class Course {
	String id;
	String type;
	String name;
	String desc;
	int size;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(",\"children\": [");
//		for(int i = 0; i < courseList.size(); ++i){
//			if(i != 0){
//				sb.append(",");
//			}
//			sb.append(courseList.get(i).toString());
//		}
		sb.append("]");
		return "{\"name\":\"" + name + "\","
				+ "\"type\":\"" + type + "\"," 
				+ "\"id\":\"" + id + "\","
				+ "\"size\":" + size + ""
				+ sb.toString() + "}";
	}
	
}
