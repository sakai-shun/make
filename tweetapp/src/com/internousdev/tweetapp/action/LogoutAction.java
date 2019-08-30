package com.internousdev.tweetapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;
public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute(){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.logout(session.get("loginId").toString(),session.get("loginPass").toString());
		if(count>0){
			session.clear();
		}
		return SUCCESS;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}