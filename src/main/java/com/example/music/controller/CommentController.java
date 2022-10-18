package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.Comment;
import com.example.music.domain.vo.coment.CommentLikeVo;
import com.example.music.enums.CodeEnum;
import com.example.music.service.ICommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Date;

import static com.example.music.enums.CodeEnum.LIKE_FAIL;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 11:16
 * @Description 评论列表
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService iCommentService;

    /**
     * 增加点赞信息
     *
     * @param comment 评论信息
     * @return
     */
    @PostMapping("/add")
    public AjaxResult addComment(Comment comment) {
        Comment addComment = new Comment();
        BeanUtils.copyProperties(comment, addComment);
        comment.setCreateTime(new Date());
        boolean res = iCommentService.addComment(comment);
        if (res) {
            return AjaxResult.success("添加成功");
        } else {
            return AjaxResult.error(CodeEnum.INSERT_FAIL);
        }
    }


    @GetMapping("/delete")
    public AjaxResult deleteComment(Integer id) {
        boolean res = iCommentService.deleteComment(id);
        if (res) {
            return AjaxResult.success("删除成功");
        } else {
            return AjaxResult.error(CodeEnum.DELETE_FAIL);
        }
    }

    /**
     * 获取指定歌曲 ID 的评论列表
     *
     * @param songId 歌曲id
     * @return
     */
    @GetMapping("/song/detail")
    public AjaxResult commentOfSongId(Integer songId) {
        return AjaxResult.success("查询成功", iCommentService.commentOfSongId(songId));
    }

    /**
     * 获取指定歌曲的评论列表
     *
     * @param songListId
     * @return
     */
    @GetMapping("/songList/detail")
    public AjaxResult commentOfSongListId(Integer songListId) {
        return AjaxResult.success("查询成功", iCommentService.commentOfSongListId(songListId));
    }

    /**
     * 点赞
     *
     * @param commentLikeVo
     * @return
     */
    @PostMapping
    public AjaxResult commentOfLike(@RequestBody CommentLikeVo commentLikeVo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentLikeVo, comment);
        boolean res = iCommentService.updateCommentMsg(comment);
        if (res) {
            return AjaxResult.success("点赞成功");
        } else {
            return AjaxResult.error(LIKE_FAIL);
        }
    }


}
