package com.examplle.examplespringboot.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplle.examplespringboot.Repository.AssignmentDao;
import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.AssignmentCompletion;

@Service
public class AssignmentService {
	@Autowired
    public AssignmentDao dao;
	
	public String fname="F:\\SANDY\\Accolite\\Project\\Logs.log";

	public int addResponseService(int id, String title, String grad_mailid, boolean submitted) {
		int ans=dao.addresponse(id,title,grad_mailid,submitted);
		String str="Candidate with mailId: " + grad_mailid + " submitted the assignment\n";
		logFile(fname,str);
		return ans;
	}

	public int addAssignmentService(String title, String description, String mailid, String last_date) {
		int ans=dao.addassign(title,description,mailid,last_date);
		String str=title+" " +description+" "+last_date+" is added to database by "+mailid+".\n";
		logFile(fname,str);
		return ans;
	}

	public List<Assignment> getAssignmentService() {
		List<Assignment> a = dao.getassignment(); 
	       
        return a;
    }

	public int deleteAssignmentService(String email,int a_id) {
		int ans=dao.delete(a_id);
		String str=email+" is deleted the assignment from  to db "+a_id+".\n";
		logFile(fname,str);
		return ans;
	
	}

	public List<AssignmentCompletion> getSubmissionService() {
		List<AssignmentCompletion> a = dao.getsubmission(); 
	       
        return a;
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
