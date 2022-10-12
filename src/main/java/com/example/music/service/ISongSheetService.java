package com.example.music.service;

import com.example.music.domain.entity.SongSheet;
import com.example.music.domain.vo.BasePageVo;
import com.example.music.domain.vo.PageVo;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 15:56
 * @Description
 */
public interface ISongSheetService {

    /**
     * 查询所有的歌曲信息
     * @return List
     */
    PageVo<SongSheet> findPageSongList(BasePageVo basePageVo);

    /**
     * 查询对应的歌单
     * @param style 风格
     * @return List 歌单列表
     */
    List<SongSheet> likeStyle(String style);

    /**
     * 更新歌单信息
     * @param songSheet
     * @return
     */
    boolean updateSongListMsg(SongSheet songSheet);

    /**
     * 根据题目查询对应的歌单
     * @param title 标题
     * @return List
     */
    List<SongSheet> likeTitle(String title);

    /**
     * 删除对应的歌单数据
     * @param id 数据id
     * @return
     */
    boolean deleteSongList(Integer id);

    /**
     * 更新对应的图片
     * @param songSheet 歌单图片
     * @return boolean 是否更新成功
     */
    boolean updateSongListImg(SongSheet songSheet);

    /**
     * 根据id 来查询出对应的歌单id
     * @param id 歌单id
     * @return
     */
    SongSheet findSheetInfoById(Integer id);
}
