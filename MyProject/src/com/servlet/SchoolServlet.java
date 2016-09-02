package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.School;
import com.factory.DAOFactory;

public class SchoolServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public SchoolServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");
		if (method.equals("AddSchool")) {
			AddSchool(request, response);
		} else if (method.equals("GetSchool")) {
			GetSchool(request, response);
		}
		out.flush();
		out.close();
	}

	public void AddSchool(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String university = request.getParameter("school");
		String department = request.getParameter("department");
		String major = request.getParameter("major");
		School school = new School();
		school.setUniversity(university);
		school.setDepartment(department);
		school.setMajor(major);
		int i = DAOFactory.getSchoolDaoInstance().addSchool(school);
		if (i == 1) {
			out
					.print("<script  LANGUAGE='JavaScript'>alert('院校添加成功！')</script>");
			response.setHeader("Refresh", "0.001;URL=admin/index.jsp");
		} else {
			out
					.print("<script  LANGUAGE='JavaScript'>alert('院校添加失败')</script>");
			response.setHeader("Refresh", "0.001;URL=admin/index.jsp");
		}
		out.flush();
		out.close();
	}

	public void GetSchool(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//String university = request.getParameter("school");
		String university = request.getParameter("university");
		String department = request.getParameter("department");
		String major = request.getParameter("major");
		School school = new School();
		school.setUniversity(university);
		school.setDepartment(department);
		school.setMajor(major);
		List schooldetail = DAOFactory.getSchoolDaoInstance().getSchoolDetail();
		request.setAttribute("schooldetail", schooldetail);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
