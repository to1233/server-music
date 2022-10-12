package com.example.music.service;

import com.example.music.domain.entity.RankList;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 15:44
 * @Description
 */
public interface IRankListService {

    /**
     * 添加评论
     * @param rankList 评论信息
     * @return
     */
    boolean addRank(RankList rankList);

    /**
     * 查询对应歌单的评分
     * @param songListId
     * @return
     */
    Integer rankOfSongListId(Integer songListId);

    /**
     *
     * @param consumerId
     * @param songListId
     * @return
     */
    Integer getUserRank(Integer consumerId,Integer songListId);
}
