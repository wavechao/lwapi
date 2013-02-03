package com.wave.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import com.wave.dao.UserDao;
import com.wave.model.User;
public class UserDaoImpl implements UserDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public List queryAll() {
		RowBounds rw=new RowBounds(2, 3);
		return sqlSessionTemplate.selectList("test","",rw);
	}

	public User login(String username, String password) {
		
		Map<String, String>map=new HashMap<String, String>();
		map.put("myname", username);
		map.put("pwd", password);
		return sqlSessionTemplate.selectOne("login",map);
	}
	public User findUser(int userid){
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("userid", userid);
		return sqlSessionTemplate.selectOne("findUser",map);
	}
	public void deleteUser(long userId){
		Map<String, String>map=new HashMap<String, String>();
		map.put("userid", userId+"");
		sqlSessionTemplate.delete("deleteUser", map);
	}
	public User queryUserById(long userId){
		Map<String, String>map=new HashMap<String, String>();
		map.put("userid", userId+"");
		User user= sqlSessionTemplate.selectOne("findUserById", map);
		return user;
	}

	public void addUser(String username, String password, String screenname) {
		
		Map<String, String>map=new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		map.put("screenname", screenname);
		sqlSessionTemplate.insert("addSimpleUser", map);
	}
	public void add(User user){
		
	}

	public User addUser(User user) {
		
		sqlSessionTemplate.insert("addUser", user);
		return queryUserById(user.getUserid());
	}
	public User updateUser(User user){
		sqlSessionTemplate.update("updateUser", user);
		return queryUserById(user.getUserid());
	}
	public User updateUserPicUrl(User user){
		sqlSessionTemplate.update("updateUserPicUrl", user);
		return queryUserById(user.getUserid());
	}

	public List<User> getTeacher(int depart_id, int count, int page) {
		Map<String,Integer>map=new HashMap<String, Integer>();
		map.put("department_id", depart_id);
		RowBounds rw=new RowBounds((page-1)*count, count); 
		return sqlSessionTemplate.selectList("getTeachers", map,rw);
	}
	
	public List<User>getUser(int depart_id,int major_id,int count,int page,int level ){
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("depart_id", depart_id);
		map.put("major_id", major_id);
		map.put("level", level);
		RowBounds rw=new RowBounds((page-1)*count, count);
		System.out.println("(page-1)*count"+((page-1)*count)+",count:"+count);
		return sqlSessionTemplate.selectList("getUserByLevel", map, rw);
	}
	public List<User>getUserBiggerLevel(int depart_id,int major_id,int count,int page,int level ,int userlevel){
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("depart_id", depart_id);
		map.put("major_id", major_id);
		map.put("level", level);
		map.put("userlevel", userlevel);
		System.out.println("(page-1)*count"+((page-1)*count)+",count:"+count);
		RowBounds rw=new RowBounds((page-1)*count, count);
		
		return sqlSessionTemplate.selectList("getUserBiggerLevel", map, rw);
	}
	public List<User>getUserLittlerLevel(int depart_id,int major_id,int count,int page,int level ){
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("depart_id", depart_id);
		map.put("major_id", major_id);
		map.put("level", level);
		RowBounds rw=new RowBounds((page-1)*count, count);
		return sqlSessionTemplate.selectList("getUserLitterLevel", map, rw);
	}

	public User levelup(int id) {
		Map map=new HashMap<String, Integer>();
		map.put("userid", id);
		sqlSessionTemplate.update("levelup", map);
		return findUser(id);
	}
	public User levelup(String idStr){
		Map map=new HashMap<String, Object>();
		map.put("lists", getList(idStr));
		sqlSessionTemplate.update("levelupTeacher", map);
		return null;
	}

	public User leveldown(int id) {
		Map map=new HashMap<String, Integer>();
		map.put("userid", id);
		sqlSessionTemplate.update("leveldown", map);
		return findUser(id);
		
	}

	public User updateUserPassword(User user) {
		sqlSessionTemplate.update("updateUserPassword", user);
		return queryUserById(user.getUserid());
	}

	public User leveldown(String id) {
		// TODO Auto-generated method stub
		Map map=new HashMap<String, Object>();
		map.put("lists", getList(id));
		sqlSessionTemplate.update("leveldownTeacher", map);
		return null;
	}
	public int[] getList(String str){
		String []code= str.split(",");
		int []array=new int[code.length];
		for(int i=0;i<code.length;i++){
			array[i]=Integer.parseInt(code[i]);
		}
		return array;
	}

	public User updateUserAll(User user) {
		 sqlSessionTemplate.update("updateUserAll", user);
		 return queryUserById(user.getUserid());
	}

	public User queryTeacher(int id) {
		// TODO Auto-generated method stub
		Map<String, String>map=new HashMap<String, String>();
		map.put("userid", id+"");
		return sqlSessionTemplate.selectOne("queryTeacher", map);
	}

	public User findUser(String username) {
		// TODO Auto-generated method stub
		Map<String, String>map=new HashMap<String, String>();
		map.put("username", username);
		return sqlSessionTemplate.selectOne("queryUserByUsername", map);
	}

}
