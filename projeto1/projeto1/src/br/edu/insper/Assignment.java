package br.edu.insper;

public class Assignment {
	private int id;
	private int userId;
	private String assignment;
	private String date;
	
	//getter id
	public int getId() {
		return this.id;
	}
	
	//setter userId
	public void setUserId(int userId){
		this.userId = userId;
	}	
	
	//getter userId
	public int getUserId(){
		return this.userId;
	}
	
	//setter assignment	
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	
	//getter assignment	
	public String getAssignment () {
		return this.assignment;
	}
	
	//setter date
	public void setDate(String date) {
		this.date = date;
	}
	
	//getter date
	public String getDate() {
		return this.date;
	}
	
}
