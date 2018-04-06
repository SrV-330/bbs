package com.wsf.entity;

public class Zan {
	
	private long zid;
	private User zu;
	private Post zp;
	private int zanType;
	
	
	public static final int ZANUP=1;
	public static final int ZANDOWN=-1;
	public static final int ZANNO=0;
	
	public Zan(){
		super();
	}
	
	public Zan(User zu, Post zp){
		super();
		this.zu = zu;
		this.zp = zp;
	}
	public Zan(long zid,int zanType) {
		super();
		this.zid=zid;
		this.zanType = zanType;
	}
	
	public Zan(User zu, Post zp, int zanType) {
		super();
		this.zu = zu;
		this.zp = zp;
		this.zanType = zanType;
	}
	public Zan(long zid,User zu, Post zp, int zanType) {
		super();
		this.zid=zid;
		this.zu = zu;
		this.zp = zp;
		this.zanType = zanType;
	}


	public long getZid() {
		return zid;
	}
	public void setZid(long zid) {
		this.zid = zid;
	}
	
	public User getZu() {
		return zu;
	}
	public void setZu(User zu) {
		this.zu = zu;
	}
	public Post getZp() {
		return zp;
	}
	public void setZp(Post zp) {
		this.zp = zp;
	}
	public int getZanType() {
		return zanType;
	}
	public void setZanType(int zanType) {
		this.zanType = zanType;
	}
	
	

}
