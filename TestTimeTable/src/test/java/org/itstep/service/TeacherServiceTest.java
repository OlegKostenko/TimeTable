package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.ApplicationRunner;
import org.itstep.dao.SubjectDAO;
import org.itstep.dao.TeacherDAO;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TeacherServiceTest {

	
	

	@Autowired
	Subject subjectInDB;
	
	@Autowired
	TeacherService service;
	
	@Autowired
	TeacherDAO teacherDAO;
	
	@Autowired
	SubjectDAO subjectDAO;
	
	@Before
	public void setDataToDB() {
		Subject sub1 = new Subject();
		sub1.setName("C++");
		subjectInDB = subjectDAO.save(sub1);
		
		for(int i = 0; i < 3; i++) {
		
			Teacher teacher1 = new Teacher();
			teacher1.setLogin("kostenko"+(i+1));
			teacher1.setSubject(subjectInDB);
			teacher1.setPassword("12345");
			teacher1.setFirstName("Oleg");
			teacher1.setSecondName("Kostenko");
			
			teacherDAO.save(teacher1);
		}
	}
	
	@Test
	public void testFindAllBySubject() {
		
	}

}
