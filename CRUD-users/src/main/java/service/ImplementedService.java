package service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataAccessObject.UserDAOimp;
import model.User;

@Service
@Transactional
public class ImplementedService implements UserService{

	@Autowired
	UserDAOimp userDAO ;

	@Transactional
	@Override
	public int addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public List<User> list() {
		return userDAO.list();
	}

	@Override
	public User getUser(int id) {
		return userDAO.getuser(id);
	}

	@Transactional
	@Override
	public void update(int id, User user) {
		 userDAO.update(id, user);
		
	}

	@Override
	public void delete(int id) {
		 userDAO.delete(id);
	}

}
