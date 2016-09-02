package cn.nancai.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

import com.dao.BaseDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.nancai.bean.Course;
import com.nancai.bean.Major;
import com.nancai.bean.School;
import com.nancai.service.IKUtil;
import com.tool.SegmentTool;

public class DataControl extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sid = request.getParameter("id");
		String type = request.getParameter("type");
		
		Map map = IKUtil.getIKMap(sid, type);
		
		if (map == null) {
			return;
		}
		
		JSONArray json = SegmentTool.mapToJSON(map);
		
		response.setContentType("text/json"); 
		response.setCharacterEncoding("UTF-8"); 
		PrintWriter out = response.getWriter();
		
		out.println(json.toString()); 
		out.flush(); 
		out.close();
	}
}
