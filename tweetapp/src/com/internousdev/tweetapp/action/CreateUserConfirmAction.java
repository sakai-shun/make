package com.internousdev.tweetapp.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.UserInfoDAO;
import com.internousdev.tweetapp.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private String loginId;
	private String loginPass;
	private String userName;
	private List<String> loginIdErrorMessageList;
	private List<String> loginPassErrorMessageList;
	private List<String> userNameErrorMessageList;
	private String errorMessage;


	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		session.put("loginId",loginId);
		session.put("loginPass", loginPass);
		session.put("userName", userName);

		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1,8,true,false,false,true,false,false);
		loginPassErrorMessageList = inputChecker.doCheck("パスワード",loginPass,1,16,true,false,false,true,false,false);
		userNameErrorMessageList = inputChecker.doCheck("ユーザー名", userName, 1,16,true,false,false,true,false,false);

		if(loginIdErrorMessageList.size()>0
			|| loginPassErrorMessageList.size()>0
			|| userNameErrorMessageList.size()>0){
			return result;
		}
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		if(userInfoDAO.isExistsUser(loginId)){
			errorMessage = "使用できないユーザーIDです。";
		}else{
			result = SUCCESS;
		}
		return result;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getLoginPassErrorMessageList() {
		return loginPassErrorMessageList;
	}

	public void setLoginPassErrorMessageList(List<String> loginPassErrorMessageList) {
		this.loginPassErrorMessageList = loginPassErrorMessageList;
	}

	public List<String> getUserNameErrorMessageList() {
		return userNameErrorMessageList;
	}

	public void setUserNameErrorMessageList(List<String> userNameErrorMessageList) {
		this.userNameErrorMessageList = userNameErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}

}
