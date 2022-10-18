package com.example.music.service.impl;

import com.example.music.dao.CollectMapper;
import com.example.music.domain.entity.Song;
import com.example.music.domain.vo.song.SongInfoVo;
import com.example.music.service.ICollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/15 13:58
 * @Description 收藏歌曲信息
 */
@Service
public class CollectServiceImpl implements ICollectService  {

    @Resource
    private CollectMapper collectMapper;

    @Override
    public List<SongInfoVo> findCollectInfo(Integer userId) {
        return collectMapper.findCollectInfo(userId);
    }
}
