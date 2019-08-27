package com.internousdev.tweetapp.dto;

public class UserInfoDTO {

	private int id;
	private String loginId;
	private String loginPass;
	private String userName;
	private int loginFlag;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(int loginFlag) {
		this.loginFlag = loginFlag;
	}
}
