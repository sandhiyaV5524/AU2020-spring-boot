package com.examplle.examplespringboot.model;

public class assignment {
	public int id;
	public String mailid;
	public String title;
	public String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public assignment() {
		
	}
	public assignment(int id,String title,String mailid, String description) {
		super();
		this.id=id;
		this.mailid=mailid;
		this.title = title;
		this.description = description;
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
	public void setDescription(String description) {
		this.description = description;
	}

}
