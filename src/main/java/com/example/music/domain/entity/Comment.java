package com.example.music.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 11:28
 * @Description
 */
@Data
public class Comment implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 歌曲id
     */
    private Integer songId;

    /**
     * 歌曲列表id
     */
    private Integer songListId;

    /**
     * 评论
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 是否置顶
     */
    private Integer up;
}
