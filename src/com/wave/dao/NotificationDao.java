package com.wave.dao;

import com.wave.model.Notification;


public interface NotificationDao {

	int addNotificationForDepartment(String title, String content,
			int depart_id, int type);

	Notification addNotificationForDepartment(String title, String content,
			int depart_id, int type, String url);
    
}