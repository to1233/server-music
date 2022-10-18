package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.music.dao.SingerMapper;
import com.example.music.domain.entity.Singer;
import com.example.music.domain.vo.BasePageVo;
import com.example.music.domain.vo.PageVo;
import com.example.music.service.ISingerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 16:14
 * @Description
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements ISingerService {
    @Override
    public PageVo<Singer> findSingerList(BasePageVo basePageVo) {
        IPage<Singer> singerIPage = page(new Page<>(basePageVo.getPageNum(), basePageVo.getPageSize()),new QueryWrapper<>());
        return new PageVo<>(singerIPage,singerIPage.getRecords());
    }

    @Override
    public Singer singerInfoById(Integer singerId) {
        return getBaseMapper().selectById(singerId);
    }
}
