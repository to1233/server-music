package com.example.music.domain.entity;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 16:05
 * @Description
 */
@Data
public class RankList {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 歌单列表id
     */
    private Integer songListId;

    /**
     * 当前登录人
     */
    private Integer consumerId;

    /**
     * 评分
     */
    private Integer score;

}
