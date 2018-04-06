package com.wsf.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.wsf.entity.User;

public interface UserDao {
	
	
	public int insert(
			@Param("user") User user) throws SQLException;
	public User queryById(long id) throws SQLException;
	public User queryByName(String name) throws SQLException;
	public User query(
			@Param("user") User user) throws SQLException;
	public int update(
			@Param("user") User user) throws SQLException;
	public List<User> queryByPage(
			@Param("user") User user,
			@Param("limit") int limit,
			@Param("offset") int offset) throws SQLException;
	public long count(
			@Param("user") User user) throws SQLException;
	

}
