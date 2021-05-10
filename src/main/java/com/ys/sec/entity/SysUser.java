package com.ys.sec.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ysx
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 权限
     */
    private String authorities;

    /**
     * 是否过期
     */
    private Integer isExpired;

    /**
     * 是否锁定
     */
    private Integer isLocked;

    /**
     * 凭证是否过期
     */
    private Integer credentialsExpired;

    /**
     * 是否启用
     */
    private Integer isEnabled;


}
