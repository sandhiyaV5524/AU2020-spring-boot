package com.examplle.examplespringboot;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.examplle.examplespringboot.controller.AssessmentController;
import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.Candidate;
import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.ProjectCompletion;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssessmentControllerTest {
	

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Autowired
	private AssessmentController ac;
	

	ObjectMapper om = new ObjectMapper();
	
	
	Candidate candidate=new Candidate();
	
	public Candidate getCandidateforUpdateTest()
	{
		 candidate.setEmp_no(102);
		 candidate.setName("asra");
		 candidate.setEmailId("asramogal@gmail.com");
		 candidate.setProject_mark(0);
		 candidate.setAssignment_mark(0);
		
		return candidate;
	}

	
	@Test
	public void validateUser_UserObjectValues_ReturnsString() {

		assertEquals("Login sucessfull and User is Authenticated",ac.login("sandhiyas198@gmail.com","sandhiyas198@gmail.com"));
	}
	@Test
	public void getAllCandidateDetailsTest() throws Exception {
		 mockMvc.perform(get("/enter/getcandidate").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		

	}
	
	@Test
	public void addScoreResponseTest() throws Exception {
		ProjectCompletion proc=new ProjectCompletion();
		proc.setTitle("Candidate Management");
		proc.setCompletion(">50%");
		
		proc.setTesting("unit-testing");
		
		proc.setCode_Coverage(">50%");
		proc.setMailId("asramogal@gmail.com.com");
		String jsonRequest=om.writeValueAsString(proc);
		mockMvc.perform(post("/enter/submit_response").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		

	}
	
    @Test
	public void getCandidateProfileById() throws Exception {
		       mockMvc.perform(get("/enter/getprofile/navinv@gmail.com").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.emp_no").value(103)).andExpect(jsonPath("$.name").value("navin"))
				.andExpect(jsonPath("$.emailId").value("navinv@gmail.com")).
				andExpect(jsonPath("$.project_mark").value(50)).andExpect(jsonPath("$.assignment_mark").value(0));;
				
				

	}
	

	@Test
	public void UpdateScoreTest() throws Exception
	{
		
		Candidate candidate = getCandidateforUpdateTest();
		candidate.setProject_mark(50);
		
	
		
		
      String jsonRequest = om.writeValueAsString(candidate);
		
		
	mockMvc.perform(put("/enter/updatescore").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	
	
	}
	@Test
	public void UpdateAssignmentScoreTest() throws Exception
	{
		
		Candidate candidate = getCandidateforUpdateTest();
		candidate.setAssignment_mark(50);
		
	
		
		
      String jsonRequest = om.writeValueAsString(candidate);
		
		
	mockMvc.perform(put("/enter/updateassignmentscore").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	
	
	}
	
	

}
