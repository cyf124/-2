package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BaseDao {
	private static final String URL = "jdbc:mysql://localhost:3306/school?useUnicode=true&amp;characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASS = "111111";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {

		}
		return conn;
	}

	public static void closeConnection(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



