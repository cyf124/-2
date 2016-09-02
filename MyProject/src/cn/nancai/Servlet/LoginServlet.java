package cn.nancai.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.util.Password;

import cn.nancai.JDBC.ConnectMysql;

public class LoginServlet extends HttpServlet {
   
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		Connection conn= ConnectMysql.getConn_jdbc();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		try {
		Statement stmt = conn.createStatement();
			String strSql = "select * from user where username='"+userName+"'";
			ResultSet rs = stmt.executeQuery(strSql);
		if(rs.next()) {
				if(password.equals(rs.getString("password"))){
					if(rs.getString("role").equals("管理员")){
					request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request, response);
					}
					else{
					request.getRequestDispatcher("WEB-INF/test.html").forward(request, response);
					}
				}
				else{
					request.setAttribute("message", "-1");
 				    request.setAttribute("username", userName);
					request.setAttribute("password", password);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
		}
			else{
				request.setAttribute("message", "-2");
				request.setAttribute("username", userName);
 			    request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
			}
		conn.close();
		} catch (SQLException e) {
		}
		
		 
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
