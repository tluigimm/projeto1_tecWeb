package br.edu.insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAssignment
 */
@WebServlet("/AddAssignment")
public class AddAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Assignment asg = new Assignment();
		
		asg.setSub(request.getParameter("sub"));
		asg.setNote(request.getParameter("note"));
		asg.setDate(request.getParameter("date"));
		asg.setUserId(Integer.parseInt(request.getParameter("userId")));
		
		DAO dao = new DAO();
		
		dao.createAssignment(asg);
		
		request.setAttribute("userId", asg.getUserId());
		request.getRequestDispatcher("assignments.jsp").forward(request, response);
		request.setAttribute("userId", asg.getUserId());
		
		dao.close();
	}

}