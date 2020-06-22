package com.examplle.examplespringboot.model;

public class Chart {
	private String mark;
	private Integer count;
	
	private Integer count1;
	private String mark1;
	
	private Integer assign_count;
	private String assign_last_date;
	private String last_date;
	public Chart() {
		
	}
	public Chart(String mark,Integer count,Integer count1) {
		super();
		this.mark = mark;
		this.count = count;
		this.count1 = count1;
		
	}
	public Chart(String mark, Integer count) {
		super();
		this.mark = mark;
		this.count = count;
	}
	
	public Chart( Integer count1,String mark1) {
		super();
		this.mark1 = mark1;
		this.count1 = count1;
	}
	
	
	
	public Chart(Integer assign_count, String assign_last_date, String last_date) {
		super();
		this.assign_count = assign_count;
		this.assign_last_date = assign_last_date;
		this.last_date = last_date;
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCount1() {
		return count1;
	}
	public void setCount1(Integer count1) {
		this.count1 = count1;
	}
	public String getMark1() {
		return mark1;
	}
	public void setMark1(String mark1) {
		this.mark1 = mark1;
	}
	
	
	public Integer getAssign_count() {
		return assign_count;
	}
	public void setAssign_count(Integer assign_count) {
		this.assign_count = assign_count;
	}
	public String getAssign_last_date() {
		return assign_last_date;
	}
	public void setAssign_last_date(String assign_last_date) {
		this.assign_last_date = assign_last_date;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
}
