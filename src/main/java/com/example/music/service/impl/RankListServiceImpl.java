package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.music.dao.RankListMapper;
import com.example.music.domain.entity.RankList;
import com.example.music.service.IRankListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.example.music.constant.SysConstant.DbColumnKey.*;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 16:12
 * @Description
 */
@Service
public class RankListServiceImpl implements IRankListService {

    @Resource
    private RankListMapper rankListMapper;

    @Override
    public boolean addRank(RankList rankList) {
        return rankListMapper.insert(rankList) > 0;
    }

    @Override
    public Integer rankOfSongListId(Integer songSheetId) {
        return rankListMapper.rankOfSongListId(songSheetId);
    }

    @Override
    public Integer getUserRank(Integer consumerId, Integer songListId) {
        RankList rankList =  rankListMapper.selectOne(new QueryWrapper<RankList>().eq(CONSUMER_ID,consumerId).eq(SONG_LIST_ID,songListId));
        if(rankList !=null) {
            return rankList.getScore();
        }
        return 0;
    }
}
