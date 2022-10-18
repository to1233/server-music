package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.Song;
import com.example.music.service.ISongService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 10:10
 * @Description 单个歌曲情况
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
    @GetMapping(value = "/singer/detail/{singerId}")
    public AjaxResult songOfSingerId(@PathVariable("singerId") Integer singerId) {
        return AjaxResult.success("查询成功", iSongService.songOfSingerId(singerId));
    }


    // 返回指定歌手名的歌曲
    @GetMapping(value = "/singerName/{singerName}")
    public AjaxResult songOfSingerName(@PathVariable("singerName") String singerName) {

        return AjaxResult.success("查询成功", iSongService.songOfSingerName('%' + singerName + '%'));
    }






}
