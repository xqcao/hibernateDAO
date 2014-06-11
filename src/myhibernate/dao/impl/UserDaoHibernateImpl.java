package myhibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import myhibernate.dao.UserDao;
import myhibernate.dao.hibernateUitl;
import myhibernate.domain.User;

public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void saveUser(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = hibernateUitl.getSession();
			tx=s.beginTransaction();
			s.save(user);
			tx.commit();
		} finally {
			if (s!= null) {
				s.close();
			}
		}

	}

	@Override
	public User findUserByName(String name) {
		Session s = null;
		try {
			s = hibernateUitl.getSession();
			Criteria c = s.createCriteria(User.class);
			c.add(Restrictions.eq("name",name));
			User user = (User) c.uniqueResult();//name  是唯一的 
			return user;
		} finally {
			if (s!= null) {
				s.close();
			}
		}
	}

	
	public User findUserByName1(String name) {//fa 2
		Session s = null;
		try {
			s = hibernateUitl.getSession();
			String hql = "from User as user where user.name=:name";
			Query q = s.createQuery(hql);
			q.setString("n", name);
			User user = (User) q.uniqueResult();//name  是唯一的 
			return user;
		} finally {
			if (s!= null) {
				s.close();
			}
		}
	}
	
	
	@Override
	public User findUserById(int id) {
		Session s = null;
		try {
			s = hibernateUitl.getSession();
			User user = (User) s.get(User.class,id);
			return user;
		} finally {
			if (s!= null) {
				s.close();
			}
		}
	}

	@Override
	public void updateuser(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = hibernateUitl.getSession();
			tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		} finally {
			if (s!= null) {
				s.close();
			}
		}

	}

	@Override
	public void remove(User user) {
		Session s = null;
		Transaction tx = null;
		try {
			s = hibernateUitl.getSession();
			tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
		} finally {
			if (s!= null) {
				s.close();
			}
		}

	}

}
