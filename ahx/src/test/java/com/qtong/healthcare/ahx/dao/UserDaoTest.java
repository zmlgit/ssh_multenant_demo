package com.qtong.healthcare.ahx.dao;

import com.qtong.healthcare.ahx.dao.common.UserDao;
import com.qtong.healthcare.ahx.model.*;
import com.qtong.healthcare.ahx.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

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
        User user=new User();
        user.setUsername("admin3");

        user.setPassword("admin");
      //  userDao.list(user,"username");

        accountService.saveUser(user);

        System.out.println(user);
    }


    private void update(){
        UserDao userDao=context.getBean(UserDao.class);
        User user=new User();
        user.setUsername("admin1");
        user.setPassword("admin");
       userDao.save(user);
    }
}
