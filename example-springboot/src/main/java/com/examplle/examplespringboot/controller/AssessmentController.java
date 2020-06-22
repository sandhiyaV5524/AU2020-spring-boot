package com.examplle.examplespringboot.controller;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.examplle.examplespringboot.Repository.AssessmentDao;
import com.examplle.examplespringboot.model.AssignmentCompletion;
import com.examplle.examplespringboot.model.Candidate;
import com.examplle.examplespringboot.model.Chart;
import com.examplle.examplespringboot.model.ProjectCompletion;
import com.examplle.examplespringboot.service.AssessmentService;








@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enter")
public class AssessmentController {
	
	@Autowired
    public AssessmentService service; 
	
	Logger logger=LoggerFactory.getLogger(AssessmentController.class);
	
	
	@GetMapping(path="/login/{emailId}")
	public String login(@RequestHeader("authemail") String email,@PathVariable("emailId") String emailId)
	{
		List<String> repocheck=service.loginService(emailId);
		boolean repoCheck=repocheck.isEmpty();
		if(repoCheck==true)
			return "Invalid Credentials";
		else {
			logger.info("Login sucessfull and User "+emailId+" is Authenticated");
			return "Login sucessfull and User is Authenticated";
	}
	}
	
	
	
	
	
	@PostMapping(path="/submit_response")
	public String project_response(@RequestHeader("authemail") String email,@RequestBody ProjectCompletion pro_com) {
		int ans=service.addResponseService(pro_com.title,pro_com.completion,pro_com.Testing,pro_com.Code_Coverage,pro_com.mailId);
		if(ans >= 1){
			logger.info("Project Completion Details Added Successfully");
            return "project Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	
	
	
	
	
	
	
	@GetMapping(path="/getcandidate")
	public List<Candidate> getcandidate(@RequestHeader("authemail") String email) {
		List<String> repocheck=service.loginService(email);
		boolean repoCheck=repocheck.isEmpty();
		if(repoCheck==true) {
		
       
        return null;
		}
		else {
			List<Candidate> a = service.getCandidateService(); 
		       
	        return a;
		}
    }
	
	
	@GetMapping("/getprofile/{emailId}")
	@ResponseBody
	public Candidate getprofileById(@RequestHeader("authemail") String email,@PathVariable("emailId") String emailId) {
		Candidate can = service.getIdService(emailId);
		return can;
	}
	
	
	
	
	
	
	
	@PutMapping("/updatescore")
	@ResponseBody
	 public String updatescore(@RequestHeader("authemail") String email,@RequestBody Candidate can){
		
			if(service.updateScoreService(can.emailId,can.project_mark)<1)
			{
				return "error in updating the score";
			}
			else { 
				logger.info("Candidate with EMAILID: "+can.emailId+ " project mark got updated");
	        return "updated score";
			}
	
    }
	@PutMapping("/updateassignmentscore")
	@ResponseBody
	 public String updateassignmentscore(@RequestHeader("authemail") String email,@RequestBody Candidate can){
		
			if(service.updateAssignmentScoreService(can.emailId,can.assignment_mark)<1)
			{
				return "error in updating the score";
			}
			else { 
				logger.info("Candidate with ID: "+can.emailId+ " Assignment got updated");	
	        return "updated score";
			}
	
    }
	
	
	@GetMapping("/chartmark")
	public List<Chart> getChartDataProject(){
		return service.getChartDataMark();
	}
	@GetMapping("/chartassignmentmark")
	public List<Chart> getChartDataAssignment(){
		return service.getChartDataAssignmentChart();
	}
	@GetMapping("/chartassignmentlastdate")
	public List<Chart> getChartAssignmentLastDate(){
		return service.getChartAssignmentLastDate();
	}
	
	@GetMapping("/chartprojectlastdate")
	public List<Chart> getChartProjectLastDate(){
		return service.getChartProjectLastDate();
	}
	
	
	
	
	/*@PostMapping("/upload")
	public String uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		AssignmentCompletion img = new AssignmentCompletion(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		if(dao.save(img)<1)
		return "cant'be upload";
		else
			return "uploaded successfully";
		
	}*/
	
    }
	

	
	
	
	
	
	 
	

