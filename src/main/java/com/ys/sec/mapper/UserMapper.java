package com.ys.sec.mapper;

import com.ys.sec.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ysx
 * @since 2021-05-10
 */
public interface UserMapper extends BaseMapper<SysUser> {
    SysUser queryUserByUsername(String username);
}
