package com.json;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.bean.School;
//import com.entity.Detail;
import  com.dao.BaseDao;
public class JsonTest {
	
	
	public static void main(String[] args){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = (Connection) BaseDao.getConnection();
			String sql = "SELECT * FROM  school1 ";
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			School school = null;
			List<School> list = new ArrayList<School>();
			while(rs.next()){
				school = new School();
				school.setUniversity(rs.getString("university"));				
				school.setDepartment(rs.getString("department"));
				school.setMajor(rs.getString("major"));
				
				//school.setHometown(rs.getString("hometown"));
				//school.setLocation(rs.getString("location"));
				//school.setPhone(rs.getString("phone"));
				//school.setSchool(rs.getString("school"));
				//school.setSex(rs.getString("sex"));
				list.add(school);
				
			}
			
			Gson gson = new Gson();
			String result = gson.toJson(list);
			FileWriter fw = new FileWriter("E:\\MyProject\\MyProject\\WebRoot\\DataDrivenSystem\\school\\test.json");
			fw.write(result);
			fw.flush();
			
		System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
