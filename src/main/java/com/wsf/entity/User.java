package com.wsf.entity;


public class User {
	
	private long uid;
	private String userName;
	private String userPwd;
	private int userType;
	private String regTime;
	private int isGag;
	
	public final static int ADMIN=1;
	public final static int VIPUSER=2;
	public final static int USER=3;
	
	public final static int UNGAG=1;
	public final static int GAG=2;
	
	public User() {
		
	}
	
	
	public User(String userName, String userPwd, int userType, String regTime, int isGag) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.regTime = regTime;
		this.isGag = isGag;
	}


	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public int getIsGag() {
		return isGag;
	}
	public void setIsGag(int isGag) {
		this.isGag = isGag;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", userPwd=" + userPwd + ", userType=" + userType
				+ ", regTime=" + regTime + ", isGag=" + isGag + "]";
	}
	

}
