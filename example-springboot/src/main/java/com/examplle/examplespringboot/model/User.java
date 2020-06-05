package com.examplle.examplespringboot.model;

public class User {
	public int id;
	public String username;
	public String emailId;
public String password;
User(int id, String username, String emailId, String password) {
		super();
		this.id = id;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	


    public User() {
    }


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
  
}