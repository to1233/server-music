package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.ListSong;
import com.example.music.service.IListSongService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.music.enums.CodeEnum.*;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 9:35
 * @Description
 */
@RequestMapping("/listSong")
@RestController
public class ListSongController {

    @Resource
    private IListSongService iListSongService;

    @PostMapping
    public AjaxResult addListSong(@RequestBody ListSong sourceListSong) {
        ListSong listSong = new ListSong();
        BeanUtils.copyProperties(sourceListSong, listSong);
        boolean res = iListSongService.addListSong(listSong);
        if (res) {
            return AjaxResult.success("添加成功");
        } else {
            return AjaxResult.error(INSERT_FAIL);
        }
    }

    @GetMapping("/delete")
    public AjaxResult deleteListSong(Integer songId) {
        boolean res = iListSongService.deleteListSong(songId);
        if (res) {
            return AjaxResult.success("删除成功");
        } else {
            return AjaxResult.error(DELETE_FAIL);
        }
    }

    @GetMapping("/detail")
    public AjaxResult listSongOfSongId(Integer songListId) {
        return AjaxResult.success("查询成功",iListSongService.listSongOfSongId(songListId));
    }

}
