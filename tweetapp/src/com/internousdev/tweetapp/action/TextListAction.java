package com.internousdev.tweetapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.TextInfoDAO;
import com.internousdev.tweetapp.dao.UserInfoDAO;
import com.internousdev.tweetapp.dto.TextInfoDTO;
import com.internousdev.tweetapp.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class TextListAction extends ActionSupport implements SessionAware{

	private List<TextInfoDTO>textInfoAllList;
	private List<TextInfoDTO>textInfoList;
	private Map<String,Object>session;

	public String execute(){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		TextInfoDAO textInfoDAO = new TextInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String result = SUCCESS;

		if(userInfoDAO.isExsitsLoginUser()){
			userInfoDTO = userInfoDAO.getUserName(session.get("loginId").toString());
			textInfoList = textInfoDAO.getTextInfo(userInfoDTO.getUserName());
			result = "list";
		}else{
			textInfoAllList = textInfoDAO.getTextInfoAll();
		}
		return result;
	}
	public List<TextInfoDTO> getTextInfoAllList() {
		return textInfoAllList;
	}
	public void setTextInfoAllList(List<TextInfoDTO> textInfoAllList) {
		this.textInfoAllList = textInfoAllList;
	}
	public List<TextInfoDTO> getTextInfoList() {
		return textInfoList;
	}
	public void setTextInfoList(List<TextInfoDTO> textInfoList) {
		this.textInfoList = textInfoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}