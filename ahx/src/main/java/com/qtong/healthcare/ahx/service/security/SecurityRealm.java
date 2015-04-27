package com.qtong.healthcare.ahx.service.security;

import com.qtong.healthcare.ahx.model.User;
import com.qtong.healthcare.ahx.service.IAccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by ZML on 2015/4/22.
 */
public class SecurityRealm extends AuthorizingRealm{

    private IAccountService accountService;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.fromRealm(getName())
                .iterator().next();

        if (username != null) {

            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

            authorizationInfo.setRoles(accountService.queryUserRoles(username));

            authorizationInfo.setStringPermissions(accountService
                    .queryUserPermissions(username));
            return authorizationInfo;

        }
        return null;
    }


    /**
     * 认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = accountService.queryUserByUsername(token.getUsername());
        if (user==null){
            throw new UnknownAccountException();
        }
        if (user.isLocked()){
            throw new LockedAccountException();
        }
        String.valueOf(user.getPassword());

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
