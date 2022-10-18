package com.example.music.service;

import com.example.music.domain.entity.Song;
import com.example.music.domain.vo.song.SongInfoVo;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 10:14
 * @Description
 */
public interface ISongService {


    /**
     * 查询歌曲的详情
     * @param id
     * @return
     */
    Song songOfId(Integer id);

    /**
     * 查询
     * @param singerId
     * @return
     */
    List<Song> songOfSingerId(Integer singerId);


    /**
     * 根据歌单id来查询出所属的歌曲集合
     * @param sheetId 歌单id
     * @return List
     */
    List<SongInfoVo> findSongListBySheetId(Integer sheetId);

    /**
     * 根据歌手名称来查询出对应的歌曲列表
     * @param singerName 歌手id
     * @return List 歌曲集合
     */
    List<SongInfoVo> songOfSingerName(String singerName);
}
