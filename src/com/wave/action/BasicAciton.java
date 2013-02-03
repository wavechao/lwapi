package com.wave.action;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wave.util.Response;

public class BasicAciton extends ActionSupport implements ServletRequestAware,
		SessionAware, ServletResponseAware {
	private static final long serialVersionUID = 1L;
	protected Response response=new Response();

	protected HttpServletRequest request;
	protected HttpServletResponse httpResponse;
	protected Map<String, Object> session = new HashMap<String, Object>();
	
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.httpResponse = response;

	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public String execute() {
		return SUCCESS;
	}
	protected String check(){
		return "ok";
	}
	protected void setErrorCode(int code) {
		httpResponse.setStatus(code);
		response.setCode(code);
	}
	/**
	 * @param code  错误的代码
	 * @param msg	错误的详细信息
	 */
	protected void setErrorCode(int code,String msg) {
		httpResponse.setStatus(code);
		response.setCode(code);
		response.setMessage(msg);
	}
}
