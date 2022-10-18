package com.example.music.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/15 11:59
 * @Description 用户收藏信息
 */
@Data
public class Collect {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private  Integer userId;

    /**
     * 收藏类型
     */
    private Byte type;

    /**
     * 歌曲id
     */
    private Integer songId;

    /**
     * 歌单id
     */
    private Integer songListId;

    /**
     * 创建时间
     */
    private Date createTime;
}
