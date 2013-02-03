package com.wave.service;

import java.util.List;

import com.wave.model.User;

/**
 * 类说明：
 * 
 * @author 作者: 波潮
 * @version 创建时间：2012-12-25 
 */
public interface UserService {

	/**增加用户
	 * @param user screenname，gender，level，departmentid,majorid
	 * @return
	 */
	public abstract User addUser(User user);
	/**更新用户信息
	 * @param user  email,gender ,screename,password可选 
	 * @return
	 */
	public abstract User updateUser(User user);
	
	/**
	 * 删除一个用户
	 * 
	 * @param userid
	 *            用户的id
	 */
	public abstract void deleteUser(long userId);
	/**
	 * 查询一个用户
	 * 
	 * @param userid
	 *            用户的id
	 * @return 用户实例
	 */
	public abstract User queryUserById(long userId);
	/**
	 * 查找所有的用戶
	 * 
	 * @return
	 */
	public abstract List<User> findAllUser();
	/**
	 * 用戶登陆
	 * 
	 * @param username
	 *            用戶名
	 * @param password
	 *            密码
	 * @return 用户实例
	 */
	public abstract User login(String username,String password);

	public abstract void addUser(String username, String password,
			String screenname);
	/**更新用户头像
	 * @param user 
	 * @return
	 */
	public abstract User updateUserPicUrl(User user);
	/**获取某个用户
	 * @param userid  用户id
	 * @return
	 */
	public User findUser(int userid);
	/**获取权限比level大的用户
	 * @param depart_id	部门id
	 * @param major_id	专业id
	 * @param count		单页可以显示的数量
	 * @param page		页码
	 * @param level		权限
	 * @return  
	 */
	public List<User>getUserLittlerLevel(int depart_id,int major_id,int count,int page,int level );
	
	/**获取权限比level小的用户
	 * @param depart_id	部门id
	 * @param major_id	专业id
	 * @param count		单页可以显示的数量
	 * @param page		页码
	 * @param level		权限
	 * @return 
	 * @return
	 */
	public List<User>getUserBiggerLevel(int depart_id,int major_id,int count,int page,int level ,int userlevel);
	/**分页获取某个系的老师
	 * @param depart_id
	 * @param count
	 * @param page
	 * @return
	 */
	public List<User>getTeacher(int depart_id,int count,int page);
	/**获取权限等于level的用户
	 * @param depart_id	部门id
	 * @param major_id	专业id
	 * @param count		单页可以显示的数量
	 * @param page		页码
	 * @param level		权限
	 * @return 
	 * @return
	 */
	public List<User>getUser(int depart_id,int major_id,int count,int page,int level );
	
	public  User updateUserPassword(User user);

	/**设置某个老师为出题老师
	 * 返回什么？
	 * @param id
	 */
	public User levelup(int id);
	public User levelup(String id);
	/**取消某个老师出题资格
	 * @param id
	 */
	public User leveldown(int id);
	public User leveldown(String id);
	public User updateUserAll(User user);
	public User queryTeacher(int id);
	public abstract User findUser(String username);
}