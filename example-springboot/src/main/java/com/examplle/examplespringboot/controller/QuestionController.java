package com.examplle.examplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examplle.examplespringboot.Repository.QuestionDao;
import com.examplle.examplespringboot.model.Candidate;
import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.Questions;
import com.examplle.examplespringboot.model.Quiz;
import com.examplle.examplespringboot.service.QuizService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz")
public class QuestionController {
	
	@Autowired
    public QuizService service;
	
	
	@GetMapping("/questions")
	public List<Quiz> getQuiz(){
		return service.getQuestions();
	}
	
	@PutMapping("/updatescore")
	@ResponseBody
	 public String updatescore(@RequestHeader("authemail") String email,@RequestBody Candidate can){
		
			if(service.updateScoreService(can.emailId,can.quiz_mark)<1)
			{
				return "error in updating the score";
			}
			else { 
				//logger.info("Candidate with EMAILID: "+can.emailId+ " project mark got updated");
	        return "updated score";
			}
	
    }
	

	@PostMapping(path="/addquestion")
	public String addproject(@RequestHeader("authemail") String email,@RequestBody Questions qn) {
		int ans=service.addQuetsionService(email,qn.qn,qn.op1,qn.op2,qn.op3,qn.op4,qn.answer);
		if(ans >= 1){
            return "Quetsion Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}

}
