package com.examplle.examplespringboot.model;

import java.util.List;

public class Questions {
	
	public int qn_id;
	public String qn;
	public String op1;
	public String op2;
	public String op3;
	public String op4;
	private List<String> options;
	public int answer;
	
	public Questions() {
		
	}

	public Questions(int qn_id, String qn, String op1, String op2, String op3, String op4, List<String> options,
			int answer) {
		super();
		this.qn_id = qn_id;
		this.qn = qn;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.options = options;
		this.answer = answer;
	}

	public int getQn_id() {
		return qn_id;
	}

	public void setQn_id(int qn_id) {
		this.qn_id = qn_id;
	}

	public String getQn() {
		return qn;
	}

	public void setQn(String qn) {
		this.qn = qn;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	

}
