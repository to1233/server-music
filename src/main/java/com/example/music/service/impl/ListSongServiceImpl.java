package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.music.dao.ListSongMapper;
import com.example.music.domain.entity.ListSong;
import com.example.music.service.IListSongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.example.music.constant.SysConstant.DbColumnKey.SONG_ID;
import static com.example.music.constant.SysConstant.DbColumnKey.SONG_LIST_ID;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 9:37
 * @Description 歌曲与歌单关系接口实现类
 */
@Service
public class ListSongServiceImpl implements IListSongService {

    @Resource
    private ListSongMapper listSongMapper;

    @Override
    public boolean addListSong(ListSong listSong) {
        return listSongMapper.insert(listSong) > 0;
    }

    @Override
    public boolean deleteListSong(Integer songId) {
        QueryWrapper<ListSong> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SONG_ID, songId);
        return listSongMapper.delete(queryWrapper) > 0;
    }

    @Override
    public List<ListSong> listSongOfSongId(Integer songListId) {
        QueryWrapper<ListSong> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SONG_LIST_ID, songListId);
        return listSongMapper.selectList(queryWrapper);
    }
}
