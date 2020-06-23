package com.examplle.examplespringboot.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public String fname="F:\\SANDY\\Accolite\\Project\\Logs.log";

	public int addProjectService(String title, String description, String assigned_to, String posted_by,String last_date) {
			int ans=dao.addproject(title,description,assigned_to,posted_by,last_date);
			String str=title+" " +description+" "+assigned_to+" "+last_date+" is added to database by "+posted_by+".\n";
			logFile(fname,str);
		return ans;
	}

	public List<Project> getProjectService() {
		 List<Project> cou = dao.getproject();
		return cou;
	}

	public int deleteProjectService(String email,int pid) {
		int ans=dao.delete(pid);
		String str=email+" is deleted the project from  to db "+pid+".\n";
		logFile(fname,str);
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

	
	private void logFile(String fname, String str) {
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(fname,true)); 
			bw.write(str);
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
