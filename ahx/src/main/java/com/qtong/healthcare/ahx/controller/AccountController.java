package com.qtong.healthcare.ahx.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qtong.healthcare.ahx.model.Action;
import com.qtong.healthcare.ahx.model.Role;
import com.qtong.healthcare.ahx.model.User;
import com.qtong.healthcare.ahx.service.IAccountService;

/**
 * Created by ZML on 2015/4/22.
 */

@Controller
public class AccountController {

	private IAccountService accountService;

	@Resource
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(name = "/init")
	public String initSystem() {

		User root = new User();

		root.setEnabled(true);

		root.setLocked(false);

		root.setUsername("root");
		
		root.setPassword("root");

		root.setRoles(adminRole());

		accountService.saveUser(root);
		return "/";
	}

	private Set<Role> adminRole() {

		Set<Role> roles = new HashSet<>();

		Role root = new Role();

		root.setActions(adminActions());

		root.setRoleName("root");

		Role admin = new Role();

		admin.setActions(adminActions());

		admin.setRoleName("root");

		roles.add(root);

		roles.add(admin);

		return roles;

	}

	private Set<Action> adminActions() {
		Set<Action> actions = new HashSet<>();

		Action adduser = new Action();

		adduser.setName("adduser");

		adduser.setRemark("添加用户");

		adduser.setPath("account:adduser:root");

		Action deluser = new Action();

		deluser.setName("deluser");

		adduser.setRemark("删除用户");

		adduser.setPath("account:deluser:root");

		Action updateUser = new Action();

		adduser.setName("updateuser");

		adduser.setRemark("添加用户");

		adduser.setPath("account:updateuser:root");

		Action listuser = new Action();

		adduser.setName("listuser");

		adduser.setRemark("添加用户");

		adduser.setPath("account:listuser:root");

		actions.add(listuser);

		actions.add(adduser);

		actions.add(updateUser);

		actions.add(deluser);

		return actions;

	}
}
