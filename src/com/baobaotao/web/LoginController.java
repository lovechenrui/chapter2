package com.baobaotao.web;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.dao.LoginCommand;
import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	//����index.html������
	@RequestMapping(value="/index")
	public String loginPage(){
		return "login";
	}
	
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassWord());
		if(!isValidUser){
			return new ModelAndView("login","erroe","�û������������");
		}else{
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastip(request.getRemoteAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}