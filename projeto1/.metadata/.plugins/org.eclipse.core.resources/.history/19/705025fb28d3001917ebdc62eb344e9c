package br.edu.insper;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ListUsers extends HttpServlet {
	protected void service(HttpServletRequest request,
				HttpServletResponse response)
		throws ServletException, IOException{
			DAO dao = new DAO();
			List<User> users = dao.getUsers();
			
			PrintWriter out = response.getWriter();
			out.println("<html><body><table border='1'>");
			out.println("<tr><td>ID</td><td>Nome</td><td>senha</td>");
			
			for (User user : users) {
				out.println("<tr><td>" + user.getId() +"</td>");
				out.println("<td>"+ user.getUsername()+"</td>");
				out.println("<td>"+ user.getPassword()+"</td></tr>");
			}
			out.println("</tanble></body></html>");
			dao.close();
	}
}
