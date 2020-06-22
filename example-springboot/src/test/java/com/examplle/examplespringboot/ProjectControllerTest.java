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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.examplle.examplespringboot.model.Candidate;
import com.examplle.examplespringboot.model.Project;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	

	ObjectMapper om = new ObjectMapper();

	
	
Project project=new Project();
	
	public Project getProjectforTest()
	{
		 
		 project.setTitle("opportunity module");
		 project.setDescription("Do testing");
		 project.setAssigned_to("swetha05101998@gmail.com");
		 project.setPosted_by("v.sandhiya@accoliteindia.com");
		 project.setLast_date("2020/10/10");
		
		return project;
	}

	
	@Test
	public void addProjectTest() throws Exception {
		Project pro=new Project();
		pro.setTitle("opportunity module");
		pro.setDescription("Do testing");
		pro.setAssigned_to("swetha05101998@gmail.com");
		pro.setPosted_by("v.sandhiya@accoliteindia.com");
		pro.setLast_date("2020-10-10");
		String jsonRequest=om.writeValueAsString(pro);
		mockMvc.perform(post("/project/addproject").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		

	}
	

	@Test
	public void getAllProjectTest() throws Exception {
		 mockMvc.perform(get("/project/getprojects").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		

	}
	@Test
	public void getAllProjectSubmissionsTest() throws Exception {
		 mockMvc.perform(get("/project/getsubmissions").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		

	}
	
	
	@Test
	public void deleteProject_ProjectIdValue_ReturnsString() throws Exception {
		mockMvc.perform(delete("/project/deleteproject/7").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

	}

	@Test
	public void getAllProjectDetailsByAssignedtoTest() throws Exception {
		 mockMvc.perform(get("/project/getproject/asramogal@gmail.com").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		

	}
	
    


}
