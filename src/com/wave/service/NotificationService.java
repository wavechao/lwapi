package com.wave.service;

import com.wave.model.Notification;

public interface NotificationService {
	public void addNotificationForDepartment(String title,String content,int depart_id,int type);

	public Notification addNotificationForDepartment(String title,
			String content, int depart_id, int type, String url);

}
