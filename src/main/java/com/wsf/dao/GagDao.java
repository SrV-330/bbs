package com.wsf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.wsf.entity.Gag;

public interface GagDao {
	public List<Gag> query(
			@Param("gag")Gag gag);
	public Gag queryById(long id) throws SQLException;
	public List<Gag> queryTopByGuid(
			@Param("id")long id,
			@Param("limit")long limit,
			@Param("offset")long offset) throws SQLException;
	public List<Gag> queryByGuid(long id) throws SQLException;
	public List<Gag> queryByOuid(long id) throws SQLException;
	public List<Gag> queryByPage(
			@Param("gag")Gag gag,
			@Param("limit") int limit,
			@Param("offset") int offset) throws SQLException;
	public long count(
			@Param("gag") Gag gag) throws SQLException;
	public int insert(
			@Param("gag") Gag gag) throws SQLException;
	public int update(
			@Param("gag") Gag gag) throws SQLException;

}
