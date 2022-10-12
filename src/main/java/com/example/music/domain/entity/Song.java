package com.example.music.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 10:15
 * @Description
 */
@Data
public class Song implements Serializable {

    private Integer id;

    private Integer singerId;

    private String name;

    private String introduction;

    private Date createTime;

    private Date updateTime;

    private String pic;

    private String lyric;

    private String url;
}
