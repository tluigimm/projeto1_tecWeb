package br.edu.insper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CreateUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='username'><br>");
		out.println("Senha: <input type=‘text' name='password'><br>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException {
		
		DAO dao = new DAO();
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		dao.addUser(user);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("added" + user.getUsername());
		out.println("</body></html>");
		
		dao.close();
	}

}