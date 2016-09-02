package com.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.School;
import com.dao.SchoolDao;
import com.jdbc.DataBaseConnection;

public class SchoolDaoimpl implements SchoolDao{

	private DataBaseConnection dataBaseConnection;
	private PreparedStatement pstmt	= null ;
	private ResultSet rs=null;
	
	public int addSchool(School school) {
		// TODO Auto-generated method stub
		int i=0;
		dataBaseConnection=new DataBaseConnection();
		String sql = "insert into school(university,department,major) values(?,?,?)";
		try {
			pstmt =dataBaseConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, school.getUniversity());
			pstmt.setString(2, school.getDepartment());
			pstmt.setString(3, school.getMajor());
			pstmt.executeUpdate();
			pstmt.close();
			dataBaseConnection.close();
			i=1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("增加学校失败");
		}
		
		return i;
	}

	public List getSchoolDetail() {      //获取这些学校的list，为后面做动态做准备
		// TODO Auto-generated method stub
		dataBaseConnection=new DataBaseConnection();
		List all = new ArrayList() ;
		String sql="select * from school";
		try {
			pstmt=dataBaseConnection.getConnection().prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				School school = new School();
				school.setUniversity(rs.getString("university"));
				school.setDepartment(rs.getString("department"));
				school.setMajor(rs.getString("major"));
				all.add(school) ;
			}
			rs.close();
			pstmt.close();
			dataBaseConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return all;
	}

}
