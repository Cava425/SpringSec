package com.ys.sec.service;

import com.ys.sec.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ysx
 * @since 2021-05-10
 */
public interface IUserService extends IService<SysUser> {
    SysUser queryUserByUsername(String username);
}
