package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.music.dao.SongMapper;
import com.example.music.domain.entity.Song;
import com.example.music.service.ISongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.example.music.constant.SysConstant.DbColumnKey.SINGER_ID;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 10:14
 * @Description
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {

    @Resource
    private SongMapper songMapper;

    @Override
    public Song songOfId(Integer id) {
        return songMapper.selectById(id);
    }

    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        QueryWrapper<Song> songQueryWrapper = new QueryWrapper<>();
        songQueryWrapper.eq(SINGER_ID,singerId);
        return songMapper.selectList(songQueryWrapper);
    }

    @Override
    public List<Song> findSongListBySheetId(Integer sheetId) {
        return songMapper.findSongListBySheetId(sheetId);
    }
}
