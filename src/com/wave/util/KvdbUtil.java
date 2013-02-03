package com.wave.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.sina.sae.kvdb.SaeKV;
import com.sina.sae.kvdb.SaeKVUtil;
import com.wave.model.Department;
import com.wave.model.Major;
import com.wave.model.Time;
import com.wave.model.User;

public class KvdbUtil {
	private final static SaeKV saeKV = new SaeKV();
	static {
		saeKV.init();
	}

	/**从sae KVDB中获取用户实例
	 * @param username 用户名
	 * @return  user对象
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static User getUserFromKv(String username)
			throws ClassNotFoundException, IOException {
		System.out.println("dbkv return user--->username="+username);
		return SaeKVUtil.deserializable(saeKV.get(username));
	}

	/**将用户存入DBKV数据库中
	 * @param user 用户实例，键值为username
	 * @throws IOException
	 */
	public static void setUserToKv(User user) throws IOException {
		System.out.println("dbkv set user--->username="+user.getUsername());
		saeKV.set(user.getUsername(), SaeKVUtil.serializable(user));
	}
	
	/**将系别存入DBKV数据库中
	 * @param department 系别实例，键值为deptid
	 * @throws IOException
	 */
	public static void setDepartmentToKv(Department department)throws IOException{
		System.out.println("dbkv set  department--->deptid="+department.getDeptid());
		saeKV.set("departments:"+department.getDeptid(), SaeKVUtil.serializable(department));
	}
	/**
	 * @param id 系别id
	 * @return	系别实例
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Department getDepartmentFromKv(String id)
			throws ClassNotFoundException, IOException {
		System.out.println("dbkv return department--->deptid="+id);
		return SaeKVUtil.deserializable(saeKV.get("departments:"+id));
	}
	/** 将所有系的数据存入kvdb中去
	 * @param departments
	 * @throws IOException
	 */
	public static void setAllDepartmentToKv (List<Department> departments)throws IOException{
		System.out.println("dbkv set alldepartments");
		saeKV.set("allDepartments",  SaeKVUtil.serializable(departments));
	}
	
	/** 将所有系的数据从kvdb取出
	 * @return 系别集合
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static List<Department> getAllDepartment() throws ClassNotFoundException, IOException{
		System.out.println("dbkv return alldepartments");
		return SaeKVUtil.deserializable(saeKV.get("allDepartment"));
	}
	/**将专业信息存入kvdb中去
	 * @param major 用户实例
	 * @throws IOException
	 */
	public static void setMajorsToKv(Major major) throws IOException{
		System.out.println("dbkv set major:"+major);
		saeKV.set("major:"+major.getMajorid(), SaeKVUtil.serializable(major));
	}
	/**
	 * @param majorid 专业id
	 * @return 专业实例
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Major getMajorFromKv(String majorid)throws ClassNotFoundException, IOException{
		System.out.println("dbkv return major:"+majorid);
		return SaeKVUtil.deserializable("departments:"+majorid);
	}
	
	
	public static Time getDateInfoFromKv() throws ClassNotFoundException, IOException{
		System.out.println("dbkv get dateinfo");
		Time time= SaeKVUtil.deserializable(saeKV.get("dateinfo"));
		System.out.println("time:"+(time==null));
		return time;
	}
	public static void setDateInFromKv(Time time) throws IOException{
		System.out.println("dbkv set dateinfo");
		System.out.println("time==null?"+(time==null));
		saeKV.set("dateinfo",SaeKVUtil.serializable(time));
	}
	public static void delete(String key){
		System.out.println("删除key:"+key+"的缓存");
		saeKV.rdel(key,key,true,true,1);
	}
	public static void deleteUser(String username){
		System.out.println("删除username:"+username+"的缓存");
		delete(username);
	}
}
