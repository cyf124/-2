package com.dao;

import java.util.List;

import com.bean.School;

public interface SchoolDao {

	public List getSchoolDetail();
	public int addSchool(School school);
}
