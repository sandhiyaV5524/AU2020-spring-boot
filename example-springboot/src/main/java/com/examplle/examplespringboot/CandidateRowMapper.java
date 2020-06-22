package com.examplle.examplespringboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.examplle.examplespringboot.model.Candidate;


public class CandidateRowMapper implements RowMapper<Candidate> {
	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate can = new Candidate();
	  
	 can.setEmp_no(rs.getInt("emp_no"));
	 can.setName(rs.getString("name"));
	 can.setEmailId(rs.getString("emailId"));
	 can.setProject_mark(rs.getInt("project_mark"));
	 can.setAssignment_mark(rs.getInt("assignment_mark"));
	 can.setQuiz_mark(rs.getInt("quiz_mark"));
	 
	  		
	  		
	  return can;
	 }

}
