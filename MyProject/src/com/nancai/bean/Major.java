package com.nancai.bean;

import java.util.List;

public class Major {
	String id;
	String type;
	String name;
	String desc;
	List<Course> courseList;
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
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		StringBuilder courses = new StringBuilder("");
		if(courseList != null && courseList.size() > 0){
			courses.append(",\"children\": [");
			for(int i = 0; i < courseList.size(); ++i){
				if(i != 0){
					courses.append(",");
				}
				courses.append(courseList.get(i).toString());
			}
			courses.append("]");
		}
		return "{\"name\":\"" + name + "\","
				+ "\"type\":\"" + type + "\"," 
				+ "\"id\":\"" + id + "\""
				+ courses.toString() + "}";
	}
	
}
