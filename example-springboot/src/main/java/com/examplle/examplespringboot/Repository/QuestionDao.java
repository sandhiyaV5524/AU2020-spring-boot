package com.examplle.examplespringboot.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examplle.examplespringboot.model.Questions;
import com.examplle.examplespringboot.model.Quiz;

@Repository
public class QuestionDao {
	
	@Autowired
    private  JdbcTemplate jdbcTemplate;
	
	

	

	public  List<Questions> findAll() {
		String query = "select * from questions;";
        List<Questions> question = new ArrayList<Questions>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);


        for (Map<String, Object> row : rows) 
        {
        	Questions qn = new Questions();
             
             qn.setQn_id((Integer)row.get("qn_id"));
             qn.setQn((String)row.get("qn"));
                   
             qn.setOp1((String)row.get("op1"));
             qn.setOp2((String)row.get("op2"));
             qn.setOp3((String)row.get("op3"));
             qn.setOp4((String)row.get("op4"));
            qn.setAnswer((Integer)row.get("answer"));
            
             
             
            question.add(qn);
         }

       return  question;
	}





	public int updatescore(String emailId, int quiz_mark) {
		String query = "update candidate set quiz_mark=? where emailId=?";
        return jdbcTemplate.update(query,quiz_mark,emailId);
	}

}
