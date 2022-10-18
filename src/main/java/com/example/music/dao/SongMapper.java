package com.example.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music.domain.entity.Song;
import com.example.music.domain.vo.song.SongInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 10:46
 * @Description
 */
@Mapper
public interface SongMapper extends BaseMapper<Song> {

    /**
     * 查询歌单下的所有歌曲信息
     * @param sheetId 歌单id
     * @return List
     */
    List<SongInfoVo> findSongListBySheetId(Integer sheetId);

    /**
     * 根据歌手名查询出对应的歌曲集合
     * @param singerName 歌手姓名
     * @return List
     */
    List<SongInfoVo> songOfSingerName(String singerName);
}
