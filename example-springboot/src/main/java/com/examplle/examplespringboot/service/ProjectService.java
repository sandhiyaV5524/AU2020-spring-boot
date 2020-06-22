package com.examplle.examplespringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.examplle.examplespringboot.Repository.ProjectDao;
import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.ProjectCompletion;

@Service
public class ProjectService {
	
	@Autowired
    public ProjectDao dao;

	public int addProjectService(String title, String description, String assigned_to, String posted_by,String last_date) {
			int ans=dao.addproject(title,description,assigned_to,posted_by,last_date);
		return ans;
	}

	public List<Project> getProjectService() {
		 List<Project> cou = dao.getproject();
		return cou;
	}

	public int deleteProjectService(int pid) {
		int ans=dao.delete(pid);
		return ans;
	}

	public List<ProjectCompletion> getSubmissionService() {
		List<ProjectCompletion> a = dao.getsubmission(); 
	       
        return a;
	}

	public List<Project> getprojectbyassignedto(String assigned_to) {

		 List<Project> pro=dao.getprojectbyid(assigned_to);
		return pro;
	}

	

}
