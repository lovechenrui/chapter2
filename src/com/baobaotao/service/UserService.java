package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatchUser(String userName,String password){
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	public User findUserByUserName(String userName){
		return userDao.getUserByUserName(userName);
	}
	public void loginSuccess(User user){
		user.setCredits(user.getCredits()+5);
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastip());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginlogInfo(user);
		loginLogDao.insertLoinLog(loginLog);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public LoginLogDao getLoginLogDao() {
		return loginLogDao;
	}
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
	
}
