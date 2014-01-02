package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getMatchCount(String userName,String password){
		String hql = "select count(*) from t_user where user_name=? and password=?";
		return jdbcTemplate.queryForInt(hql,new Object[]{userName,password});
	}
	public User getUserByUserName(final String userName){
		String sqlStr =  "select * from t_user where user_name=?";
		final User user = new User();
		jdbcTemplate.query(sqlStr,new Object[]{userName},
				new RowCallbackHandler(){
			public void processRow(ResultSet rs)throws SQLException{
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(userName);
				user.setCredits(rs.getInt("credits"));
			}
		});
		return user;
	}
	
	public void updateLoginlogInfo(User user){
		String sqlStr = "update t_user set last_visit=?,last_ip=?,credits =? where user_id=?)";
		jdbcTemplate.update(sqlStr, new Object[] { user.getLastVisit(),
				user.getLastip(), user.getCredits(), user.getUserId() });
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
}
