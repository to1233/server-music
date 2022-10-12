package com.example.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 11:28
 * @Description
 */
@Mapper
public interface CommentMapper  extends BaseMapper<Comment> {
}
