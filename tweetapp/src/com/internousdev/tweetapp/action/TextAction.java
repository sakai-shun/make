package com.internousdev.tweetapp.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.TextInfoDAO;
import com.internousdev.tweetapp.dto.TextInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TextAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private int id;
	private String editFlag;

	public String execute(){
		if(editFlag == "1") {
			TextInfoDAO textInfoDAO = new TextInfoDAO();
			TextInfoDTO textInfoDTO = new TextInfoDTO();
			textInfoDTO = textInfoDAO.getTextInfoById(id);
			session.put("text", textInfoDTO.getContent());
			session.put("updateFlag", "1");
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
