package com.internousdev.tweetapp.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TextAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	private String editFlag ="";
	public String execute(){

		if(editFlag == ""){
			session.remove("text");
		}
		return SUCCESS;
	}
	public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
