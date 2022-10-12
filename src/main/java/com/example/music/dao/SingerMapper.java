package com.example.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.music.domain.entity.Singer;
import com.example.music.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:07
 * @Description
 */
@Mapper
public interface SingerMapper extends BaseMapper<Singer> {
}
