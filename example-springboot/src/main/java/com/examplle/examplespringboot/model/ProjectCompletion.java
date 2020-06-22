package com.examplle.examplespringboot.model;

public class ProjectCompletion {
public String title;
public String completion;
public String Testing;
public String Code_Coverage;
public String mailId;
public ProjectCompletion() {
	
}
public ProjectCompletion(String title, String completion, String testing, String code_Coverage, String mailId) {
	super();
	this.title = title;
	this.completion = completion;
	Testing = testing;
	Code_Coverage = code_Coverage;
	this.mailId = mailId;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCompletion() {
	return completion;
}
public void setCompletion(String completion) {
	this.completion = completion;
}
public String getTesting() {
	return Testing;
}
public void setTesting(String testing) {
	Testing = testing;
}
public String getCode_Coverage() {
	return Code_Coverage;
}
public void setCode_Coverage(String code_Coverage) {
	Code_Coverage = code_Coverage;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}

}
