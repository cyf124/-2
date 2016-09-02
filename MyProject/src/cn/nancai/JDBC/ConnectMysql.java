package cn.nancai.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class ConnectMysql {
	private static DataSource ds = null;
	private static Connection conn = null;

	public static Connection getConn_jdbc() {
		try {
			String url = "jdbc:mysql://localhost:3306/school";
			String username = "root";
			String password = "111111";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			System.err.println("数据库连接异常: " + e.getMessage());
			return null;
		}
	}


	public static void main(String[] a) {
		Connection conn;
		ConnectMysql dc = new ConnectMysql();
		conn = dc.getConn_jdbc();
		try {
			Statement stmt = conn.createStatement();
			String strSql = "select * from user";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				System.out.println("标题：" + rs.getString("role"));
			}
		} catch (SQLException e) {

		}

	}
}
