package com.internousdev.tweetapp.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.TextInfoDAO;
import com.internousdev.tweetapp.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class TextCompleteAction extends ActionSupport implements SessionAware{
	private String id;
	private String text;
	private Map<String,Object>session;
	private List<String> textErrorMessageList;

	public String execute(){
		InputChecker inputChecker=new InputChecker();
		TextInfoDAO textInfoDAO=new TextInfoDAO();
		textErrorMessageList = inputChecker.doCheck("テキスト",text,1,160,true,true,true,true,true,false);
		String result = ERROR;

		int count = 0;
		int res = 0;

		if(textErrorMessageList.size()>0){
			return result;

		}else if(id == null){
			count = textInfoDAO.setTextInfo(session.get("userName").toString(),text);
			if(count>0){
				result = SUCCESS;
			}
		}else{
			res = textInfoDAO.updateContent(text, id);
			if(res>0){
				result = SUCCESS;
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

	public List<String> getTextErrorMessageList() {
		return textErrorMessageList;
	}

	public void setTextErrorMessageList(List<String> textErrorMessageList) {
		this.textErrorMessageList = textErrorMessageList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}