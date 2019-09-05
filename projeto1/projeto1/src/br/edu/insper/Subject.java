package br.edu.insper;
import java.util.LinkedList;

public class Subject {
	private String subject;
	private LinkedList<Assignment> assignments;
	
	public Subject(String subject) {
		this.subject = subject;
		this.assignments = new LinkedList<>();
	}
	
	//getter subject	
	public String getSubject() {
		return subject;
	}
	
	//getter assignments
	public LinkedList<Assignment> getAssignments(){
		return assignments;
	}
	
	//add new assignment	
	public void addAssignment(Assignment newAssignment) {
		assignments.add(newAssignment);
	}
	
	//remove assignment
	public void removeAssignment(int index){
		assignments.remove(index);
	}
	
	//edit assignmentr
	public void editAssignment(int index, Assignment newAssignment) {
		assignments.set(index, newAssignment);
	}
}
