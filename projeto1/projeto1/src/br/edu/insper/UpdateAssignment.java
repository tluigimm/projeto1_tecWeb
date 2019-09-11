package br.edu.insper;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAssignment")
public class UpdateAssignment extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		Assignment asg = new Assignment();
		asg.setNote(request.getParameter("asg"));
		asg.setDate(request.getParameter("date"));
		asg.setId(Integer.parseInt(request.getParameter("asgId")));
		dao.editAssginment(asg);
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("assignments.jsp").forward(request, response);
		request.setAttribute("userId", userId);
		
		dao.close();

	}
}
