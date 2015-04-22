package com.qtong.healthcare.ahx.dao.common;

import com.qtong.healthcare.ahx.dao.IBaseDao;
import com.qtong.healthcare.ahx.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by ZML on 2015/4/16.
 */
public interface UserDao extends IBaseDao{

    /*
    *
    * 根据User对象的某些属性查询此用户
    */
    List<User> queryUser(String username,String password);

    void saveUser(User user);

}
