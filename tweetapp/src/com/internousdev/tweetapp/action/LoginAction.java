package com.internousdev.tweetapp.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.tweetapp.dao.UserInfoDAO;
import com.internousdev.tweetapp.dto.UserInfoDTO;
import com.internousdev.tweetapp.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String loginPass;
	private List<String> loginIdErrorMessageList;
	private String isNotUserInfoMessage;
	private List<String> loginPassErrorMessageList;
	private Map<String,Object> session;

	public String execute(){

		String result = ERROR;
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID",loginId,1,8,true,false,false,true,false,false);
		loginPassErrorMessageList = inputChecker.doCheck("パスワード",loginPass,1,16,true,false,false,true,false,false);

		if(loginIdErrorMessageList.size()>0 || loginPassErrorMessageList.size()>0){
			return result;
		}
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		if(userInfoDAO.isExistsUserInfo(loginId,loginPass)){


				userInfoDAO.updateLoginFlag(loginId, loginPass);
				userInfoDTO = userInfoDAO.getUserName(loginId);

				session.put("loginId", loginId);
				session.put("loginPass",loginPass);
				session.put("userName", userInfoDTO.getUserName());
				session.put("loginFlag", 1);
				
				session.remove("logoutFlag");
			result = SUCCESS;

		}else{
			isNotUserInfoMessage ="ユーザーIDまたはパスワードが異なります。";
		}
		return result;
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

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public String getIsNotUserInfoMessage() {
		return isNotUserInfoMessage;
	}

	public void setIsNotUserInfoMessage(String isNotUserInfoMessage) {
		this.isNotUserInfoMessage = isNotUserInfoMessage;
	}

	public List<String> getLoginPassErrorMessageList() {
		return loginPassErrorMessageList;
	}

	public void setLoginPassErrorMessageList(List<String> loginPassErrorMessageList) {
		this.loginPassErrorMessageList = loginPassErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
