package com.gabenstore.dao;

import java.security.Principal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gabenstore.modal.Cart;
import com.gabenstore.modal.User;
import com.google.gson.Gson;

@Repository
public class UserDAOImp implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(User user) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		Cart cart=new Cart();
		cart.setCartID(user.getUserID());
		cart.setUserID(user.getUserID());
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	public List<User> displayUser() 
	{
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

	public void deleteUser(int userID) {
		User userDelete=new User();
		userDelete.setUserID(userID);
		sessionFactory.getCurrentSession().delete(userDelete);		
	}

	public User updateUser(int userID) {
		List<User> getList = sessionFactory.getCurrentSession().createQuery("from User where userID = "+userID).getResultList();
		return getList.get(0);
	}

	public String displayUserByJson() 
	{
		List<User> list=sessionFactory.getCurrentSession().createQuery("from User").getResultList();
		Gson g=new Gson();
		String jsonList=g.toJson(list);
		return jsonList;
	}
	
	public User getUserByName(String s)
	{		
		List<User> list=sessionFactory.getCurrentSession().createQuery("from User where userName='"+s+"'").getResultList();
		return list.get(0);
	}
	

}
