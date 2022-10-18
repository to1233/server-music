package com.example.music.domain.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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

    private String userName;

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

    /**
     * 逻辑删除（1：已删除，0：未删除）
     */
    @TableLogic
    private Integer isDeleted;

}
