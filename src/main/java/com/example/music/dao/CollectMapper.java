package com.example.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music.domain.entity.Collect;
import com.example.music.domain.entity.Song;
import com.example.music.domain.vo.song.SongInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/15 13:57
 * @Description 收藏信息查询
 */
@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

    /**
     * 查询出用户收藏的歌曲信息
     * @param userId 用户id
     * @return List
     */
    List<SongInfoVo> findCollectInfo(Integer userId);
}
