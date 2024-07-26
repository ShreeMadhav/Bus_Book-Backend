package project;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.jdbc;

public class insert extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String gender=req.getParameter("gender");
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		String date=req.getParameter("date").toString();
		String time=req.getParameter("time").toString();
		String type=req.getParameter("type");
		String bus_no="";
		String phone_no=req.getParameter("phone_number").toString();
		if(type.equals("3x3")) {
			bus_no="30D";
		}else if(type.equals("Deluxe")) {
			bus_no="40A";
		}else if(type.equals("Sleeper")) {
			bus_no="20SL";
		}else {
			bus_no="15CL";
		}
		Random rand = new Random();
		String ref_id=name.charAt(0)+""+phone_no.charAt(1)+""+name.charAt(2)+""+date.charAt(0)+phone_no.charAt(2);
		try {
			LocalDate dates=java.time.LocalDate.now();
			LocalDate localDate = LocalDate.parse(date); 
			if(localDate.compareTo(dates)<0 || from.toLowerCase().equals(to.toLowerCase())) {
				res.sendRedirect("fail.jsp");
				
			}else {
			jdbc.insertss(name, gender, from, to, date, time, bus_no,ref_id,phone_no);
			req.setAttribute("name", name);
			req.setAttribute("bus_no",bus_no);
			req.setAttribute("from", from);
			req.setAttribute("to", to);
			req.setAttribute("date",date);
			req.setAttribute("time", time);
			req.setAttribute("ref_id", ref_id);
			req.getRequestDispatcher("view.jsp").forward(req,res);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
