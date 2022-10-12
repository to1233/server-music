package com.example.music.service;

import com.example.music.domain.entity.Comment;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 11:24
 * @Description
 */
public interface ICommentService {


    /**
     * 删除对应的评论
     * @param id 评论数据id
     * @return boolean 是否删除成功
     */
    boolean deleteComment(Integer id);

    /**
     * 查询歌曲下对应的评论信息
     * @param songId 歌曲id
     * @return List 评论列表
     */
    List<Comment>  commentOfSongId(Integer songId);

    /**
     * 查询对应的评论
     * @param songListId
     * @return
     */
    List<Comment> commentOfSongListId(Integer songListId);

    /**
     * 更新对应的评论
     * @param comment
     * @return
     */
    boolean updateCommentMsg(Comment comment);

    /**
     * 添加评论到对应的歌曲或者 歌单下
     * @param comment 评论信息
     * @return boolean 是否添加成功
     */
    boolean addComment(Comment comment);
}
