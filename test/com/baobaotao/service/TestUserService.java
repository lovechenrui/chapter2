package com.baobaotao.service;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService {
	@Autowired
	private UserService userService;
	
	@Test
	public void hasMatchUser(){
		boolean b1 = userService.hasMatchUser("admin","123456");
		boolean b2 = userService.hasMatchUser("admin", "123456");
		assertTrue(b1);
		assertTrue(b2);
	}
	public void findUserByUserName(String userName){
		User user = userService.findUserByUserName(userName);
		assertEquals(user.getUserName(),"admin");
	}
	public UserService getUserService() {
		return userService;
	}
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
