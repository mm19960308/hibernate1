package com.woniu.a;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

public class App {
	@Test
	public void testadd() throws Exception {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("Ì«°×½ðÐÇ");
		user.setBirthday(new Date());
		user.setMoney(2.0);
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/woniu/a/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("ÕÅÈý");
		user.setBirthday(new Date());
		user.setMoney(21.1);
		user.setId(1);
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void testdelete() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/woniu/a/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setId(2);
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testFindOne() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/woniu/a/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testFindAll() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/woniu/a/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		String hql = "FROM User";
		Query q = session.createQuery(hql);
		List list = q.list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
}
