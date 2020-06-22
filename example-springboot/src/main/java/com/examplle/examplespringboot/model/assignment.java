package com.examplle.examplespringboot.model;

public class Assignment {
	public int a_id;
	public String mailid;
	public String title;
	public String description;
	public String last_date;
	
	
	public Assignment() {
		
	}
	public Assignment(int a_id,String title,String mailid, String description,String last_date) {
		super();
		this.a_id=a_id;
		this.mailid=mailid;
		this.title = title;
		this.description = description;
		this.last_date=last_date;
	}
	
	
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
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
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
