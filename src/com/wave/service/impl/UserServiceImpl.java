package com.wave.service.impl;

import java.util.List;

import com.wave.dao.UserDao;
import com.wave.model.User;
import com.wave.service.UserService;

/**
 * 类说明：
 * 
 * @author 作者: LiuJunGuang
 * @version 创建时间：2012-3-25 下午02:31:11
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User addUser(User user) {
		
		return userDao.addUser(user);
	}

	public User updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	public void deleteUser(long userId) {
		userDao.deleteUser(userId);
	}

	public User queryUserById(long userId) {
		
		return userDao.queryUserById(userId);
	}

	public List<User> findAllUser() {
		
		return  userDao.queryAll();
	}

	public User login(String username,String password) {
		
		return userDao.login(username, password);
	}

	public void addUser(String username, String password, String screenname) {
		
		userDao.addUser( username,  password,  screenname);
	}

	public User updateUserPicUrl(User user) {
		
		return userDao.updateUserPicUrl(user);
	}

	public User findUser(int userid) {
		
		return userDao.findUser(userid);
	}

	public List<User> getTeacher(int depart_id,int count,int page) {
		
		return userDao.getTeacher(depart_id,count,page);
	}

	public User updateUserPassword(User user) {
		
		return userDao.updateUserPassword(user);
	}

	public User levelup(int id) {
		
		return userDao.levelup(id);
	}

	public User leveldown(int id) {
		
		return userDao.leveldown(id);
	}
	
	public User levelup(String idStr){
		
		return userDao.levelup(idStr);
	}

	public User leveldown(String id) {
		
		return userDao.leveldown(id);
	}

	public List<User> getUser(int depart_id, int major_id, int count, int page,
			int level) {
		
		return userDao.getUser(depart_id, major_id, count, page, level);
	}

	public List<User> getUserLittlerLevel(int depart_id, int major_id,
			int count, int page, int level) {
		
		return userDao.getUserLittlerLevel(depart_id, major_id, count, page, level);
	}

	public List<User> getUserBiggerLevel(int depart_id, int major_id,
			int count, int page, int level,int userlevel) {
		
		return userDao.getUserBiggerLevel(depart_id, major_id, count, page, level,userlevel);
	}
	public User updateUserAll(User user){
		return userDao.updateUserAll(user);
	}

	public User queryTeacher(int id) {
		// TODO Auto-generated method stub
		return userDao.queryTeacher(id);
	}

	public User findUser(String username) {
		// TODO Auto-generated method stub
		return userDao.findUser(username);
	}

}