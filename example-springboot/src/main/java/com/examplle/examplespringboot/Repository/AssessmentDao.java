package com.examplle.examplespringboot.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;



import com.examplle.examplespringboot.model.assignment;
import com.examplle.examplespringboot.model.course;
import com.examplle.examplespringboot.model.questions;
import com.examplle.examplespringboot.model.trainer;




@Repository
public class AssessmentDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	private static final String SQL = "select * from login;";
	
	
	
	 public List<course> getdetails() {
		 String query = "select * from course;";
        List<course> courses = new ArrayList<course>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) 
        {
        	course course = new course();
             
        	course.setC_name((String)row.get("c_name"));
        	course.setId((Integer)row.get("id"));
        	course.setTrainer_id((Integer)row.get("trainer_id"));
             
             
            
             
             
             courses.add(course);
         }

       return courses;
   }
	 public List<assignment> getassignment(){
		 String query = "select * from assignment;";
		 List<assignment> assignments = new ArrayList<assignment>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	assignment  assign = new assignment();
	             
	        	assign.setId((Integer)row.get("id"));
	        	assign.setTitle((String)row.get("title"));
	        	assign.setDescription((String)row.get("description"));
	        	
	            
	             
	             
	        	assignments .add(assign);
	         }

	       return assignments ;
	 }
	 public List<trainer> gettrainer() {
		 String query = "select * from trainer;";
	        List<trainer> trainers = new ArrayList<trainer>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	trainer  trainer = new trainer();
	             
	        	trainer.setT_name((String)row.get("t_name"));
	        	 trainer.setId((Integer)row.get("id"));
	        	 trainer.setCourse_name((String)row.get("course_name"));
	        	 trainer.setMail_id((String)row.get("mail_id"));
	        	 trainer.setCon_num((Integer)row.get("con_num"));
	             
	             
	            
	             
	             
	             trainers.add( trainer);
	         }

	       return  trainers;
		}
		 
	
	public List<String> checkGrad(String new_email, String new_password) {
		// TODO Auto-generated method stub
		List<String> gradList=new ArrayList<>();
		System.out.println("select email from login where email='"+new_email+"' and password='"+new_password+"'");
		gradList.addAll(jdbcTemplate.queryForList("select emailId from login where emailId='"+new_email+"' and password='"+new_password+"'",String.class));
		return gradList;
	}
	


	public int add(int id,String username,String emailId,String password){
        String query = "insert into login values(?,?,?,?);";
        return jdbcTemplate.update(query,id,username,emailId,password);
    }
	
	
	public int addassign(int id,String title, String description,String mailid) {
		
		String query = "insert into assignment values(?,?,?,?);";
        return jdbcTemplate.update(query,id,title,description,mailid);
	}
	public List<questions> getquestion() {
		 String query = "select * from questions;";
	        List<questions> question = new ArrayList<questions>();
	        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

	        for (Map<String, Object> row : rows) 
	        {
	        	questions qn = new questions();
	             
	             qn.setQn_id((Integer)row.get("qn_id"));
	             qn.setQn((String)row.get("qn"));
	             qn.setOp1((String)row.get("op1"));
	             qn.setOp2((String)row.get("op2"));
	             qn.setOp3((String)row.get("op3"));
	             qn.setOp4((String)row.get("op4"));
	             
	             
	            
	             
	             
	            question.add(qn);
	         }

	       return  question;
	}

	public int[] getanswer() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	 	}	
	

