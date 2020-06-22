package com.examplle.examplespringboot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examplle.examplespringboot.Repository.AssignmentDao;
import com.examplle.examplespringboot.Repository.ProjectDao;
import com.examplle.examplespringboot.model.Assignment;
import com.examplle.examplespringboot.model.Project;


@RunWith(SpringRunner.class)
@SpringBootTest

public class AssignmentDaoTest {
	@Autowired
    AssignmentDao dao;
	
	AssignmentControllerTest assign = new AssignmentControllerTest();
	
	@Test
    public void addAssignmentTest() {
		Assignment assignment = assign.getAssignmentforTest();
		
        int status = dao.addassign(assignment.getTitle(),assignment.getDescription(),assignment.getMailid(),assignment.getLast_date());
 
        assertNotNull(assignment);
        assertEquals(1, status);
    }

}
