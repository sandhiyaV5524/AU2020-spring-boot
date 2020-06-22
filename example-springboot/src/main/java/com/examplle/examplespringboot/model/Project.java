package com.examplle.examplespringboot.model;


public class Project {
	
	public int pid;
	public String title;
	public String description;
	public String assigned_to;
	public String posted_by;
	public String last_date;
	
	
	public Project() {
		
	}
	public Project(int pid, String title, String description, String assigned_to,String posted_by,String last_date) {
		super();
		this.pid=pid;
		this.title = title;
		this.description = description;
		this.assigned_to = assigned_to;
		this.posted_by=posted_by;
		this.last_date=last_date;
	}
	
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	
	
	

}
