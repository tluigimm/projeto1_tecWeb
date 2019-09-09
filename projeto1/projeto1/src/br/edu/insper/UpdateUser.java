package br.edu.insper;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Username: <input type='text' name='usn'><br>");
		out.println("Password: <input type='text' name='psw'>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException{
		DAO dao = new DAO();
		
		User user = new User();
		user.setUsername(request.getParameter("usn"));
		user.setPassword(request.getParameter("psw"));
		
		dao.alterUser(user);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("updated " + user.getUsername());
		out.println("</body></html>");
		
		dao.close();

	}
}
