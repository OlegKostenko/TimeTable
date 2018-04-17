package org.itstep.service;

import java.util.List;

import org.itstep.model.Subject;
import org.itstep.model.Teacher;

public interface TeacherService {
	
	Teacher save(Teacher teacher);
	
	Teacher update(Teacher teacher);
	
	Teacher get(String login);
	
	List<Teacher> findAllBySubject(Subject subject);
	
	void delete(String login);
}
