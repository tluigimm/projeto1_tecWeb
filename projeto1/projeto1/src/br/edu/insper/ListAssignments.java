package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAssignments extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		DAO dao = new DAO();
		List<Assignment> asgs = dao.getAssignments();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>user ID</td><td>assignment</td><td>date</td>");
		
		for (Assignment asg : asgs) {
			out.println("<tr><td>" + asg.getUserId() +"</td>");
			out.println("<td>"+ asg.getAssignment()+"</td>");
			out.println("<td>"+ asg.getDate()+"</td></tr>");
		}
		out.println("</tanble></body></html>");
		dao.close();
	}
}
