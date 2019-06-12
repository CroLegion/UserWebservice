package dataAccessObject;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDAOimp implements UserDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public int addUser(User user) {
		sessionfactory.getCurrentSession().save(user);
		return user.getUserID();
	}
	@Override
	public List<User> list() {
		Session session = sessionfactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<User> cq = cb.createQuery(User.class);
	    Root<User> root = cq.from(User.class);
	    cq.select(root);
	    Query<User> query = session.createQuery(cq);
	    return query.getResultList();
	   }

	@Override
	public User getUser(int id) {
		return sessionfactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void update(int id, User user) {
		Session session = sessionfactory.getCurrentSession();
		User userNew = session.byId(User.class).load(id);
		userNew.setFirstName(user.getFirstName());
		userNew.setLastName(user.getLastName());
		userNew.setEmail(user.getEmail());
		userNew.setSecuritylevel(user.getSecuritylevel());
		userNew.setUserID(user.getUserID());
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionfactory.getCurrentSession();
		User userNew = session.byId(User.class).load(id);
		session.delete(userNew);
	}
	

}
