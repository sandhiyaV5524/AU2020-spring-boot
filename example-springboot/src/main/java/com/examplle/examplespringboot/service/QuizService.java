package com.examplle.examplespringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.examplle.examplespringboot.Repository.QuestionDao;
import com.examplle.examplespringboot.model.Questions;
import com.examplle.examplespringboot.model.Quiz;

@Service
public class QuizService {
	@Autowired
    public QuestionDao dao;
	
	
	public List<Quiz> getQuestions() {

		List<Questions> question = (List<Questions>)dao.findAll();
		List<Quiz> response=new ArrayList<>();
		for(int i=0;i<question.size();i++) {
			
			Quiz quiz = new Quiz();
			quiz.setId(question.get(i).getQn_id());
			quiz.setQn(question.get(i).getQn());
			List<String> options = new ArrayList<>();
			options.add(question.get(i).getOp1());
			options.add(question.get(i).getOp2());
			options.add(question.get(i).getOp3());
			options.add(question.get(i).getOp4());
			quiz.setOptions(options);
			quiz.setAns(question.get(i).getAnswer());
			response.add(quiz);
			
		}
		return response;
	}


	public int updateScoreService(String emailId, int quiz_mark) {
		int ans=dao.updatescore(emailId,quiz_mark);
		String str="Candidate with mailId: " + emailId + " got updated\n";
		return ans;
	}
	
	public int addQuetsionService(String qn, String op1, String op2, String op3, String op4, int answer) {
		int ans=dao.addquestion(qn,op1,op2,op3,op4,answer);
		return ans;
	}

}
