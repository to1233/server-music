package com.example.music.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:02
 * @Description
 */
@Data
public class SysUser {

    private Integer id;

    private String username;

    private String password;

    private Byte sex;

    private String phoneNum;

    private String email;

    private Date birth;

    private String introduction;

    private String location;

    private String avator;

    private Date createTime;

    private Date updateTime;
}
