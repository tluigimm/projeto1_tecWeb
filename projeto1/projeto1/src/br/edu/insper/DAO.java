package br.edu.insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	
	public List<Assignment> DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/db","root","102030");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		public List<Assignment> getAssignmentList (int user_id) {
			List<Assignment> assignments = new ArrayList<Assignment>();
			
			String id = String.valueOf(user_id);
			
			PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM notes WHERE user_id="+id);
			ResultSet rs = stmt.executeQuery();
			
			rs.close();
			stmt.close();
			
			return assignments;
		}
	}
	
	
}
