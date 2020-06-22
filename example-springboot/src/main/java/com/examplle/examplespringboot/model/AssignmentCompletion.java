package com.examplle.examplespringboot.model;

public class AssignmentCompletion {
	public int id;
	public String Title;
	public String grad_mailid;
	public boolean submitted;
	public AssignmentCompletion() {
		
	}
	public AssignmentCompletion(int id, String Title, String grad_mailid, boolean submitted) {
		super();
		this.id=id;
		this.Title = Title;
		this.grad_mailid = grad_mailid;
		this.submitted = submitted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getGrad_mailid() {
		return grad_mailid;
	}
	public void setGrad_mailid(String grad_mailid) {
		this.grad_mailid = grad_mailid;
	}
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	
}
