package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.model.Group;
import org.itstep.model.Student;
import org.junit.After;
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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentDAOTest {

	Group groupInDB;
	Student studentInDB;

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	GroupDAO groupDAO;

	@Before
	public void setPreData() {

		Group testGroup = new Group();

		testGroup.setName("ST21");
		testGroup.setCourse("1");
		testGroup.setSpecialization("JavaQA");

		groupInDB = groupDAO.save(testGroup);
		
		Student student = new Student();
		
		student.setLogin("Ignatenko2207");
		student.setPassword("123456");
		student.setFirstName("Alex");
		student.setSecondName("Ignatenko");
		student.setGroup(groupInDB);

		studentInDB = studentDAO.save(student);
	}

	@Test
	public void testFindAllByGroup() {

		List<Student> students = studentDAO.findAllByGroup(groupInDB.getName());
		
		assertNotNull(students);
		
		assertEquals(1, students.size());
		
		assertEquals(students.get(0).getLogin(), "Ignatenko2207");
		
		assertEquals(students.get(0).getGroup().getName(), "ST21");
		
	}
	
	@After
	public void cleanDB() {
		studentDAO.delete(studentInDB);
		groupDAO.delete(groupInDB);
	}

}
