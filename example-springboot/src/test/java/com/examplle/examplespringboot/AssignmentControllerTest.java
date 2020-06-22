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

import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.AssignmentCompletion;
import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.ProjectCompletion;
import com.fasterxml.jackson.databind.ObjectMapper;








@RunWith(SpringRunner.class)
@SpringBootTest

public class AssignmentControllerTest {
	
	
	 @Autowired
	    private WebApplicationContext webApplicationContext;

	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    }
		

		ObjectMapper om = new ObjectMapper();
		
		
		Assignment assignment=new Assignment();
			
			public Assignment getAssignmentforTest()
			{
				 
				assignment.setTitle("Calculator Application");
				assignment.setDescription("Use oops Concepts");
				assignment.setMailid("v.sandhiya@accoliteindia.com");
				assignment.setLast_date("2020/10/10");
				return assignment;
			}
		
		
		@Test
		public void addAssignmentTest() throws Exception {
			Assignment assign=new Assignment();
			assign.setTitle("Calculator Application");
			assign.setDescription("Use oops Concepts");
			assign.setMailid("v.sandhiya@accoliteindia.com");
			assign.setLast_date("2020/10/10");
			String jsonRequest=om.writeValueAsString(assign);
			mockMvc.perform(post("/assignment/addassignment").content(jsonRequest)
					.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
			

		}
		
		
		@Test
		public void getAllAssignmentTest() throws Exception {
			 mockMvc.perform(get("/assignment/getassignment").content(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
			

		}
		

		@Test
		public void deleteProject_ProjectIdValue_ReturnsString() throws Exception {
			mockMvc.perform(delete("/assignment/deleteassignment/9").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();

		}
		@Test
		public void addSubmitResponseTest() throws Exception {
			AssignmentCompletion pro_com=new AssignmentCompletion ();
			pro_com.setId(13);
			pro_com.setTitle("Calculator Application");
			pro_com.setGrad_mailid("asramogal@gmail.com");
			
			pro_com.setSubmitted(true);
			String jsonRequest=om.writeValueAsString(pro_com);
			mockMvc.perform(post("/assignment/submit_assignment").content(jsonRequest)
					.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
			

		}
		@Test
		public void getAllAssignmentSubmissionsTest() throws Exception {
			 mockMvc.perform(get("/assignment/getsubmissions").content(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andReturn();
			

		}


}
