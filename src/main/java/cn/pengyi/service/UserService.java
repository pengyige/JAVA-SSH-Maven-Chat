package cn.pengyi.service;

import org.springframework.transaction.annotation.Transactional;

import cn.pengyi.dao.UserDao;
import cn.pengyi.domain.User;


public class UserService {
	//依赖注入
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public void save(User user){
		userDao.save(user);
	}


	public User findUser(User user) {
		// TODO Auto-generated method stub
		return userDao.find(user);
	}


	public boolean findUserIsExist(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserIsExist(username);
	}


	public void updateUser(User user) {
		
		userDao.update(user);	
	}


	public User findUserById(String userId) {
		// TODO Auto-generated method stub
		return userDao.find(userId);
	}
}
