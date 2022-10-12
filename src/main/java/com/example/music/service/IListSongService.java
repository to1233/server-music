package com.example.music.service;

import com.example.music.domain.entity.ListSong;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 9:37
 * @Description
 */
public interface IListSongService {

    /**
     * 添加歌曲到歌单中
     * @param listSong
     * @return
     */
    boolean addListSong(ListSong listSong);

    /**
     * 删除歌单中的歌曲id
     * @param songId
     * @return
     */
    boolean deleteListSong(Integer songId);

    /**
     * 返回歌单里的指定歌单ID的歌曲
     * @param songListId
     * @return
     */
    List<ListSong> listSongOfSongId(Integer songListId);

}
