package project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.jdbc;

public class show extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String ref=req.getParameter("ref");
		String[] v=jdbc.display(ref);
		if(v==null) {
			res.sendRedirect("fail_1.jsp");
			
		}else {
			System.out.print(v[0]);
			req.setAttribute("name", v[0]);
			req.setAttribute("bus_no",v[5]);
			req.setAttribute("from", v[2]);
			req.setAttribute("to", v[3]);
			req.setAttribute("date",v[1]);
			req.setAttribute("time", v[4]);
			req.setAttribute("ref_id", v[6]);
			req.getRequestDispatcher("view.jsp").forward(req,res);
		}
		
		
	}

}
