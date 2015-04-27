package com.qtong.healthcare.ahx.dao.common.impl;

import com.google.common.base.Preconditions;
import com.qtong.healthcare.ahx.dao.BaseDao;
import com.qtong.healthcare.ahx.dao.common.UserDao;
import com.qtong.healthcare.ahx.model.Role;
import com.qtong.healthcare.ahx.model.User;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ZML on 2015/4/16.
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@SuppressWarnings("unchecked")
	public List<User> queryUser(String username, String password) {

		return getSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).list();
	}

	public void saveUser(User user) {

        super.save(user);

	}

    @Override
    public User queryUserByName(String username) {
        return (User) createCriteria(User.class).add(Restrictions.eq("username",username)).uniqueResult();
    }

    @Override
    public Set<String> queryUserRoles(String username) {

        User user=queryUserByName(username);

        Preconditions.checkNotNull(user,"用户名为'"+ username+"'的用户不存在");

        Set<Role> roles=user.getRoles();

        Set<String> rolenames=new HashSet<String>();

        for (Role role:roles){
            rolenames.add(role.getRoleName());
        }
        return rolenames;
    }

    @Override
    public Set<String> queryUserPermissions(String username) {
        return null;
    }

}
