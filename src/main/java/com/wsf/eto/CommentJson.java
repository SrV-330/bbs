package com.wsf.eto;

import java.util.List;

import com.wsf.entity.Page;
import com.wsf.entity.Post;

public class CommentJson {
	
	public CommentJson(){
		super();
	}
	
	private List<Post> posts;
	
	private Page page;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
