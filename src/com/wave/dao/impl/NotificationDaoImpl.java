package com.wave.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.wave.dao.NotificationDao;
import com.wave.model.Notification;



public class  NotificationDaoImpl implements NotificationDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public int addNotificationForDepartment(String title,String content,int depart_id,int type){
		Map<String ,String> map=new HashMap<String, String>();
		map.put("title",title);
		map.put("content", content);
		map.put("department_id", depart_id+"");
		map.put("type",type+"");
		return sqlSessionTemplate.insert("addNotificationsForDepartment", map);
	}
	public Notification query(int id){
		Map<String, Integer>map=new HashMap<String, Integer>();
		map.put("notificationid", id);
		System.out.println("id:"+id);
		return sqlSessionTemplate.selectOne("queryAllNotificationsById", map);
	}

	public Notification addNotificationForDepartment(String title,
			String content, int depart_id, int type, String url) {
		// TODO Auto-generated method stub
		int result;
		if(url==null||url.equals("")){
			result=addNotificationForDepartment(title, content, depart_id, type);
		}else{
			Map<String ,String> map=new HashMap<String, String>();
			map.put("title",title);
			map.put("content", content);
			map.put("department_id", depart_id+"");
			map.put("type",type+"");
			map.put("url", url);
			result= sqlSessionTemplate.insert("addNotificationsUrlForDepartment", map);
		}
		return query(result);
	}
}