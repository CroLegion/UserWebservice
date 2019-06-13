package dataAccessObject;

import java.util.List;

import model.User;

public interface UserDAO {

	int addUser(User user);
	List<User> list();
	User getuser(int id);
	void update(int id, int id2);
	void delete(int id);
	
}
