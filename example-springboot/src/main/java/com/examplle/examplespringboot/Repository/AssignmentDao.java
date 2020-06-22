package com.examplle.examplespringboot.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.AssignmentCompletion;
import com.examplle.examplespringboot.model.ProjectCompletion;
import com.mysql.cj.xdevapi.Statement;
import org.springframework.jdbc.core.PreparedStatementCreator;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AssignmentDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	public List<Assignment> getassignment(){
		 String query = "select * from assignment;";
		 List<Assignment> assignments = new ArrayList<Assignment>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	Assignment  assign = new Assignment();
	             
	        	assign.setA_id((Integer)row.get("a_id"));
	        	assign.setTitle((String)row.get("title"));
	        	assign.setDescription((String)row.get("description"));
	        	assign.setMailid((String)row.get("mailid"));
	        	assign.setLast_date((String)row.get("last_date"));
	            
	             
	             
	        	assignments .add(assign);
	         }

	       return assignments ;
	 }
	 

	public int addassign(String title, String description,String mailid,String last_date) {
		
		/*String query = "insert into assignment values(?,?,?,?);";
        return jdbcTemplate.update(query,title,description,mailid,last_date);*/
		
		final String sql = "INSERT INTO assignment "
				+ "(title, description,mailid,last_date) VALUES (?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "a_id" });
	                ps.setString(1, title);
	                ps.setString(2, description);
	                ps.setString(3, mailid);
	                ps.setString(4, last_date);

	                return ps;
	            }

	        }, keyHolder);

		System.out.println(
				"Auto generated Key is = " + keyHolder.getKey());
		 int id = keyHolder.getKey().intValue();
	
		return 1;
	}


	public int delete(int a_id) {

        String query = "delete from assignment where a_id=?;";
        return jdbcTemplate.update(query,a_id);
	}


	public int addresponse(int id, String title, String grad_mailid, boolean submitted) {
		String query = "insert into assignment_completion values(?,?,?,?);";
        return jdbcTemplate.update(query,id,title,grad_mailid,submitted);
	}


	public List<AssignmentCompletion> getsubmission() {
		String query = "select * from assignment_completion;";
		 List<AssignmentCompletion> completion = new ArrayList<AssignmentCompletion>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	AssignmentCompletion  com = new AssignmentCompletion();
	             
	        	com.setId((Integer)row.get("id"));
	        	com.setTitle((String)row.get("Title"));
	        	com.setGrad_mailid((String)row.get("grad_mailid"));
	        	
	        	
	            
	             
	             
	        	completion .add(com);
	         }

	       return completion ;
	}
	

}
