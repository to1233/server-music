package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.vo.BasePageVo;
import com.example.music.service.ISingerService;
import com.example.music.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 16:13
 * @Description 歌手情况
 */
@Slf4j
@RequestMapping("/singer")
@RestController()
public class SingerController {

    @Resource
    private ISingerService iSingerService;

    @GetMapping("/findPageSinger")
    public AjaxResult findPageSinger(BasePageVo basePageVo) {
        return AjaxResult.ajaxResult(iSingerService.findSingerList(basePageVo));
    }
}
