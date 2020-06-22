package com.examplle.examplespringboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examplle.examplespringboot.Repository.ProjectDao;
import com.examplle.examplespringboot.model.Project;
import com.examplle.examplespringboot.model.ProjectCompletion;


@RunWith(SpringRunner.class)
@SpringBootTest

public class ProjectDaoTest {
	
	@Autowired
    ProjectDao dao;
	
	ProjectControllerTest protest = new ProjectControllerTest();
	
	
	@Test
    public void addProjectTest() {
		Project pro = protest.getProjectforTest();
		
        int status = dao.addproject(pro.getTitle(),pro.getDescription(),pro.getAssigned_to(),pro.getPosted_by(),pro.getLast_date());
 
        assertNotNull(pro);
        assertEquals(1, status);
    }
	
	@Test
    public void getAllProjectTest() {
        List<Project> allProjects = dao.getproject();
 
        assertNotNull(allProjects);
        assertEquals(25,allProjects.size());
    }
	

   /* public void getAllProjectSubmissionsTest() {
        List<ProjectCompletion> allProjectSubmissions = dao.getsubmission();
 
        assertNotNull(allProjectSubmissions);
        assertEquals(5,allProjectSubmissions.size());
    }*/
    

}
