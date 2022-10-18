package com.example.music.domain.vo.sys;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/14 14:23
 * @Description
 */
@Data
public class LoginSuccessVo {

    /**
     * 登录秘钥
     */
    private String  token;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户图标
     */
    private String avator;

    /**
     * 用户姓名
     */
    private String userName;
}
