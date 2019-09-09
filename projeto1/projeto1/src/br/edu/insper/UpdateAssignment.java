package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAssignment extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Assignment: <input type='text' name='asg'><br>");
		out.println("Date: <input type='text' name='date'>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException{
		DAO dao = new DAO();
		
		Assignment asg = new Assignment();
		asg.setAssignment(request.getParameter("asg"));
		asg.setDate(request.getParameter("date"));
		
		dao.alterAssginment(asg);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Your assignment has been updated");
		out.println("</body></html>");
		
		dao.close();

	}
}