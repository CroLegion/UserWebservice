package dataAccessObject;

import java.util.List;

import model.User;

public interface UserDAO {

	int addUser(User user);
	List<User> list();
	User getUser(int id);
	void update(int id, User user);
	void delete(int id);
	
}
