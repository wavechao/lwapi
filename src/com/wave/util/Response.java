package com.wave.util;

public class Response {
	private int code;
	private String message="ok";
	private Object object;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public void setCode(int code) {
		this.code=code;
		switch (code) {
		case 200:
			message="成功";
			break;
		case 400:
			message="参数错误";
			break;
		case 401:
			message="需要验证信息";
			break;
		case 403:
			message="没有权限";
			break;
		case 404:
			message="请求失败";
			break;
		case 500:
			message="服务器错误";
		case 502:
			message="服务器错误";
		}
	}

}
