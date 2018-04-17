package org.itstep.service;

import java.util.List;

import org.itstep.model.Group;

public interface GroupService {

	List<Group> findAllByCourse(String course);
}
