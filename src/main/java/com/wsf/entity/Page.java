package com.wsf.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	public static final int PAGER_RECORD = 10;
	public static final int GROUP_RECORD = 10;
	private int currentPage;
	private int currentGroup;
	private int pageCount;
	private int recordCount;
	private List<Integer> groupList;

	private String url;
	
	private String param;
	
	
	public Page() {
		super();
	}

	public Page(int page) {
		super();
		this.currentPage = page;
	}

	
	
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrevPage() {
		if (currentPage <= 1)
			return 1;
		else
			return currentPage - 1;
	}

	public int getNextPage() {
		if (currentPage < pageCount)
			return currentPage + 1;
		else
			return pageCount;

	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentGroup() {

		return currentGroup;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {

		this.pageCount = (int) Math.ceil((double) recordCount / PAGER_RECORD);

		this.recordCount = recordCount;
	}

	public List<Integer> getGroupList() {
		this.groupList = new ArrayList<Integer>();
		this.currentGroup = (int) Math.ceil((double) this.currentPage / GROUP_RECORD);
		int start = 0, end = 0;
		start = (this.currentGroup - 1) * GROUP_RECORD;
		end = start + GROUP_RECORD < this.pageCount ? start + GROUP_RECORD : pageCount;
		for (int i = start + 1; i <= end; i++) {
			this.groupList.add(i);

		}

		return groupList;
	}

	public void setGroupList(List<Integer> groupList) {
		this.groupList = groupList;
	}

}
