package com.wsf.entity;

public class Gag {
	
	
	private long gid;
	private User gu;
	
	private User ou;
	
	private String startTime;
	private String endTime;
	private int gagType;
	private int gagRs;
	
	public static final int UNGAG=1;
	public static final int GAG=2;
	
	public Gag(){
		super();
	}
	
	
	
	public Gag(long gid,  int gagType) {
		super();
		this.gid = gid;
		this.gagType = gagType;
	}



	public Gag(User gu, User ou, String startTime, String endTime, int gagType, int gagRs) {
		super();
		this.gu = gu;
		this.ou = ou;
		this.startTime = startTime;
		this.endTime = endTime;
		this.gagType = gagType;
		this.gagRs = gagRs;
	}



	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}

	public User getGu() {
		return gu;
	}
	public void setGu(User gu) {
		this.gu = gu;
	}

	public User getOu() {
		return ou;
	}
	public void setOu(User ou) {
		this.ou = ou;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public int getGagType() {
		return gagType;
	}
	public void setGagType(int gagType) {
		this.gagType = gagType;
	}
	public int getGagRs() {
		return gagRs;
	}
	public void setGagRs(int gagRs) {
		this.gagRs = gagRs;
	}



	@Override
	public String toString() {
		return "Gag [gid=" + gid + ", gu=" + gu + ", ou=" + ou + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", gagType=" + gagType + ", gagRs=" + gagRs + "]";
	}
	
	
	

}
