package com.internousdev.tweetapp.action;

import java.util.List;

import com.internousdev.tweetapp.dao.TextInfoDAO;
import com.internousdev.tweetapp.dto.TextInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TextListAction extends ActionSupport{

	private List<TextInfoDTO>textInfoList;
	public String execute(){
		TextInfoDAO textInfoDAO = new TextInfoDAO();

		textInfoList = textInfoDAO.getTextInfoAll();
		return SUCCESS;
	}
	public List<TextInfoDTO> getTextInfoList() {
		return textInfoList;
	}
	public void setTextInfoList(List<TextInfoDTO> textInfoList) {
		this.textInfoList = textInfoList;
	}
}