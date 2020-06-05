package com.examplle.examplespringboot.model;

public class trainer {
	public int id;
	public String t_name;
	public int c_id;
	public String course_name;
	public String mail_id;
	public int con_num;
	public trainer() {}
	public trainer(int id, String t_name, String course_name, String mail_id, int con_num) {
		super();
		this.id = id;
		this.t_name = t_name;
		this.course_name = course_name;
		this.mail_id = mail_id;
		this.con_num = con_num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public int getCon_num() {
		return con_num;
	}
	public void setCon_num(int con_num) {
		this.con_num = con_num;
	}
	

}
