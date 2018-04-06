package com.wsf.service;

import java.util.List;

import com.wsf.entity.Page;
import com.wsf.entity.Post;
import com.wsf.entity.PostHead;
import com.wsf.entity.User;

public interface PostService {
	
	public Post getPostById(String id);
	public List<Post> getPostByPage(Page page,String id);
	public List<Post> getPostByPage(Post post,Page page);
	public List<Post> locationPostByPage(Page page,String id,String cid);
	public List<Post> getReplyByPage(Page page,String id);
	public List<Post> getPostByKw(Page page,List<String> list);
	public int deletePostById(String id,User user);
	public int undeletePostById(String id,User user);
	public int addPost(PostHead postHead,String content,User user);
	public int addReply(PostHead postHead,String content, User rpu, Post c, User cz, User rp);
	public int addReply(PostHead postHead,String content, User rpu, Post c, User cz);

}
