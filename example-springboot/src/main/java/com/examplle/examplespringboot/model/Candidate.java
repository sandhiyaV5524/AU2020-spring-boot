package com.examplle.examplespringboot.model;

public class Candidate {
	public int emp_no;
	public String name;
	public String emailId;
	public int project_mark;
	public int assignment_mark;
	public int quiz_mark;
	public Candidate() {
		
	}
	public Candidate(int emp_no, String name, String emailId, int project_mark,
	 int assignment_mark,int quiz_mark) {
		super();
		this.emp_no = emp_no;
		this.name = name;
		this.emailId = emailId;
		this.project_mark=project_mark;
		this.assignment_mark=assignment_mark;
		this.quiz_mark=quiz_mark;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getProject_mark() {
		return project_mark;
	}
	public void setProject_mark(int project_mark) {
		this.project_mark = project_mark;
	}
	public int getAssignment_mark() {
		return assignment_mark;
	}
	public void setAssignment_mark(int assignment_mark) {
		this.assignment_mark = assignment_mark;
	}
	public int getQuiz_mark() {
		return quiz_mark;
	}
	public void setQuiz_mark(int quiz_mark) {
		this.quiz_mark = quiz_mark;
	}
	
	

}
