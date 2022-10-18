package com.example.music.domain.vo.sys;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/18 11:14
 * @Description
 */
@Data
public class SysUserPasswordVo {

    /**
     * 用户id
     */
    private Integer id;

    /**
     *  用户姓名
     */
    private String userName;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String password;
}
