package com.examplle.examplespringboot.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplle.examplespringboot.Repository.AssessmentDao;
import com.examplle.examplespringboot.model.Candidate;
import com.examplle.examplespringboot.model.Chart;

@Service
public class AssessmentService {
	
	@Autowired
    public AssessmentDao dao;
	
	public String fname="F:\\SANDY\\Accolite\\Project\\Logs.log";
	

	public List<String> loginService(String emailId) {
		List<String> repocheck=dao.login(emailId);
		return repocheck;
	}

	public int addResponseService(String title, String completion, String testing, String code_Coverage,
			String mailId) {
		int ans=dao.addresponse(title,completion,testing,code_Coverage,mailId);
		String str=title+" " +completion+" "+testing+" "+code_Coverage+" is added to database by "+mailId+".\n";
		logFile(fname,str);
		return ans;
	}

	

	public List<Candidate> getCandidateService() {
		List<Candidate> a = dao.getcandidate(); 
		return a;
	}

	public Candidate getIdService(String emailId) {
		Candidate can = dao.getid(emailId);
		return can;
	}

	public int updateScoreService(String emailId, int project_mark) {
		int ans=dao.updatescore(emailId,project_mark);
		String str="Candidate with mailId: " + emailId + " got updated\n";
		logFile(fname,str);
		return ans;
	}

	public int updateAssignmentScoreService(String emailId, int assignment_mark) {
		int ans=dao.updateassignmentscore(emailId,assignment_mark);
		String str="Candidate with mailId: " + emailId + " got updated\n";
		logFile(fname,str);
		return ans;
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

	public List<Chart> getChartDataMark() {
		List<Chart> results=new ArrayList<>(); 
 
		int result=dao.getCandidateByMarkGreater(0,20).size();
		int result1=dao.getCandidateByAssignmentMarkGreater(0,20).size();
		Chart c=new Chart("20",result,result1);
		results.add(c);

		 result=dao.getCandidateByMarkGreater(20,40).size();
		 result1=dao.getCandidateByAssignmentMarkGreater(20,40).size();
			c=new Chart("40",result, result1);
			results.add(c);
			 result=dao.getCandidateByMarkGreater(40,60).size();
			 result=dao.getCandidateByAssignmentMarkGreater(40,60).size();
				c=new Chart("60",result,result1);
				results.add(c);
				 result=dao.getCandidateByMarkGreater(60,80).size();
				 result=dao.getCandidateByAssignmentMarkGreater(60,80).size();
					c=new Chart("80",result,result1);
					results.add(c);
					 result=dao.getCandidateByMarkGreater(80,100).size();
					 result=dao.getCandidateByAssignmentMarkGreater(80,100).size();
						c=new Chart("100",result,result1);
						results.add(c);
		return results;
	}
	public List<Chart> getChartDataAssignmentChart() {
		List<Chart> results=new ArrayList<>(); 
 
		int result=dao.getCandidateByAssignmentMarkGreater(0,20).size();
		Chart c=new Chart(result,"20");
		results.add(c);

		 result=dao.getCandidateByAssignmentMarkGreater(20,40).size();
			c=new Chart(result,"40");
			results.add(c);
			
			 result=dao.getCandidateByAssignmentMarkGreater(40,60).size();
				c=new Chart(result,"60");
				results.add(c);
				 result=dao.getCandidateByAssignmentMarkGreater(60,80).size();
					c=new Chart(result,"80");
					results.add(c);
					 result=dao.getCandidateByAssignmentMarkGreater(80,100).size();
						c=new Chart(result,"100");
						results.add(c);
		return results;
	}
	public List<Chart> getChartAssignmentLastDate() {
		List<Chart> results=new ArrayList<>(); 
 
		int result=dao.getAssignmentCountByLastDate("2020-17-06","2020-31-07").size();
		Chart c=new Chart(result,"Aug 30","July 31");
		results.add(c);

		 result=dao.getAssignmentCountByLastDate("2020-11-08","2020-31-09").size();
			c=new Chart(result,"Sep 31","Sep 31");
			results.add(c);
			
			 result=dao.getAssignmentCountByLastDate("2020-19-10","2020-31-11").size();
				c=new Chart(result,"Nov 31","Nov 31");
				results.add(c);
				 result=dao.getAssignmentCountByLastDate("2020-11-12","2020-30-12").size();
					c=new Chart(result,"Dec 30","Dec 30");
					results.add(c);
					
		return results;
	}

	public List<Chart> getChartProjectLastDate() {
		List<Chart> results=new ArrayList<>(); 
		 
		int result=dao.getProjectCountByLastDate("2020-17-06","2020-31-07").size();
		Chart c=new Chart(result,"July 31");
		results.add(c);

		 result=dao.getProjectCountByLastDate("2020-11-08","2020-31-09").size();
			c=new Chart(result,"Sep 31");
			results.add(c);
			
			 result=dao.getProjectCountByLastDate("2020-19-10","2020-31-11").size();
				c=new Chart(result,"Nov 31");
				results.add(c);
				 result=dao.getProjectCountByLastDate("2020-11-12","2020-30-12").size();
					c=new Chart(result,"Dec 30");
					results.add(c);
					
		return results;
	}
}
