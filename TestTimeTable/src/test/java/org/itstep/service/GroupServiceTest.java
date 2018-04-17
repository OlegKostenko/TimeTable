package org.itstep.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.dao.GroupDAO;
import org.itstep.model.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)

public class GroupServiceTest {

	@Autowired
	GroupService groupService;

	@MockBean
	GroupDAO groupDao;

	@Test
	public void testfindAllByCourse() {

		List<Group> group = new ArrayList<Group>();
		group.add(new Group());
		String g1 = "first";

		Mockito.when(groupDao.findAllByCourse(g1)).thenReturn(group);

		List<Group> groupFromDB = groupService.findAllByCourse(g1);

		assertNotNull(groupFromDB);

	}

}
