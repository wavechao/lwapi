package com.wave.service.impl;

import com.wave.dao.NotificationDao;
import com.wave.model.Notification;
import com.wave.service.NotificationService;

public class NoficationServiceImpl implements NotificationService{
	private NotificationDao notificationDao;

	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	public void addNotificationForDepartment(String title, String content,
			int depart_id, int type) {
		// TODO Auto-generated method stub
		notificationDao.addNotificationForDepartment( title,  content,
				 depart_id,  type);
	}

	public Notification addNotificationForDepartment(String title,
			String content, int depart_id, int type, String url) {
		// TODO Auto-generated method stub
		return notificationDao.addNotificationForDepartment( title,  content,
				 depart_id,  type,url);
	}

}
