package br.edu.insper;

public class Assignment {
	private String assignment;
	private String date;
	
	public Assignment (String assignment, String date) {
		this.assignment = assignment;
		this.date = date;
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