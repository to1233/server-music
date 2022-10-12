package com.example.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music.domain.entity.RankList;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 16:13
 * @Description
 */
@Mapper
public interface RankListMapper extends BaseMapper<RankList> {

    /**
     * 查询歌单下的对应的评分
     * @param songSheetId 歌单id
     * @return Integer
     */
    Integer rankOfSongListId(Integer songSheetId);
}
