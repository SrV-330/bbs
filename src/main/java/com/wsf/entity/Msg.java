package com.wsf.entity;

public class Msg {
	
	private long mid;
	private User fu;
	private User tu;
	private PostHead rphd;
	private Post rpp;
	private String mTime;
	private int mType;
	private int isGlance;
	private int isCheck;
	
	
	public final static int MZAN=1;
	public final static int MTOLZ=2;
	public final static int MTOCZ=3;
	
	public final static int GLANCE=2;
	public final static int UNGLANCE=1;
	
	public final static int CHECK=2;
	public final static int UNCHECK=1;
	
	
	public Msg(){
		super();
	}

	
	
	
	public Msg(User fu, User tu, PostHead rphd, Post rpp, String mTime, int mType, int isGlance, int isCheck) {
		super();
		this.fu = fu;
		this.tu = tu;
		this.rphd = rphd;
		this.rpp = rpp;
		this.mTime = mTime;
		this.mType = mType;
		this.isGlance = isGlance;
		this.isCheck = isCheck;
	}




	public long getMid() {
		return mid;
	}


	public void setMid(long mid) {
		this.mid = mid;
	}


	public User getFu() {
		return fu;
	}


	public void setFu(User fu) {
		this.fu = fu;
	}


	public User getTu() {
		return tu;
	}


	public void setTu(User tu) {
		this.tu = tu;
	}


	public PostHead getRphd() {
		return rphd;
	}


	public void setRphd(PostHead rphd) {
		this.rphd = rphd;
	}


	public Post getRpp() {
		return rpp;
	}


	public void setRpp(Post rpp) {
		this.rpp = rpp;
	}


	public int getmType() {
		return mType;
	}


	public void setmType(int mType) {
		this.mType = mType;
	}


	public int getIsGlance() {
		return isGlance;
	}


	public void setIsGlance(int isGlance) {
		this.isGlance = isGlance;
	}


	public int getIsCheck() {
		return isCheck;
	}


	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}


	public String getMtime() {
		return mTime;
	}


	public void setMtime(String mTime) {
		this.mTime = mTime;
	}
	

}
