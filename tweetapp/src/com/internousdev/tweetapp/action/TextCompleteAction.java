package com.internousdev.tweetapp.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.TextInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TextCompleteAction extends ActionSupport implements SessionAware{
	private String id;
	private String text;
	private Map<String,Object>session;

	public String execute(){
		TextInfoDAO textInfoDAO=new TextInfoDAO();
		String result = ERROR;

		int count = 0;
		int res = 0;

		if(id == null){
			count = textInfoDAO.setTextInfo(session.get("userName").toString(),text);
			if(count>0){
				result = SUCCESS;
			}
		}else{
			res = textInfoDAO.updateContent(text, id);
			if(res>0){
				result = SUCCESS;
				session.remove("updateFlag");
			}
		}
		return result;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
