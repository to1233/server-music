package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.music.dao.SongSheetMapper;
import com.example.music.domain.entity.SongSheet;
import com.example.music.domain.vo.BasePageVo;
import com.example.music.domain.vo.PageVo;
import com.example.music.service.ISongSheetService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.music.constant.SysConstant.DbColumnKey.STYLE;
import static com.example.music.constant.SysConstant.DbColumnKey.TITLE;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 15:56
 * @Description
 */
@Service
public class SongSheetServiceImpl extends ServiceImpl<SongSheetMapper, SongSheet> implements ISongSheetService {


    @Override
    public PageVo<SongSheet> findPageSongList(BasePageVo basePageVo) {
        IPage<SongSheet> songListIPage = page(new Page<>(basePageVo.getPageNum(), basePageVo.getPageSize()),new QueryWrapper<>());
        return new PageVo<>(songListIPage, songListIPage.getRecords());
    }

    @Override
    public List<SongSheet> likeStyle(String style) {
        QueryWrapper<SongSheet> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(STYLE, style);
        return getBaseMapper().selectList(queryWrapper);
    }

    @Override
    public boolean updateSongListMsg(SongSheet songSheet) {
        return getBaseMapper().updateById(songSheet) > 0;
    }

    @Override
    public List<SongSheet> likeTitle(String title) {
        return getBaseMapper().selectList(new QueryWrapper<SongSheet>().like(TITLE, title));
    }

    @Override
    public boolean deleteSongList(Integer id) {
        return getBaseMapper().deleteById(id) > 0;
    }

    @Override
    public boolean updateSongListImg(SongSheet songSheet) {
        return getBaseMapper().updateById(songSheet) > 0;
    }

    @Override
    public SongSheet findSheetInfoById(Integer id) {
        return getBaseMapper().selectById(id);
    }
}
