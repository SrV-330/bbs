package com.wsf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsf.entity.Msg;

public interface MsgDao {
	
	public List<Msg> queryByTuid(long id) throws SQLException;
	public List<Msg> queryByPage(
			@Param("msg")Msg msg,
			@Param("limit")long limit,
			@Param("offset")long offset) throws SQLException;
	public int insert(
			@Param("msg")Msg msg) throws SQLException;
	public int update(
			@Param("msg")Msg msg) throws SQLException;
	public int updateByMid(
			@Param("msg")Msg msg,
			@Param("mids")List<Long> mids) throws SQLException;

}
