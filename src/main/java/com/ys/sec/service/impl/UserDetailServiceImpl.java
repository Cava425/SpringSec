package com.ys.sec.service.impl;

import com.ys.sec.entity.SysUser;
import com.ys.sec.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    IUserService iUserService;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username == null || StringUtils.isEmpty(username))
            throw new UsernameNotFoundException("用户名不能为空");

        // 根据username查询数据库
        SysUser user = iUserService.queryUserByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("用户名或密码不正确");

        // 根据查询对象比较密码


        // 返回用户对象

        return new User(user.getUsername(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
