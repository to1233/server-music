package com.example.music.domain.vo.sys;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:38
 * @Description
 */
@Data
public class LoginVo {

    /**
     * 用户手机号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 手机号
     */
    private String phone;
}
