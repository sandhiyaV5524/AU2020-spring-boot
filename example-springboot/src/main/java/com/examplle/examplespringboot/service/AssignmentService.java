package com.examplle.examplespringboot.service;

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

	public int addResponseService(int id, String title, String grad_mailid, boolean submitted) {
		int ans=dao.addresponse(id,title,grad_mailid,submitted);
		return ans;
	}

	public int addAssignmentService(String title, String description, String mailid, String last_date) {
		int ans=dao.addassign(title,description,mailid,last_date);
		return ans;
	}

	public List<Assignment> getAssignmentService() {
		List<Assignment> a = dao.getassignment(); 
	       
        return a;
    }

	public int deleteAssignmentService(int a_id) {
		int ans=dao.delete(a_id);
		return ans;
	
	}

	public List<AssignmentCompletion> getSubmissionService() {
		List<AssignmentCompletion> a = dao.getsubmission(); 
	       
        return a;
	}


}
