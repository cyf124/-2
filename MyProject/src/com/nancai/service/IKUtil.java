package com.nancai.service;

import java.io.IOException;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


import com.dao.BaseDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nancai.bean.Course;
import com.nancai.bean.Major;
import com.nancai.bean.School;
import com.tool.SegmentTool;

public class IKUtil {

	public static Map getIKMap(String sid, String type) throws IOException {
		String content = null;
		Connection conn = (Connection) BaseDao.getConnection();
		String sql1 = "SELECT * FROM  "+ type + " where " + type + "_id = '" + sid + "'";
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		try {
			pstmt1 = (PreparedStatement) conn.prepareStatement(sql1);	
			rs1 = pstmt1.executeQuery();
		} catch (Exception  e) {
			e.printStackTrace();
		}
		School school = new School();
		Major major = new Major();
		Course course = new Course();
		try {
			while(rs1.next()) {
				if ("school".equals(type)) {
					school.setName(rs1.getString("name"));
					school.setDesc(rs1.getString("desc"));
				} else if ("major".equals(type)) {
					major.setName(rs1.getString("name"));
					major.setDesc(rs1.getString("desc"));
				}
				else{
					course.setName(rs1.getString("name"));
					course.setDesc(rs1.getString("desc"));
				}
				content = rs1.getString("desc");
							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (content == null) {
			return null;
			
		}
		StringReader read = new StringReader(content); 
		return SegmentTool.getTextDef(read);
	}
}
