package com.ys.sec.service.impl;

import com.ys.sec.entity.SysUser;
import com.ys.sec.mapper.UserMapper;
import com.ys.sec.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ysx
 * @since 2021-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public SysUser queryUserByUsername(String username) {

        return userMapper.queryUserByUsername(username);
    }
}
