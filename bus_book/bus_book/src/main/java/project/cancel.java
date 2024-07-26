package project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.jdbc;

public class cancel extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String ref=req.getParameter("ref");
		int a=jdbc.cancel(ref);
		if(a==1) {
			res.sendRedirect("success.jsp");
		}else {
			res.sendRedirect("fail_2.jsp");
		}
		
	}
		
	
}
