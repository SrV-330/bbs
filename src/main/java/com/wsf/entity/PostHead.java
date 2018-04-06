package com.wsf.entity;


public class PostHead {

	private long hdid;
	private String headTitle;
	private String headSimple;
	private String headDetail;
	private User lz;
	
	private String postTime;
	private int isTop;
	private int isGood;
	private int isDel;
	private int isLock;
	
	public final static int UNDEL=1;
	public final static int DEL=2;
	
	public final static int UNLOCK=1;
	public final static int LOCK=2;
	
	public final static int UNTOP=1;
	public final static int TOP=2;
	
	public final static int UNGOOD=1;
	public final static int GOOD=2;
	
	public PostHead(){
		super();
	}
	
	public PostHead(String headTitle, String headSimple, String headDetail, User lz, String postTime, int isTop,
			int isGood, int isDel, int isLock) {
		super();
		this.headTitle = headTitle;
		this.headSimple = headSimple;
		this.headDetail = headDetail;
		this.lz = lz;
		this.postTime = postTime;
		this.isTop = isTop;
		this.isGood = isGood;
		this.isDel = isDel;
		this.isLock = isLock;
	}
	public long getHdid() {
		return hdid;
	}
	public void setHdid(long hdid) {
		this.hdid = hdid;
	}
	public String getHeadTitle() {
		return headTitle;
	}
	public void setHeadTitle(String headTitle) {
		this.headTitle = headTitle;
	}
	public String getHeadSimple() {
		return headSimple;
	}
	public void setHeadSimple(String headSimple) {
		this.headSimple = headSimple;
	}
	public String getHeadDetail() {
		return headDetail;
	}
	public void setHeadDetail(String headDetail) {
		this.headDetail = headDetail;
	}
	public User getLz() {
		return lz;
	}
	public void setLz(User lz) {
		this.lz = lz;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public int getIsTop() {
		return isTop;
	}
	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}
	public int getIsGood() {
		return isGood;
	}
	public void setIsGood(int isGood) {
		this.isGood = isGood;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsLock() {
		return isLock;
	}
	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}
	
	
	public final static String getDetail(String content){
		String s=content;
		if(content.length()>50){
			s=content.substring(0, 50);
		}
		
		return s;
		
	}
	
	@Override
	public String toString() {
		return "PostHead [hdid=" + hdid + ", headTitle=" + headTitle + ", headSimple=" + headSimple + ", headDetail="
				+ headDetail + ", lz=" + lz.toString() + ", postTime=" + postTime + ", isTop=" + isTop + ", isGood=" + isGood
				+ ", isDel=" + isDel + ", isLock=" + isLock + "]";
	}

	
	
	
}
