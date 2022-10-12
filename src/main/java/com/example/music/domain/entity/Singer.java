package com.example.music.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 16:15
 * @Description
 */
@Data
public class Singer {

    private Integer id;

    private String name;

    private Byte sex;

    private String pic;

    private Date birth;

    private String location;

    private String introduction;

}
