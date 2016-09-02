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

import cn.nancai.JDBC.ConnectMysql;

public class ManagerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ManagerServlet() {
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		Connection conn = ConnectMysql.getConn_jdbc();
		if(request.getParameter("method").equals("queryAll")){
		String spage=request.getParameter("spage");
		int m=(Integer.parseInt(spage)-1)*5;
		String schoolId=null;
		String majorId=null;
		try {
			int i=1;
			Statement stmt1 =conn.createStatement();
			String sql1="SELECT * FROM school limit "+m+",5";
			ResultSet rs1=stmt1.executeQuery(sql1);
			while(rs1.next()){
				request.setAttribute("schoolN"+i, rs1.getString("name"));
				request.setAttribute("sId"+i, rs1.getString(1));
				i++;
			}
			if(rs1.first()){
				schoolId=rs1.getString(1);
				request.setAttribute("nsId", rs1.getString(1));
				
			}
			request.setAttribute("spage", spage);
			//查大学
			
			int j=1;
			Statement stmt2 =conn.createStatement();
			String sql2="SELECT * FROM MAJOR WHERE SCHOOL_ID='"+schoolId+"' limit 0,5";
			ResultSet rs2=stmt2.executeQuery(sql2);
			while(rs2.next()){
				request.setAttribute("majorN"+j, rs2.getString("name"));
				request.setAttribute("mId"+j, rs2.getString(1));
				j++;
			}
			if(rs2.first()){
				majorId=rs2.getString(1);
				request.setAttribute("nmId", rs2.getString(1));
				
			}
			request.setAttribute("mpage", "1");
			//查专业
			
			int k=1;
			Statement stmt3 =conn.createStatement();
			String sql3="SELECT * FROM COURSE WHERE MAJOR_ID='"+majorId+"' limit 0,5";
			ResultSet rs3=stmt3.executeQuery(sql3);
			while(rs3.next()){
				request.setAttribute("courseN"+k, rs3.getString("name"));
				request.setAttribute("cId"+k, rs3.getString(1));
				k++;
			}
			if(rs3.first()){
				request.setAttribute("ncId", rs3.getString(1));
				
			}
			request.setAttribute("cpage", "1");
		} catch (Exception e) {
			
		}
		request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
		request.setAttribute("mAllPages", (getAllRows("major",schoolId)-1)/5+1);
		request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		if(request.getParameter("method").equals("queryMajor")){
			String sId=request.getParameter("sId");
			String spage=request.getParameter("spage");
			int m=(Integer.parseInt(spage)-1)*5;
			String mpage=request.getParameter("mpage");
			int n=(Integer.parseInt(mpage)-1)*5;
			String majorId=null;
			try {
				int i=1;
				Statement stmt1 =conn.createStatement();
				String sql1="SELECT * FROM school limit "+m+",5";
				ResultSet rs1=stmt1.executeQuery(sql1);
				while(rs1.next()){
					request.setAttribute("schoolN"+i, rs1.getString("name"));
					request.setAttribute("sId"+i, rs1.getString(1));
					i++;
				}
				request.setAttribute("nsId",sId);
				request.setAttribute("spage",spage);
				//查大学
				
				int j=1;
				Statement stmt2 =conn.createStatement();
				String sql2="SELECT * FROM MAJOR WHERE SCHOOL_ID='"+sId+"' limit "+n+",5";
				ResultSet rs2=stmt2.executeQuery(sql2);
				while(rs2.next()){
					request.setAttribute("majorN"+j, rs2.getString("name"));
					request.setAttribute("mId"+j, rs2.getString(1));
					j++;
				}
				if(rs2.first()){
					majorId=rs2.getString(1);
					request.setAttribute("nmId",rs2.getString(1));
					
				}
				request.setAttribute("mpage",mpage);
				//查专业
				
				int k=1;
				Statement stmt3 =conn.createStatement();
				String sql3="SELECT * FROM COURSE WHERE MAJOR_ID='"+majorId+"' limit "+0+",5";
				ResultSet rs3=stmt3.executeQuery(sql3);
				while(rs3.next()){
					request.setAttribute("courseN"+k, rs3.getString("name"));
					request.setAttribute("cId"+k, rs3.getString(1));
					k++;
				}
				if(rs3.first()){
					majorId=rs3.getString(1);
					request.setAttribute("ncId",rs3.getString(1));
					
				}
				request.setAttribute("cpage","1");
			} catch (Exception e) {
				
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",sId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		if(request.getParameter("method").equals("queryCourse")){
			String nsId=request.getParameter("nsId");
			String mId=request.getParameter("mId");
			String spage=request.getParameter("spage");
			int m=(Integer.parseInt(spage)-1)*5;
			String mpage=request.getParameter("mpage");
			int n=(Integer.parseInt(mpage)-1)*5;
			String cpage=request.getParameter("cpage");
			int o=(Integer.parseInt(cpage)-1)*5;
			
			
			try {
				int i=1;
				Statement stmt1 =conn.createStatement();
				String sql1="SELECT * FROM school limit "+m+",5";
				ResultSet rs1=stmt1.executeQuery(sql1);
				while(rs1.next()){
					request.setAttribute("schoolN"+i, rs1.getString("name"));
					request.setAttribute("sId"+i, rs1.getString(1));
					i++;
				}
				request.setAttribute("nsId", nsId);
				request.setAttribute("spage", spage);
				
				int j=1;
				Statement stmt2 =conn.createStatement();
				String sql2="SELECT * FROM MAJOR WHERE SCHOOL_ID='"+nsId+"' limit "+n+",5";
				ResultSet rs2=stmt2.executeQuery(sql2);
				while(rs2.next()){
					request.setAttribute("majorN"+j, rs2.getString("name"));
					request.setAttribute("mId"+j, rs2.getString(1));
					j++;
				}
				request.setAttribute("nmId", mId);
				request.setAttribute("mpage", mpage);
				
				int k=1;
				Statement stmt3 =conn.createStatement();
				String sql3="SELECT * FROM COURSE WHERE MAJOR_ID='"+mId+"' limit "+o+",5";
				ResultSet rs3=stmt3.executeQuery(sql3);
				while(rs3.next()){
					request.setAttribute("courseN"+k, rs3.getString("name"));
					request.setAttribute("cId"+k, rs3.getString(1));
					k++;
				}
				request.setAttribute("cpage", cpage);
			}catch (Exception e) {
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",nsId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",mId)-1)/5+1);
		}
		if(request.getParameter("method").equals("deleteSchool")){
			String sId=request.getParameter("nsId");
			String schoolId=null;
			String majorId=null;
			try {	
				int i=1;
				int j=1;
				int k=1;
				Statement stmt1 = conn.createStatement();
				String strSql1 = "select * from major where school_id='" + sId + "'";
				ResultSet rs1=stmt1.executeQuery(strSql1);
				while(rs1.next()){
				Statement stmt2 = conn.createStatement();
				String strSql2 = "delete from course where major_id='" + rs1.getString(1) + "'";
				stmt2.executeUpdate(strSql2);
				}
				Statement stmt3 = conn.createStatement();
				String strSql3 = "delete from major where school_id='" + sId + "'";
				stmt3.executeUpdate(strSql3);
				Statement stmt4 = conn.createStatement();
				String strSql4 = "delete from school where school_id='" + sId + "'";
				stmt4.executeUpdate(strSql4);
				Statement stmt5 =conn.createStatement();
				String sql5="SELECT * FROM school limit 0,5";
				ResultSet rs5=stmt5.executeQuery(sql5);
				while(rs5.next()){
					request.setAttribute("schoolN"+i, rs5.getString("name"));
					request.setAttribute("sId"+i, rs5.getString(1));
					i++;
				}
				if(rs5.first()){
					schoolId=rs5.getString(1);
					request.setAttribute("nsId", rs5.getString(1));
				}
				request.setAttribute("spage", "1");
				
				Statement stmt6 =conn.createStatement();
				String sql6="SELECT * FROM MAJOR WHERE SCHOOL_ID='"+schoolId+"' limit 0,5";
				ResultSet rs6=stmt6.executeQuery(sql6);
				while(rs6.next()){
					request.setAttribute("majorN"+j, rs6.getString("name"));
					request.setAttribute("mId"+j, rs6.getString(1));
					j++;
				}
				if(rs6.first()){
					majorId=rs6.getString(1);
					request.setAttribute("nmId", rs6.getString(1));
				}
				request.setAttribute("mpage", "1");
				
				Statement stmt7 =conn.createStatement();
				String sql7="SELECT * FROM COURSE WHERE MAJOR_ID='"+majorId+"' limit 0,5";
				ResultSet rs7=stmt7.executeQuery(sql7);
				while(rs7.next()){
					request.setAttribute("courseN"+k, rs7.getString("name"));
					request.setAttribute("cId"+k, rs7.getString(1));
					k++;
				}
				if(rs7.first()){
					request.setAttribute("ncId", rs7.getString(1));
				}
				request.setAttribute("cpage", "1");
			}catch (Exception e) {
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",schoolId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		if(request.getParameter("method").equals("deleteMajor")){
			String sId=request.getParameter("nsId");
			String mId=request.getParameter("nmId");
			String spage=request.getParameter("spage");
			int m=(Integer.parseInt(spage)-1)*5;
			String majorId=null;
			try {
				int i=1;
				int j=1;
				int k=1;
				
				Statement stmt1 = conn.createStatement();
				String strSql1 = "delete from course where major_id='" + mId + "'";
				stmt1.executeUpdate(strSql1);
				Statement stmt2 = conn.createStatement();
				String strSql2 = "delete from major where major_id='" + mId + "'";
				stmt2.executeUpdate(strSql2);
				Statement stmt3 =conn.createStatement();
				String sql3="SELECT * FROM school limit "+m+",5";
				ResultSet rs3=stmt3.executeQuery(sql3);
				while(rs3.next()){
					request.setAttribute("schoolN"+i, rs3.getString("name"));
					request.setAttribute("sId"+i, rs3.getString(1));
					i++;
				}
				request.setAttribute("nsId", sId);
				request.setAttribute("spage", spage);
				
				Statement stmt4 =conn.createStatement();
				String sql4="SELECT * FROM MAJOR WHERE SCHOOL_ID='"+sId+"' limit 0,5";
				ResultSet rs4=stmt4.executeQuery(sql4);
				while(rs4.next()){
					request.setAttribute("majorN"+j, rs4.getString("name"));
					request.setAttribute("mId"+j, rs4.getString(1));
					j++;
				}
				if(rs4.first()){
					majorId=rs4.getString(1);
					request.setAttribute("nmId", rs4.getString(1));
				}
				request.setAttribute("mpage", "1");
				
				Statement stmt5 =conn.createStatement();
				String sql5="SELECT * FROM COURSE WHERE MAJOR_ID='"+majorId+"' limit 0,5";
				ResultSet rs5=stmt5.executeQuery(sql5);
				while(rs5.next()){
					request.setAttribute("courseN"+k, rs5.getString("name"));
					request.setAttribute("cId"+k, rs5.getString(1));
					k++;
				}
				if(rs5.first()){
					request.setAttribute("ncId", rs5.getString(1));
				} 
				request.setAttribute("cpage", "1");
			}catch (SQLException e) {
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",sId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		if(request.getParameter("method").equals("deleteCour")){
			String cId =request.getParameter("ncId");
			String sId =request.getParameter("nsId");
			String mId =request.getParameter("nmId");
			String spage=request.getParameter("spage");
			int m=(Integer.parseInt(spage)-1)*5;
			String mpage=request.getParameter("mpage");
			int n=(Integer.parseInt(mpage)-1)*5;
			
			try {
			int i=1;
			int j=1;
			int k=1;
			Statement stmt1 = conn.createStatement();
			String strSql1 = "delete from course where course_id=" + cId ;
			stmt1.executeUpdate(strSql1);
			
			Statement stmt2 = conn.createStatement();
			String strSql2 = "select * from school limit "+m+",5";
			ResultSet rs2=stmt2.executeQuery(strSql2);
			while(rs2.next()){
				request.setAttribute("schoolN"+i, rs2.getString("name"));
				request.setAttribute("sId"+i, rs2.getString(1));
				i++;
			}
			request.setAttribute("nsId", sId);
			request.setAttribute("spage", spage);
			
			Statement stmt3 =conn.createStatement();
			String sql3="SELECT * FROM MAJOR WHERE SCHOOL_ID="+sId+" limit "+n+",5";
			ResultSet rs3=stmt3.executeQuery(sql3);
			while(rs3.next()){
				request.setAttribute("majorN"+j, rs3.getString("name"));
				request.setAttribute("mId"+j, rs3.getString(1));
				j++;
			}
			request.setAttribute("nmId", mId);
			request.setAttribute("mpage", mpage);
			
			Statement stmt4 =conn.createStatement();
			String sql4="SELECT * FROM COURSE WHERE MAJOR_ID="+mId+" limit 0,5";
			ResultSet rs4=stmt4.executeQuery(sql4);
			while(rs4.next()){
				request.setAttribute("courseN"+k, rs4.getString("name"));
				request.setAttribute("cId"+k, rs4.getString(1));
				k++;
			}
			request.setAttribute("cpage", "1");
			} catch (Exception e) {
				
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",sId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",mId)-1)/5+1);
		}
		try {
			conn.close();
		} catch (Exception e) {
		}
		request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request, response);
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
		Connection conn = ConnectMysql.getConn_jdbc();
		if(request.getParameter("method").equals("querySch")){
		String name=request.getParameter("sname");
		String schoolId=null;
		String majorId=null;
		try {
			int i=1;
			int a=1;
			
			Statement stmt1 =conn.createStatement();
			String sql1="SELECT * FROM school WHERE NAME='"+name+"'";
			ResultSet rs1=stmt1.executeQuery(sql1);
			
			if(rs1.first()){
			schoolId=rs1.getString(1);
			request.setAttribute("nsId", rs1.getString(1));
			Statement stmt4 =conn.createStatement();
			String sql4="SELECT * FROM school WHERE school_id<"+rs1.getString(1);
			ResultSet rs4=stmt4.executeQuery(sql4);
			while(rs4.next()){
				a++;
			}
			
            int m=((a-1)/5)*5;
			
			Statement stmt =conn.createStatement();
			String sql="SELECT * FROM school limit "+m+",5";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				request.setAttribute("schoolN"+i, rs.getString("name"));
				request.setAttribute("sId"+i, rs.getString(1));
				i++;
			}
			request.setAttribute("spage", m/5+1);
			//查大学
			
			int j=1;
			Statement stmt2 =conn.createStatement();
			String sql2="SELECT * FROM MAJOR WHERE SCHOOL_ID='"+schoolId+"'";
			ResultSet rs2=stmt2.executeQuery(sql2);
			while(rs2.next()){
				request.setAttribute("majorN"+j, rs2.getString("name"));
				request.setAttribute("mId"+j, rs2.getString(1));
				j++;
			}
			if(rs2.first()){
				majorId=rs2.getString(1);
				request.setAttribute("nmId", rs2.getString(1));
			}
			request.setAttribute("mpage", "1");
			//查专业
			
			int k=1;
			Statement stmt3 =conn.createStatement();
			String sql3="SELECT * FROM COURSE WHERE MAJOR_ID='"+majorId+"'";
			ResultSet rs3=stmt3.executeQuery(sql3);
			while(rs3.next()){
				request.setAttribute("courseN"+k, rs3.getString("name"));
				request.setAttribute("cId"+k, rs3.getString(1));
				k++;
			}
			request.setAttribute("cpage", "1");
			}
			else{
				request.setAttribute("message", "该大学不存在");
				
			}
			
			
		} catch (Exception e) {
			
		}
		request.setAttribute("sAllPages", (getAllRows("school","")-1)/5+1);
		request.setAttribute("mAllPages", (getAllRows("major",schoolId)-1)/5+1);
		request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		if(request.getParameter("method").equals("addSch")){
			String name=request.getParameter("sname");
			String schoolId=null;
			String majorId=null;
			try {
				int i=1;
				int j=1;
				int k=1;
				Statement stmt =conn.createStatement();
				String sql="select * from school where name='"+name+"'";
				ResultSet rs=stmt.executeQuery(sql);
			if(rs.first()){
				request.setAttribute("message", "该大学已存在");
				
			}	
			else{
				Statement stmt1 =conn.createStatement();
			    String sql1="insert into school(name) values('"+name+"') ";
			    stmt1.executeUpdate(sql1);
			}
			
			Statement stmt2 = conn.createStatement();
			String strSql2 = "select * from school limit 0,5";
			ResultSet rs2=stmt2.executeQuery(strSql2);
			while(rs2.next()){
				request.setAttribute("schoolN"+i, rs2.getString("name"));
				request.setAttribute("sId"+i, rs2.getString(1));
				i++;
			}
			if(rs2.first()){
			request.setAttribute("nsId", rs2.getString(1));
			schoolId=rs2.getString(1);
			}
			request.setAttribute("spage", "1");
			
			Statement stmt3 =conn.createStatement();
			String sql3="SELECT * FROM MAJOR WHERE SCHOOL_ID="+schoolId+" limit 0,5";
			ResultSet rs3=stmt3.executeQuery(sql3);
			while(rs3.next()){
				request.setAttribute("majorN"+j, rs3.getString("name"));
				request.setAttribute("mId"+j, rs3.getString(1));
				j++;
			}
			if(rs3.first()){
			request.setAttribute("nmId", rs3.getString(1));
			majorId=rs3.getString(1);
			}
			request.setAttribute("mpage", "1");
			
			Statement stmt4 =conn.createStatement();
			String sql4="SELECT * FROM COURSE WHERE MAJOR_ID="+majorId+" limit 0,5";
			ResultSet rs4=stmt4.executeQuery(sql4);
			while(rs4.next()){
				request.setAttribute("courseN"+k, rs4.getString("name"));
				request.setAttribute("cId"+k, rs4.getString(1));
				k++;
			}
			request.setAttribute("cpage", "1");
			} catch (Exception e) {
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",schoolId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		if(request.getParameter("method").equals("addMaj")){
			String name=request.getParameter("mname");
			String sId=request.getParameter("nsId");
            String spage=request.getParameter("spage");
            int m=(Integer.parseInt(spage)-1)*5;
            String majorId=null;
			try {
				int i=1;
				int j=1;
				int k=1;
			
				Statement stmt =conn.createStatement();
				String sql="select * from major where name='"+name+"' and school_id="+sId;
				ResultSet rs=stmt.executeQuery(sql);
			if(rs.first()){
				request.setAttribute("message", "该专业已存在");
				
			}	
			else{
				Statement stmt1 =conn.createStatement();
				String sql1="insert into major(name,school_id) values('"+name+"','"+sId+"') ";
				stmt1.executeUpdate(sql1);
			}
				
			
			
			Statement stmt2 = conn.createStatement();
			String strSql2 = "select * from school limit "+m+",5";
			ResultSet rs2=stmt2.executeQuery(strSql2);
			while(rs2.next()){
				request.setAttribute("schoolN"+i, rs2.getString("name"));
				request.setAttribute("sId"+i, rs2.getString(1));
				i++;
			}
			request.setAttribute("nsId", sId);
			request.setAttribute("spage", spage);
			
			Statement stmt3 =conn.createStatement();
			String sql3="SELECT * FROM MAJOR WHERE SCHOOL_ID="+sId+" limit 0,5";
			ResultSet rs3=stmt3.executeQuery(sql3);
			while(rs3.next()){
				request.setAttribute("majorN"+j, rs3.getString("name"));
				request.setAttribute("mId"+j, rs3.getString(1));
				j++;
			}
			if(rs3.first()){
			request.setAttribute("nmId", rs3.getString(1));
			majorId=rs3.getString(1);
			}
			request.setAttribute("mpage", "1");
			
			Statement stmt4 =conn.createStatement();
			String sql4="SELECT * FROM COURSE WHERE MAJOR_ID="+majorId+" limit 0,5";
			ResultSet rs4=stmt4.executeQuery(sql4);
			while(rs4.next()){
				request.setAttribute("courseN"+k, rs4.getString("name"));
				request.setAttribute("cId"+k, rs4.getString(1));
				k++;
			}
			request.setAttribute("cpage", "1");
			} catch (Exception e) {
			}
			request.setAttribute("sAllPages", (getAllRows("school","0")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",sId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",majorId)-1)/5+1);
		}
		
		if(request.getParameter("method").equals("addCour")){
			String name=request.getParameter("cname");
			String sId=request.getParameter("nsId");
			String mId=request.getParameter("nmId");
			String spage=request.getParameter("spage");
	        int m=(Integer.parseInt(spage)-1)*5;
	        String mpage=request.getParameter("mpage");
	        int n=(Integer.parseInt(mpage)-1)*5;
			try {
				int i=1;
				int j=1;
				int k=1;
				
				Statement stmt =conn.createStatement();
				String sql="select * from course where name='"+name+"' and major_id="+mId;
				ResultSet rs=stmt.executeQuery(sql);
			if(rs.first()){
				request.setAttribute("message", "该课程已存在");
				
			}	
			else{
				Statement stmt1 =conn.createStatement();
				String sql1="insert into course(name,major_id) values('"+name+"','"+mId+"') ";
				stmt1.executeUpdate(sql1);
			}	
				
			Statement stmt2 = conn.createStatement();
			String strSql2 = "select * from school limit "+m+",5";
			ResultSet rs2=stmt2.executeQuery(strSql2);
			while(rs2.next()){
				request.setAttribute("schoolN"+i, rs2.getString("name"));
				request.setAttribute("sId"+i, rs2.getString(1));
				i++;
			}
			request.setAttribute("nsId", sId);
			request.setAttribute("spage", spage);
			
			Statement stmt3 =conn.createStatement();
			String sql3="SELECT * FROM MAJOR WHERE SCHOOL_ID="+sId+" limit "+n+",5";
			ResultSet rs3=stmt3.executeQuery(sql3);
			while(rs3.next()){
				request.setAttribute("majorN"+j, rs3.getString("name"));
				request.setAttribute("mId"+j, rs3.getString(1));
				j++;
			}
			
			request.setAttribute("nmId", mId);
			request.setAttribute("mpage", mpage);
			
			Statement stmt4 =conn.createStatement();
			String sql4="SELECT * FROM COURSE WHERE MAJOR_ID="+mId+" limit 0,5";
			ResultSet rs4=stmt4.executeQuery(sql4);
			while(rs4.next()){
				request.setAttribute("courseN"+k, rs4.getString("name"));
				request.setAttribute("cId"+k, rs4.getString(1));
				k++;
			}
			request.setAttribute("cpage", "1");
			} catch (Exception e) {
			}
			request.setAttribute("sAllPages", (getAllRows("school","")-1)/5+1);
			request.setAttribute("mAllPages", (getAllRows("major",sId)-1)/5+1);
			request.setAttribute("cAllPages", (getAllRows("course",mId)-1)/5+1);
		}
		try {
			conn.close();
		} catch (Exception e) {
		}
		request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request, response);
	}
     public int getAllRows(String name,String id){
    	 Connection conn = ConnectMysql.getConn_jdbc();
    	 int i=0;
		try {
			if(name.equals("school")){
			Statement stmt1 = conn.createStatement();
			String sql1="SELECT * FROM SCHOOL";
			ResultSet rs1=stmt1.executeQuery(sql1);
			while (rs1.next()) {
				i++;
			}
			}
			if(name.equals("major")){
				Statement stmt1 = conn.createStatement();
				String sql1="SELECT * FROM MAJOR WHERE SCHOOL_ID="+id;
				ResultSet rs1=stmt1.executeQuery(sql1);
				while (rs1.next()) {
					i++;
				}
				}
			if(name.equals("course")){
				Statement stmt1 = conn.createStatement();
				String sql1="SELECT * FROM COURSE WHERE MAJOR_ID="+id;
				ResultSet rs1=stmt1.executeQuery(sql1);
				while (rs1.next()) {
					i++;
				}
				}
		} catch (SQLException e1) {
		}
			
    	 
    	 try {
			conn.close();
		} catch (SQLException e) {
		} 
    	 return i;
    	 
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
