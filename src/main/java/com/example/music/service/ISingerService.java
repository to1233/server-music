package com.example.music.service;

import com.example.music.domain.entity.Singer;
import com.example.music.domain.vo.BasePageVo;
import com.example.music.domain.vo.PageVo;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 16:14
 * @Description
 */
public interface ISingerService {

    /**
     * 查询所有的歌手信息
     * @return List
     */
    PageVo<Singer> findSingerList(BasePageVo basePageVo);

    /**
     *
     * @param singerId
     * @return
     */
    Singer singerInfoById(Integer singerId);
}
