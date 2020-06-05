package com.examplle.examplespringboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.examplle.examplespringboot.model.User;

public class UserRowMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
	  //user.setCustNo(rs.getInt("id"));
	  //user.setCustName(rs.getString("name"));
	 user.setId(rs.getInt("id"));
	 
	  		user.setUsername(rs.getString("username"));
	  		user.setEmailId(rs.getString("emailId"));
	  		user.setPassword(rs.getString("password"));
	  
	  return user;
	 }
	
	
	

}