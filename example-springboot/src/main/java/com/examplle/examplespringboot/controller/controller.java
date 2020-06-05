package com.examplle.examplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examplle.examplespringboot.Repository.AssessmentDao;
import com.examplle.examplespringboot.model.User;
import com.examplle.examplespringboot.model.assignment;
import com.examplle.examplespringboot.model.course;
import com.examplle.examplespringboot.model.questions;
import com.examplle.examplespringboot.model.trainer;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/enter")
public class controller {
	User repo=null;
	@Autowired
    public AssessmentDao dao; 
	@PostMapping(path="/authenticate")
	public String checkGrad(@RequestBody User gradLogin)
	{
		List<String> repocheck=dao.checkGrad(gradLogin.emailId,gradLogin.password);
		boolean repoCheck=repocheck.isEmpty();
		if(repoCheck==true)
			return "Invalid Credentials";
		else
			return "Authenticated";
	}
	@PostMapping(path="/add")
	public String addUser(@RequestBody User reg) {
		int ans=dao.add(reg.id,reg.username,reg.emailId,reg.password);
		if(ans >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	
	@PostMapping(path="/addassignment")
	public String addAssignment(@RequestBody assignment assign) {
		int ans=dao.addassign(assign.id,assign.title,assign.description,assign.mailid);
		if(ans >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	@GetMapping(path="/getassignment")
	public List<assignment> getassignment() {
		
		List<assignment> a = dao.getassignment(); 
       
        return a;
    }
	
	@GetMapping(path="/getcourses")
	public List<course> getcourse() {
		
        List<course> cou = dao.getdetails(); 
       
        return cou;
    }
	@GetMapping(path="/gettrainers")
	public List<trainer> gettrainers() {
		
        List<trainer> cou = dao.gettrainer(); 
       
        return cou;
    }
	@GetMapping(path="/getquestions")
	public List<questions> getquestions() {
		List<questions> qs=dao.getquestion();
		return qs;
		
	}
	@GetMapping(path="/getanswers")
	public int[] getanswers() {
		int[] ans=dao.getanswer();
		return ans;
		
	}
	

    }
	

	
	
	
	
	
	 
	

