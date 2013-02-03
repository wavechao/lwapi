package com.wave.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wave.model.User;

public interface UserDao {
	/**获取老师
	 * @param id
	 * @return
	 */
	public User queryTeacher(int id);
	public User updateUserAll(User user);
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
	/**
	 * 查找所有的用戶
	 * 
	 * @return
	 */
	List queryAll();

	/**
	 * 用戶登陆
	 * 
	 * @param username
	 *            用戶名
	 * @param password
	 *            密码
	 * @return 用户实例
	 */
	User login(@Param("username") String username,
			@Param("password") String password);

	/**
	 * 删除一个用户
	 * 
	 * @param userid
	 *            用户的id
	 */
	void deleteUser(@Param("userid") long userId);

	/**
	 * 查询一个用户
	 * 
	 * @param userid
	 *            用户的id
	 * @return 用户实例
	 */
	User queryUserById(@Param("userid") long userId);

	void addUser(@Param("username") String username,
			@Param("password") String password,
			@Param("screenname") String screenname);

	/**增加用户
	 * @param user screenname，gender，level，departmentid,majorid
	 * @return
	 */
	User addUser(User user);

	/**更新用户信息
	 * @param user  email,gender ,screename,password可选 
	 * @return
	 */
	User updateUser(User user);
	
	/**更新用户头像
	 * @param user 
	 * @return
	 */
	User updateUserPicUrl(User user);
	/**获取某个用户
	 * @param userid  用户id
	 * @return
	 */
	public User findUser(int userid);
	/**分页获取某个系的老师
	 * @param depart_id
	 * @param count
	 * @param page
	 * @return
	 */
	public List<User> getTeacher(int depart_id,int count ,int page);
	
	
	/**设置某个老师为出题老师
	 * 返回什么
	 * @param id
	 */
	public User levelup(int id);
	public User levelup(String id);
	
	/**取消某个老师出题资格
	 * @param id
	 */
	public User leveldown(int id);

	User updateUserPassword(User user);

	User leveldown(String id);
	public User findUser(String username);
	
	
	
}