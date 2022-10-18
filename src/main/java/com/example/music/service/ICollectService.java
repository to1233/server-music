package com.example.music.service;

import com.example.music.domain.vo.song.SongInfoVo;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/15 13:57
 * @Description
 */
public interface ICollectService {


    /**
     * 查询出用户收藏的歌曲
     * @param userId 用户id
     * @return List  歌曲信息
     */
    List<SongInfoVo> findCollectInfo(Integer userId);
}
