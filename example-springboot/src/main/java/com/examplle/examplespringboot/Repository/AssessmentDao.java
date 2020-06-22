package com.examplle.examplespringboot.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
import com.examplle.examplespringboot.CandidateRowMapper;
import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.AssignmentCompletion;
import com.examplle.examplespringboot.model.Candidate;
import com.examplle.examplespringboot.model.Project;

@Repository
public class AssessmentDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	 
	
	 public List<String> login(String new_email) {
			List<String> gradList=new ArrayList<>();
			System.out.println("select email from login where email='"+new_email+"' ");
			gradList.addAll(jdbcTemplate.queryForList("select emailId from login where emailId='"+new_email+"'",String.class));
			return gradList;
		}
	
	
	

	public Candidate getid(String emailId) {
		String SQL = "select * from candidate where emailId = ?";
		Candidate can = jdbcTemplate.queryForObject(
	         SQL, new Object[]{emailId}, new CandidateRowMapper());
	      
	      return can;
	   }
	
	
	
	
	
	public List<Candidate> getcandidate() {
		 String query = "select * from candidate;";
		 List<Candidate> candidates = new ArrayList<Candidate>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	Candidate  can = new Candidate();
	        	can.setEmp_no((Integer)row.get("emp_no"));
	        	can.setName((String)row.get("name"));
	        	can.setEmailId((String)row.get("emailId"));
	        	can.setProject_mark((Integer)row.get("project_mark"));
	        	can.setAssignment_mark((Integer)row.get("assignment_mark"));
	        	
	        	
	        	candidates .add(can);
	         }

	       return candidates ;
	}
	
	
	
	public int addresponse(String title, String completion, String testing, String code_Coverage, String mailId) {
		String query = "insert into project_completion values(?,?,?,?,?);";
        return jdbcTemplate.update(query,title,completion,testing,code_Coverage,mailId);
	}
	
	public int updatescore(String emailId, int project_mark) {
			String query = "update candidate set project_mark=? where emailId=?";
	        return jdbcTemplate.update(query,project_mark,emailId);
	    }




	public int updateassignmentscore(String emailId, int assignment_mark) {
		String query = "update candidate set assignment_mark=? where emailId=?";
        return jdbcTemplate.update(query, assignment_mark,emailId);
	}




	public List<Candidate> getCandidateByMarkGreater(int i,int j) {
		try {
			
			 return jdbcTemplate.query(
		                "select * from candidate where project_mark BETWEEN ? AND ?",new Object[]{i,j},
		                (rs, rowNum) ->
		                        new Candidate(
		                        		rs.getInt("emp_no"),
		                        		rs.getString("name"),
		    							rs.getString("emailId"),
		    							rs.getInt("project_mark"),
		    							rs.getInt("assignment_mark"),
		    							rs.getInt("quiz_mark")
		    							
		    							            
		                        )
		        );
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		
	}




	public List<Candidate> getCandidateByAssignmentMarkGreater(int i, int j) {
		try {
			
			 return jdbcTemplate.query(
		                "select * from candidate where assignment_mark BETWEEN ? AND ?",new Object[]{i,j},
		                (rs, rowNum) ->
		                        new Candidate(
		                        		rs.getInt("emp_no"),
		                        		rs.getString("name"),
		    							rs.getString("emailId"),
		    							rs.getInt("project_mark"),
		    							rs.getInt("assignment_mark"),
		    							rs.getInt("quiz_mark")
		    							            
		                        )
		        );
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		
	}




	public List<Assignment> getAssignmentCountByLastDate(String string1, String string2) {
		try {
			
			 return jdbcTemplate.query(
		                "select * from assignment where last_date BETWEEN ? AND ?",new Object[]{string1,string2},
		                (rs, rowNum) ->
		                        new Assignment(
		                        		rs.getInt("a_id"),
		                        		rs.getString("title"),
		    							rs.getString("description"),
		    							rs.getString("mailid"),
		    							rs.getString("last_date")
		    							            
		                        )
		        );
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		
	}




	public List<Project> getProjectCountByLastDate(String string1, String string2) {
		try {
			
			 return jdbcTemplate.query(
		                "select * from project where last_date BETWEEN ? AND ?",new Object[]{string1,string2},
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
	}
	
	
	



	/*public int save(AssignmentCompletion img) {

		final String sql = "INSERT INTO assignmentcompletion "
				+ "(file_name,file_type,file) VALUES (?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
	                InputStream is;
					try {
						is = new FileInputStream(new (String)img.setFile(img.getFile())));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                ps.setString(1, img.getFile_name());
	                ps.setString(2, img.getFile_type());
	                ps.setBlob(3, is);
	                
	                return ps;
	            }

	        }, keyHolder);

		System.out.println(
				"Auto generated Key is = " + keyHolder.getKey());
		 int id = keyHolder.getKey().intValue();
	return id;
	
		
		
	}*/
	 
		
	}
	

	
	 		
	

