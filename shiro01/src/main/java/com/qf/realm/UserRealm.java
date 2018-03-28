package com.qf.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * Created by zhaoyu on 2018/3/21.
 */
public class UserRealm extends AuthenticatingRealm{
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //得到用户的输入的用户名
        String principal =(String) token.getPrincipal();//得到用户名
        String credentials = (String)token.getCredentials();//密码
        //从数据库得到用户信息
        String uname="qf";
        String upass="qf";
        //是否从数据库中得到用户信息
        if (!principal.equals(uname)){
            throw new UnknownAccountException("用户名或者密码错误,请重新登录");
        }
        //认证信息返回
        String realmname=getName();//得到自定义的realm
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials,realmname);
        return info;
    }
}
