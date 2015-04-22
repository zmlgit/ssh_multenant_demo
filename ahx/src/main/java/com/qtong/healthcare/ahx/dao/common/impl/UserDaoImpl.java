package com.qtong.healthcare.ahx.dao.common.impl;

import com.qtong.healthcare.ahx.dao.BaseDao;
import com.qtong.healthcare.ahx.dao.common.UserDao;
import com.qtong.healthcare.ahx.model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZML on 2015/4/16.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	public List<User> queryUser(String username, String password) {

		return getSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).list();
	}

	public void saveUser(User user) {

        super.save(user);

	}

}
