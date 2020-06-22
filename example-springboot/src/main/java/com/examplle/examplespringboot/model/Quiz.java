package com.examplle.examplespringboot.model;

import java.util.List;

public class Quiz {
	public int id;
	public String qn;
	public List<String> options;
	public int ans;
	public Quiz() {
		
	}
	public Quiz(int id, String qn, List<String> options, int ans) {
		super();
		this.id = id;
		this.qn = qn;
		this.options = options;
		this.ans = ans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQn() {
		return qn;
	}
	public void setQn(String qn) {
		this.qn = qn;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int i) {
		this.ans = i;
	}
	
	

}
