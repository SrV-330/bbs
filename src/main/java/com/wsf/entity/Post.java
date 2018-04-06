package com.wsf.entity;

public class Post {
	
	private long pid;
	private String postContent;
	private String postTime;
	private PostHead hd;
	
	private Post c;
	
	private User cz;
	
	private User rp;
	
	private User rpu;
	
	private int postType;
	private int zan;
	private int isDel;
	
	public final static int REPLYTOLZ=1;
	public final static int REPLYTOUSER=2;
	
	public final static int UNDEL=1;
	public final static int DEL=2;
	
	
	public Post(){
		super();
	}
	
	
	
	public Post(String postContent, String postTime, PostHead hd, User rpu, int postType, int zan, int isDel) {
		super();
		this.postContent = postContent;
		this.postTime = postTime;
		this.hd = hd;
		this.rpu = rpu;
		this.postType = postType;
		this.zan = zan;
		this.isDel = isDel;
	}

	

	public Post(String postContent, String postTime,  PostHead hd, Post c, User cz, User rpu, int postType,
			int zan, int isDel) {
		super();
		this.postContent = postContent;
		this.postTime = postTime;
		this.hd = hd;
		this.c = c;
		this.cz = cz;
		this.rpu = rpu;
		this.postType = postType;
		this.zan = zan;
		this.isDel = isDel;
	}

	

	public Post(String postContent, String postTime, PostHead hd, Post c, User cz, User rp, User rpu,
			int postType, int zan, int isDel) {
		super();
		this.postContent = postContent;
		this.postTime = postTime;
		this.hd = hd;
		this.c = c;
		this.cz = cz;
		this.rp = rp;
		this.rpu = rpu;
		this.postType = postType;
		this.zan = zan;
		this.isDel = isDel;
	}



	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public PostHead getHd() {
		return hd;
	}
	public void setHd(PostHead hd) {
		this.hd = hd;
	}

	public Post getC() {
		return c;
	}
	public void setC(Post c) {
		this.c = c;
	}

	public User getCz() {
		return cz;
	}
	public void setCz(User cz) {
		this.cz = cz;
	}

	public User getRp() {
		return rp;
	}
	public void setRp(User rp) {
		this.rp = rp;
	}

	public User getRpu() {
		return rpu;
	}
	public void setRpu(User rpu) {
		this.rpu = rpu;
	}
	public int getPostType() {
		return postType;
	}
	public void setPostType(int postType) {
		this.postType = postType;
	}
	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}



	@Override
	public String toString() {
		return "Post [pid=" + pid + ", postContent=" + postContent + ", postTime=" + postTime + ", hd=" + hd + ", c="
				+ c + ", cz=" + cz + ", rp=" + rp + ", rpu=" + rpu + ", postType=" + postType + ", zan=" + zan
				+ ", isDel=" + isDel + "]";
	}
	
	

}
