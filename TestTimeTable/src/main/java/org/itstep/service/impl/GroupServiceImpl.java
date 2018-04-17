package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.GroupDAO;
import org.itstep.model.Group;
import org.itstep.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService{

	@Autowired
	GroupDAO groupDao;
	
	public List<Group> findAllByCourse(String course) {
		return groupDao.findAllByCourse(course);
	}

}
