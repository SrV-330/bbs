package com.wsf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsf.entity.PostHead;

public interface PostHeadDao {
	public PostHead query(
			@Param("hd") PostHead hd) throws SQLException;
	public PostHead queryById(long id) throws SQLException;
	public List<PostHead> queryByPage(
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public List<PostHead> queryByPageByPostHead(
			@Param("hd") PostHead hd,
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public int insert(
			@Param("hd") PostHead hd) throws SQLException;
	public int update(
			@Param("hd") PostHead hd) throws SQLException;
	public long count(
			@Param("hd")PostHead hd) throws SQLException;
}
