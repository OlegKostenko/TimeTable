package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.Group;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAO{

	@Autowired
	HibernateUtil hiber;

	public Group save(Group group) {

		Session session = hiber.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.saveOrUpdate(group);

		session.getTransaction().commit();

		session.close();

		if (getOne(group.getName()) != null) {
			return group;
		}

		return null;
	}

	public Group getOne(String name) {

		Session session = hiber.getSessionFactory().openSession();

		session.getTransaction().begin();

		Group group = session.get(Group.class, name);

		session.getTransaction().commit();

		session.close();

		return group;
	}

	public void delete(Group group) {
		
		Session session = hiber.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.delete(group);

		session.getTransaction().commit();

		session.close();
	}
}
