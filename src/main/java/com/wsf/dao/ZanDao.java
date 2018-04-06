package com.wsf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsf.entity.Zan;

public interface ZanDao {
	public List<Zan> query(
			@Param("zan") Zan zan) throws SQLException;
	public List<Zan> queryByPage(
			@Param("zan") Zan zan,
			@Param("limit") long limit,
			@Param("offset") long offset) throws SQLException;
	public Zan queryById(long id) throws SQLException;
	public List<Zan> queryByZuid(long id) throws SQLException;
	public List<Zan> queryByZpid(long id) throws SQLException;
	public int insert(
			@Param("zan") Zan zan) throws SQLException;
	public int update(
			@Param("zan") Zan zan) throws SQLException;
	public long count(
			@Param("zan") Zan zan) throws SQLException;
}
