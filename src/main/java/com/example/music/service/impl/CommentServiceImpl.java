package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.music.dao.CommentMapper;
import com.example.music.domain.entity.Comment;
import com.example.music.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.example.music.constant.SysConstant.DbColumnKey.*;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 11:24
 * @Description
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public boolean deleteComment(Integer id) {
        return commentMapper.deleteById(id) > 0;
    }

    @Override
    public List<Comment> commentOfSongId(Integer songId) {
        return commentMapper.selectList(new QueryWrapper<Comment>().eq(SONG_ID, songId));
    }

    @Override
    public List<Comment> commentOfSongListId(Integer songListId) {
        return commentMapper.selectList(new QueryWrapper<Comment>().eq(SONG_LIST_ID, songListId));
    }

    @Override
    public boolean updateCommentMsg(Comment comment) {
        return commentMapper.updateById(comment) > 0;
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }


}
