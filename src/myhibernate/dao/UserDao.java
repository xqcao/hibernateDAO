package myhibernate.dao;

import myhibernate.domain.User;

public interface UserDao {
	public void saveUser(User user);
	public User findUserByName(String name);
	public User findUserById(int id);
	public void updateuser(User user);
	public void remove(User user);
	
}
