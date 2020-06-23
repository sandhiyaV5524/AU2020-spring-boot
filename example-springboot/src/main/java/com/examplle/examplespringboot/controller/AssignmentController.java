package com.examplle.examplespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examplle.examplespringboot.Repository.AssignmentDao;
import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.AssignmentCompletion;
import com.examplle.examplespringboot.model.ProjectCompletion;
import com.examplle.examplespringboot.service.AssignmentService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/assignment")

public class AssignmentController {
	

	@Autowired
    public AssignmentService service; 
	

	@PostMapping(path="/submit_assignment")
	public String assignment_response(@RequestHeader("authemail") String email,@RequestBody AssignmentCompletion assign) {
		int ans=service.addResponseService(assign.id,assign.Title,assign.grad_mailid,assign.submitted);
		if(ans >= 1){
            return "assignment Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	
	
	@PostMapping(path="/addassignment")
	public String addAssignment(@RequestHeader("authemail") String email,@RequestBody Assignment assign) {
		int ans=service.addAssignmentService( assign.title,assign.description,assign.mailid,assign.last_date);
		if(ans >= 1){
            return "Assignment Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	
	@GetMapping(path="/getassignment")
	public List<Assignment> getassignment(@RequestHeader("authemail") String email) {
		
		List<Assignment> a = service.getAssignmentService(); 
       
        return a;
    }
	
	@DeleteMapping("/deleteassignment/{a_id}")
    public String deleteAssignment(@RequestHeader("authemail") String email,@PathVariable int a_id){
        	if(service.deleteAssignmentService(email,a_id)< 1)
            	return "Can't be deleted";
            else
            	
            	return "Assignment Deleted Successfully";
            
        }
	
	@GetMapping(path="/getsubmissions")
	public List<AssignmentCompletion> getsubmission(@RequestHeader("authemail") String email) {
		
		List<AssignmentCompletion> a = service.getSubmissionService(); 
       
        return a;
    }
}
