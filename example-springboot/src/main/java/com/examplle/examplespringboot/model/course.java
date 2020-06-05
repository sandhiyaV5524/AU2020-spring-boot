package com.examplle.examplespringboot.model;

public class course {
	public int id;
	public String c_name;
	public int trainer_id;
	
	public course() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	
	public course(int id, String c_name, int trainer_id) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.trainer_id = trainer_id;
	}
	

}
