package org.itstep.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.dao.TeacherDAO;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationRunner.class})
public class TeacherServiceTest {
	
	@Autowired
	TeacherService teaherService;
	
	@MockBean
	TeacherDAO teacherDao;
	
	@Test
	public void testFindAllBySubject() {
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher());
		Mockito.when(teacherDao.findAllBySubject(Mockito.any(Subject.class))).thenReturn(teachers);
		
		List<Teacher> teachersFromDB = teaherService.findAllBySubject(new Subject());
		
		assertNotNull(teachersFromDB);
	}

}
