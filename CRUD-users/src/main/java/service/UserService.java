package service;

import java.util.List;

import model.User;

public interface UserService {

	int addUser(User user);
	List<User> list();
	User getUser(int id);
	void update(int id, int id2);
	void delete(int id);
}
