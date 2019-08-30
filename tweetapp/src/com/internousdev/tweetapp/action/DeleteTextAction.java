package com.internousdev.tweetapp.action;

import com.internousdev.tweetapp.dao.TextInfoDAO;
import com.opensymphony.xwork2.ActionSupport;
public class DeleteTextAction extends ActionSupport{

	private String id;

	public String execute(){
		TextInfoDAO textInfoDAO = new TextInfoDAO();

		int count = 0;
		count = textInfoDAO.deleteContent(id);
		if(count>0){
			return SUCCESS;
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
