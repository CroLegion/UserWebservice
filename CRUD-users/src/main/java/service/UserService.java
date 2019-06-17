package service;

import java.util.List;

import model.User;

/**
 * @author jstil
 */
public interface UserService {
	/*
	 * 
	 */
	int addUser(User user);
	/*
	 * 
	 */
	List<User> list();
	/*
	 * 
	 */
	User getUser(int id);
	/*
	 * 
	 */
	void update(int id, User user);
	/*
	 * 
	 */
	void delete(int id);
}
