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
		System.out.println(user.getFirstname());
		sessionfactory.getCurrentSession().save(user);
		return user.getUserid();
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
	public User getuser(int id) {
		System.out.println(id);
		return sessionfactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void update(int id, int id2) {
		Session session = sessionfactory.getCurrentSession();
		User userNew = session.byId(User.class).load(id);
//		userNew.setFirstname(id2.getFirstname());
//		userNew.setLastname(id2.getLastname());
//		userNew.setEmail(id2.getEmail());
//		userNew.setSecuritylevel(id2.getSecuritylevel());
//		userNew.setUserid(id2.getUserid());
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionfactory.getCurrentSession();
		User userNew = session.byId(User.class).load(id);
		session.delete(userNew);
	}
	

}
