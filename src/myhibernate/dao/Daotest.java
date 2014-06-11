package myhibernate.dao;

import java.util.Date;

import myhibernate.dao.impl.UserDaoHibernateImpl;
import myhibernate.domain.User;

public class Daotest {

	public static void main(String[] args) {
		UserDao dao = new UserDaoHibernateImpl();
		User user = new User();
		user.setName("name");
		user.setBirthday(new Date());
		System.out.println("1111111111");
		dao.saveUser(user);
		
		user.setName("new name");
		System.out.println("22222222222");
		dao.updateuser(user);
		
		User u = dao.findUserByName(user.getName());
		
		System.out.println("333333");
		dao.remove(u);

	}

}
