package com.internousdev.tweetapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private String backFlag="";

	public String execute(){
		String result = SUCCESS;

		System.out.println(backFlag);
		if(backFlag == ""){
			session.remove("loginId");
			session.remove("loginPass");
			session.remove("userName");
		}
		return result;

	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
	public String getBackFlag() {
		return backFlag;
	}
	public void setBackFlag(String backFlag) {
		this.backFlag = backFlag;
	}

}
