package com.qtong.healthcare.ahx.service.impl;

import com.qtong.healthcare.ahx.dao.common.UserDao;
import com.qtong.healthcare.ahx.model.User;
import com.qtong.healthcare.ahx.service.IAccountService;
import com.qtong.healthcare.ahx.utils.EndecryptUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by ZML on 2015/4/22.
 */
@Service
public class AccountService implements IAccountService {

    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void saveUser(User user){

     EndecryptUtils.md5Password(user);

        userDao.save(user);

    }

    @Override
    public User queryUserByUsername(String username) {


        return userDao.queryUserByName(username);
    }

    @Override
    public Set<String> queryUserRoles(String username) {

        userDao.queryUserRoles(username);


        return userDao.queryUserRoles(username);
    }

    @Override
    public Set<String> queryUserPermissions(String username) {
        return userDao.queryUserPermissions( username);
    }
}
