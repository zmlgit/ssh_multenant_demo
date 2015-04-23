package com.qtong.healthcare.ahx.service;

import com.qtong.healthcare.ahx.model.User;

import java.util.Set;

/**
 * Created by ZML on 2015/4/22.
 */
public interface IAccountService {

    public void saveUser(User user);


    public User queryUserByUsername(String username);

    Set<String> queryUserRoles(String username);

    Set<String> queryUserPermissions(String username);
}
