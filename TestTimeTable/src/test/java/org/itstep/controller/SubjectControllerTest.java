package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.itstep.ApplicationRunner;
import org.itstep.model.Group;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.itstep.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SubjectControllerTest {
	
	Subject subject = new Subject();
	
	@MockBean
	SubjectService subjectService;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Before
	  public void setPreData() {

	    
	    subject.setName("QWAS");

	  }

	@Test
	public void testSave() {
		
		
		
		Mockito.when(subjectService.save(Mockito.any(Subject.class))).thenReturn(subject);
		
		RequestEntity<Subject> request = null;
		try {
			request = new RequestEntity<Subject>(subject, HttpMethod.POST, new URI("/subject"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		ResponseEntity<Subject> response = restTemplate.exchange(request, Subject.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Mockito.verify(subjectService, Mockito.times(1)).save(Mockito.any(Subject.class));
	}
	
	@Test
	public void testDelete() throws URISyntaxException {
		Mockito.doNothing().when(subjectService).delete(Mockito.any(Subject.class));
		  
		RequestEntity<Subject> request = new RequestEntity<Subject> (subject, HttpMethod.POST, new URI("/subject"));
		ResponseEntity<Subject> response = restTemplate.exchange(request, Subject.class);
		  
		assertEquals(HttpStatus.OK, response.getStatusCode());
		Mockito.verify(subjectService, Mockito.times(1)).save(Mockito.any(Subject.class));
	}


}
