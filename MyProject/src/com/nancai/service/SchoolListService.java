package com.nancai.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dao.BaseDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nancai.bean.Course;
import com.nancai.bean.Major;
import com.nancai.bean.School;
import com.nancai.bean.SchoolList;

public class SchoolListService {
	
	/**
	 * 从数据库中取数据，然后转为SchoolList类并返回到servlet
	 * @return
	 */
	
/*	public static SchoolList getSchoolList(){
		SchoolList schoolList = new SchoolList();
		
		schoolList.setName("南京的大学学府");
		List<School> schools = new ArrayList<School>();
		for(int i = 0;i < 3; ++i) {
			School school = new School();
			
			school.setName("南京第" + i + "所大学");
			List<Major> majors = new ArrayList<Major>();
			for(int j = 0; j < 2; ++j){
				Major major = new Major();
				
				major.setName("南京第" + i + "所大学的第" + j + "个专业");
				List<Course> courses = new ArrayList<Course>();
				for(int k = 0; k < 4; ++k){
					Course course = new Course();
					
					course.setName("第" + j + "个专业的第" + k + "个课程");
					course.setSize(Math.abs(new Random().nextInt() % 1000));	//设置一个0~1000的随机数
					
					courses.add(course);
				}
				major.setCourseList(courses);
				
				majors.add(major);
			}
			school.setMajorList(majors);
			
			schools.add(school);
		}
		schoolList.setChildren(schools);
		
		return schoolList;
	}*/
	

	public static SchoolList getSchoolList(){
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
			conn = (Connection) BaseDao.getConnection();
			String sql1 = "SELECT * FROM  school ";
			try {
				pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);			
				rs1 =  pstmt1.executeQuery();
				
				
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		SchoolList schoolList = new SchoolList();
		
		schoolList.setName("南京的大学学府");
		List<School> schools = new ArrayList<School>();
		try {
			while(rs1.next()){

				School school = new School();	
				int someSchoolId = rs1.getInt("school_id");
				school.setId(String.valueOf(someSchoolId));
				school.setName(rs1.getString("name"));	
				school.setType("school");
				
				List<Major> majors = new ArrayList<Major>();	
				String sql2 ="select * from major where school_id="+ someSchoolId;
				pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
				rs2 =  pstmt2.executeQuery();
				
				while(rs2.next()){					
					Major major = new Major();
					int someMajorId = rs2.getInt("major_id");
					major.setId(String.valueOf(someMajorId));
					major.setType("major");
					major.setName(rs2.getString("name"));
					List<Course> courses = new ArrayList<Course>();
					String sql3 ="select * from course where major_id="+ someMajorId;
					
					pstmt3 = (PreparedStatement) conn.prepareStatement(sql3);
					rs3=  pstmt3.executeQuery();
					
					while(rs3.next()){
						Course course = new Course();
						course.setId(String.valueOf(rs3.getInt("course_id")));
						course.setType("course");
						course.setName(rs3.getString("name"));
						course.setSize(Math.abs(new Random().nextInt() % 1000));	//设置一个0~1000的随机数
						
						courses.add(course);
					}
					major.setCourseList(courses);
					
					majors.add(major);
				}
				school.setMajorList(majors);
				
				schools.add(school);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schoolList.setChildren(schools);
		return schoolList;
		

	}

}
