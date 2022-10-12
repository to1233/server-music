package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.service.ISongService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 10:10
 * @Description
 */
@RequestMapping("/song")
@RestController
public class SongController {

    @Resource
    private ISongService iSongService;

    // 返回指定歌曲ID的歌曲
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public AjaxResult songOfId(Integer id) {
        return AjaxResult.success("查询成功", iSongService.songOfId(id));
    }

    // 返回指定歌手ID的歌曲
    @RequestMapping(value = "/singer/detail", method = RequestMethod.GET)
    public AjaxResult songOfSingerId(Integer singerId) {
        return AjaxResult.success("查询成功", iSongService.songOfSingerId(singerId));
    }


}
