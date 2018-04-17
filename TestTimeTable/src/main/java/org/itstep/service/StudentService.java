package org.itstep.service;

import java.util.List;

import org.itstep.model.Group;
import org.itstep.model.Student;

public interface StudentService {

	Student save(Student student);
	
	Student update(Student student);
	
	Student get(String login);
	
	List<Student> findAllByGroup(Group group);
	
	void delete(String login);
}
