package com.examplle.examplespringboot.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;







import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.ProjectCompletion;


@Repository
public class ProjectDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	public int addproject(String title, String description, String assigned_to,String posted_by,String last_date) {

		final String sql = "INSERT INTO project "
				+ "(title, description,assigned_to,posted_by,last_date) VALUES (?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "pid" });
	                ps.setString(1, title);
	                ps.setString(2, description);
	                ps.setString(3, assigned_to);
	                ps.setString(4, posted_by);
	                ps.setString(5, last_date);

	                return ps;
	            }

	        }, keyHolder);

		System.out.println(
				"Auto generated Key is = " + keyHolder.getKey());
		 int id = keyHolder.getKey().intValue();
	
		return 1;
	}
	
	
	/*public Project getprojectbyid(String assigned_to) {
		String query = "select * from project where assigned_to=?;";
	      Project pro = jdbcTemplate.queryForObject(
	         query, new Object[]{assigned_to}, new ProjectRowMapper());
	      
	      return pro;
	}*/
	
	public List<Project> getprojectbyid(String new_email) {

		try {
		 return jdbcTemplate.query(
	                "select * from project where assigned_to=?",new Object[]{new_email},
	                (rs, rowNum) ->
	                        new Project(
	                        		rs.getInt("pid"),
	    							rs.getString("title"),
	    							rs.getString("description"),
	    							rs.getString("assigned_to"),
	    							rs.getString("posted_by"),
	    							rs.getString("last_date")
	    							            
	                        )
	        );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		//System.out.println("hello");
		
		//return this.jdbcTemplate.query("select * from project where posted_by='"+new_email+"'",new ProjectMapper());
		
		
	}
	
	public List<Project> getproject() {
		String query = "select * from project;";
		 List<Project> completion = new ArrayList<Project>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	Project  pro= new Project();
	             
	      
	        	pro.setPid((Integer)row.get("pid"));
	    		pro.setTitle((String)row.get("title"));
	    		pro.setDescription((String)row.get("description"));
	    		pro.setAssigned_to((String)row.get("assigned_to"));
	    		pro.setPosted_by((String)row.get("posted_by"));
	    		pro.setLast_date((String)row.get("last_date"));
	        	
	            
	             
	             
	        	completion .add(pro);
	         }

	       return completion ;
	}
	
	
	
	public List<ProjectCompletion> getsubmission() {
		String query = "select * from project_completion;";
		 List<ProjectCompletion> completion = new ArrayList<ProjectCompletion>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	ProjectCompletion  com = new ProjectCompletion();
	        	com.setMailId((String)row.get("mailId"));
	        	com.setTitle((String)row.get("title"));
	        	
	        	com.setCompletion((String)row.get("completion"));
	        	com.setTesting((String)row.get("testing"));
	        	com.setCode_Coverage((String)row.get("code_Coverage"));
	        	
	        	
	            
	             
	             
	        	completion .add(com);
	         }

	       return completion ;
	}


	public int delete(int pid) {
		
	        String query = "delete from project where pid=?;";
	        return jdbcTemplate.update(query,pid);
	    }
		 
	
	
	
	

}



