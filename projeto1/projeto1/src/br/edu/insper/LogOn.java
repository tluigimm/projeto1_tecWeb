package br.edu.insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOn
 */
@WebServlet("/LogOn")
public class LogOn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOn() {
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
		
		String username  = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		boolean check = (password1.equals(password2)) && (password1 != "") && (password1.length() >= 6) && (username != "");
		
		if (check) {
			String password = password1;
			User user = new User();
			
			user.setUsername(username);
			user.setPassword(password);
			

			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			
			DAO dao = new DAO();
			
			dao.addUser(user);
		} 
		
		else {
			if (username == "") {
				System.out.println("insira um username");
			}
			else if (password1 == "" || password2 == ""){
				System.out.println("preencha senhas");
			}
			else if (password1.length() < 6) {
				System.out.println("senha muito curta");
			}
			else {
				System.out.println("senhas diferentes");
			}
		}
	}
}
