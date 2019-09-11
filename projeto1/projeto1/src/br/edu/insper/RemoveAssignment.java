package br.edu.insper;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RemoveAssignment")
public class RemoveAssignment extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		String asgId = request.getParameter("asgId");
		
		dao.removeAssignment(asgId);
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("assignments.jsp").forward(request, response);
		request.setAttribute("userId", userId);
		
		dao.close();
	}
}
