package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.model.Group;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
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
public class LessonDAOTest {

	Subject subjectInDB;

	Teacher teacherInDB;

	Group groupInDB;

	List<Lesson> lessons = new ArrayList<Lesson>();

	@Autowired
	LessonDAO lessonDAO;

	@Autowired
	SubjectDAO subjectDAO;

	@Autowired
	TeacherDAO teacherDAO;

	@Autowired
	GroupDAO groupDAO;

	@Before
	public void setToDB() {
		Subject subject = new Subject();
		subject.setName("Java");
		subjectInDB = subjectDAO.save(subject);

		Teacher teacher = new Teacher();
		teacher.setFirstName("Oleg");
		teacher.setSecondName("Kostenko");
		teacher.setLogin("Kostenko1443");
		teacher.setPassword("123456");
		teacher.setSubject(subjectInDB);
		teacherInDB = teacherDAO.save(teacher);

		Group testGroup = new Group();
		testGroup.setName("S15P1-26");
		testGroup.setCourse("1");
		testGroup.setSpecialization("JavaQA");
		groupInDB = groupDAO.save(testGroup);

		for (int i = 1; i <= 3; i++) {

			Lesson less = new Lesson();
			less.setSubject(subjectInDB);
			less.setTeacher(teacherInDB);
			less.setCabinet("111");
			less.setGroup(groupInDB);
			less.setStartTime((long) 45 * i);
			
			lessons.add(lessonDAO.save(less));
		}
	}
	
	@Test
	public void testFindAllByStartTime() {
		List<Lesson> lessons = lessonDAO.findAllByStartTime(0L, 100L);

		assertNotNull(lessons);

		assertEquals(2, lessons.size());

		assertEquals(lessons.get(0).getGroup().getName(), "S15P1-26");
		assertEquals(lessons.get(0).getGroup().getName(), lessons.get(1).getGroup().getName());

		assertEquals(lessons.get(0).getTeacher().getLogin(), "Kostenko1443");
		assertEquals(lessons.get(0).getTeacher().getLogin(), lessons.get(1).getTeacher().getLogin());
		
		List<Lesson> allLessons = lessonDAO.findAllByStartTime(0L, 150L);
		
		assertEquals(3, allLessons.size());
	}
	
	@After
	public void cleanDB() {
		for (Lesson lesson : lessons) {
			lessonDAO.delete(lesson);
		}
		groupDAO.delete(groupInDB);
		teacherDAO.delete(teacherInDB);
		subjectDAO.delete(subjectInDB);

	}

}
