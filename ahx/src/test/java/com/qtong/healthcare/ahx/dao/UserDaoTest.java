package com.qtong.healthcare.ahx.dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qtong.healthcare.ahx.dao.common.UserDao;
import com.qtong.healthcare.ahx.model.Action;
import com.qtong.healthcare.ahx.model.Role;
import com.qtong.healthcare.ahx.model.User;
import com.qtong.healthcare.ahx.service.IAccountService;

/**
 * Created by ZML on 2015/4/16.
 */
public class UserDaoTest {

    private ApplicationContext context;

    @Before
    public void  before(){
        context= new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void test(){
        IAccountService accountService=context.getBean(IAccountService.class);

        Action loginAction=new Action("login");

        Action logoutAction=new Action("logout");

        Set<Action> actions=new HashSet<>();

        actions.add(loginAction);

        actions.add(logoutAction);

        Role aRole=new Role();

        aRole.setRoleName("aRole");

        aRole.setActions(actions);


        Set<Role> roles=new HashSet<>();

        roles.add(aRole);

        User user=new User();
        user.setUsername("admin3");

        user.setPassword("admin");

        user.setRoles(roles);

        accountService.saveUser(user);

        System.out.println(user);
    }


 
}
