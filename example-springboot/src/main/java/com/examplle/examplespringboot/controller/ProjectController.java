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

import com.examplle.examplespringboot.Repository.ProjectDao;


import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.ProjectCompletion;
import com.examplle.examplespringboot.service.ProjectService;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
    public ProjectService service; 
	
	
	
	@PostMapping(path="/addproject")
	public String addproject(@RequestHeader("authemail") String email,@RequestBody Project pro) {
		int ans=service.addProjectService(pro.title,pro.description,pro.assigned_to,pro.posted_by,pro.last_date);
		if(ans >= 1){
            return "project Added Successfully";
        }else{
            return "Something went wrong !";
        }
		
	}
	
	
	@GetMapping("/getproject/{assigned_to}")
	@ResponseBody
    public List<Project> getproject(@PathVariable("assigned_to") String assigned_to){
		
		 List<Project> pro=service.getprojectbyassignedto(assigned_to);
		return pro;
        	
    }

	@GetMapping(path="/getprojects")
	public List<Project> project(@RequestHeader("authemail") String email) {
		
        List<Project> cou = service.getProjectService();
        return cou;
    }
	/*@GetMapping(path="/getprojectss/{posted_by}")
	public List<Project> gproject(@PathVariable("posted_by") String posted_by) {
		
        List<Project> cou = dao.getprojectbyid(posted_by);
        return cou;
    }*/
	
	
	@DeleteMapping("/deleteproject/{pid}")
    public String deleteProject(@RequestHeader("authemail") String email,@PathVariable int pid){
        	if(service.deleteProjectService(email,pid)< 1)
            	return "Can't be deleted";
            else
            	
            	return "Project Deleted Successfully";
            
        }
        
 
	 

	
	@GetMapping(path="/getsubmissions")
	public List<ProjectCompletion> getsubmission(@RequestHeader("authemail") String email) {
		
		List<ProjectCompletion> a = service.getSubmissionService(); 
       
        return a;
    }
}
