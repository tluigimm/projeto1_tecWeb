package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAssignment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("user id: <input type='text' name='userId'><br>");
		out.println("Assignment: <input type='text' name='asg'><br>");
		out.println("Date: <input type=‘text' name='date'><br>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException {
		
		DAO dao = new DAO();
		Assignment asg = new Assignment();
		
		asg.setAssignment(request.getParameter("asg"));
		asg.setDate(request.getParameter("date"));
		
		dao.addAssignment(asg);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("assignment added");
		out.println("</body></html>");
		
		dao.close();
	}

}
