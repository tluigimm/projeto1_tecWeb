package br.edu.insper;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DAO dao = new DAO();
		
		List<User> userList = dao.getUsers();
		List<String> passwords = new ArrayList<>();
		List<String> usernames = new ArrayList<>();
		
		
		for (User user : userList) {
			usernames.add(user.getUsername());
			passwords.add(user.getPassword());
		}
		
		if(usernames.contains(username) && passwords.contains(password)) {
			System.out.println("welcome!!");
			
			User user = new User();
			user.setUsername(username);
			
			request.setAttribute("userId", user.getId());
			request.getRequestDispatcher("assignments.jsp").forward(request, response);
			
		}
		else {
			request.getRequestDispatcher("wrongUserOrPassword.jsp").forward(request, response);
		}
	}
}
