package com.wave.action.notification;

import com.wave.action.BasicAciton;
import com.wave.model.Notification;
import com.wave.service.NotificationService;

/**
 * 给某个系的老师发出题通知
 * 
 * @author Administrator
 * 
 */
public class AddNotificationForDepartmentAction extends BasicAciton {
	private int depart_id;// 系id
	private String title;// 通知标题
	private String content;// 内容
	private String url;// 链接(可选)
	private int type;// 类型 50为发给该系的老师 30为发给该系的学生

	private NotificationService notificationService;

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String execute() {
		if (title == null || title.equals("")) {
			setErrorCode(400,"参数title错误");
			return super.execute();
		}
		if ( content == null|| content.equals("")) {
			setErrorCode(400,"参数content为空");
			return super.execute();
		}
		
		if ( depart_id == 0 ) {
			setErrorCode(400,"参数depart_id不为0");
			return super.execute();
		}
		if ( type == 0 ) {
			setErrorCode(400,"参数type不为0");
			return super.execute();
		}
		
		Notification notification=notificationService.addNotificationForDepartment(title, content, depart_id, type,url);
		if(notification==null){
			setErrorCode(404);//请求失败
			return super.execute();
		}
		response.setCode(200);
		response.setObject(notification);
		return super.execute();

	}
}
