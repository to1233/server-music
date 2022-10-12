package com.example.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music.domain.entity.ListSong;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 9:37
 * @Description
 */
@Mapper
public interface ListSongMapper extends BaseMapper<ListSong> {
}
