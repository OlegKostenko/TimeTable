package org.itstep.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.dao.LessonDAO;
import org.itstep.model.Lesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
public class LessonServiceTest {

	@Autowired
	LessonService lessonService;
	
	@MockBean
	LessonDAO lessonDao;
	 
	@Test
	public void testFindAllByStartTimeLongLong() {
		
		List<Lesson> lessons = new ArrayList<Lesson>();
		lessons.add(new Lesson());
		Long t1 = 12345L;
		Long t2 = 321654L;
		Mockito.when(lessonDao.findAllByStartTime(t1, t2)).thenReturn(lessons);
		
		List<Lesson> lessonsFromDB = lessonService.findAllByStartTime(t1, t2);
		
		assertNotNull(lessonsFromDB);
		assertEquals(1, lessonsFromDB.size());
	}

	
}
