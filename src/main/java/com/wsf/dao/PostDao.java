package com.wsf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsf.entity.Post;

public interface PostDao {

	
	
	public Post queryById(long id) throws SQLException;
	
	public List<Post> queryByKw(
			@Param("list") List<String> list,
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public List<Post> queryByHdid(
			@Param("hdid") long hdid,
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public List<Post> queryByCid(@Param("cid") long cid,
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public List<Post> queryByPage(
			@Param("post") Post post,
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public int insert(
			@Param("post") Post post) throws SQLException;
	public int update(
			@Param("post") Post post) throws SQLException;
	public long count(
			@Param("post")Post post) throws SQLException;
	public long countByKw(
			@Param("list")List<String> list) throws SQLException;
}
