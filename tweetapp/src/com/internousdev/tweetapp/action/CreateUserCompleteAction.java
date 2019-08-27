package com.internousdev.tweetapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute(){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		String result = SUCCESS;
		int count = 0;

		count = userInfoDAO.setUserInfo(session.get("loginId").toString(),
									session.get("loginPass").toString(),
									session.get("userName").toString());
		if(count>0){
			session.remove("loginId");
			session.remove("loginPass");
			session.remove("userName");
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
