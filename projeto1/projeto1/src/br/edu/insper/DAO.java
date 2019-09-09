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
	
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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

	}
	
	// USERS ------------------------------------------------------------------
	
	// list users
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM users");
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}
			
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	// add user
	public void addUser(User user) {
		String sql = "INSERT INTO users" + 
					"(username, password) values(?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
//			stmt.setInt(1, user.getId());
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// edit user
	public void alterUser(User user) {
		try {
			String sql = "UPDATE user SET " + "username=?, password=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	// NOTES ------------------------------------------------------------------
	
	// list assignments
	public List<Assignment> getAssignments() {
		List<Assignment> Assignments = new ArrayList<Assignment>();

		try {
			PreparedStatement stmt = connection.
					prepareStatement("SELECT * FROM notes");
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				Assignment asg = new Assignment();
				asg.setAssignment(rs.getString("assignment"));
				asg.setDate(rs.getString("date"));
				
				Assignments.add(asg);
			}
			
			rs.close();
			stmt.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Assignments;
	}
	
	// add assignment
	public void addAssignment(Assignment asg) {
		String sql = "INSERT INTO notes" + 
					"(id, userId, note, date) values(?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, asg.getId());
			stmt.setInt(2, asg.getUserId());
			stmt.setString(3, asg.getAssignment());
			stmt.setString(4, asg.getDate());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// remove assignment
	public void removeAssignment(Integer userId) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(
					"DELETE FROM notes WHERE user_id=?");
			stmt.setInt(1, userId);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// edit assignment
	public void alterAssginment(Assignment asg) {
		try {
			String sql = "UPDATE notes SET " + "note=?, date=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, asg.getAssignment());
			stmt.setString(2, asg.getDate());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	// close connection 
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
