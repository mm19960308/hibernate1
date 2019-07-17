package com.woniu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.woniu.a.HibernateUtils;
import com.woniu.a.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public String save() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		return "findAll";
	}
	
	public String delete() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
		return "findAll";
	}
	
	public String update() {
	    Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
		return"findAll";

	}
	
	public String findAll() {
		Session session = HibernateUtils.openSession();
		session.beginTransaction();
		
		String hql = "FROM User";
		Query q = session.createQuery(hql);
		List<User> list = q.list();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		
		session.getTransaction().commit();
		session.close();
		return "index";
	}
	@Override
	public User getModel() {
		return user;
	}
	
}
