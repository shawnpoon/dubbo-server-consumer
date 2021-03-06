package com.shawn.server.consumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shawn.server.core.http.ResponseHandler;
import com.shawn.server.core.shiro.AccountManager;
import com.shawn.server.core.shiro.AuthenticationUser;
import com.shawn.server.core.util.JsonUtil;
import com.shawn.server.web.api.UserService;

@Controller
public class WebUserController {

	@Reference
	private UserService userService;
	@Reference
	private AccountManager<AuthenticationUser> accountManager;

	@RequestMapping("/test")
	public void test(HttpServletRequest request, HttpServletResponse response, Model model) {
		boolean user = accountManager.login("hehehe", "hahaha");
		String json = JsonUtil.Object2JsonStr(user);
		ResponseHandler.outputJson(response, json);
	}

}
