package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.SongSheet;
import com.example.music.domain.vo.BasePageVo;
import com.example.music.enums.CodeEnum;
import com.example.music.service.IRankListService;
import com.example.music.service.ISongSheetService;
import com.example.music.service.ISongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/14 15:54
 * @Description
 */
@Slf4j
@RequestMapping("/songSheet")
@RestController
public class SongSheetController {


    @Resource
    private ISongSheetService iSongSheetService;

    @Resource
    private ISongService iSongService;

    @Resource
    private IRankListService iRankListService;


    @GetMapping("/findPageSongList")
    public AjaxResult findPageSongList(BasePageVo basePageVo) {
        return AjaxResult.ajaxResult(iSongSheetService.findPageSongList(basePageVo));
    }

    @GetMapping("/style/detail")
    public AjaxResult songListOfStyle(String style) {
        return AjaxResult.success("查询成功", iSongSheetService.likeStyle(style));
    }

    @GetMapping("/findSongListBySheetId/{sheetId}")
    public AjaxResult findSongListBySheetId(@PathVariable("sheetId") Integer sheetId) {
        return AjaxResult.ajaxResult(iSongService.findSongListBySheetId(sheetId));
    }


    @GetMapping("/findSheetInfoById/{id}")
    public AjaxResult findSheetInfoById(@PathVariable("id") Integer id) {
        return AjaxResult.ajaxResult(iSongSheetService.findSheetInfoById(id));
    }


    /**
     * 获取指定歌单的评分
     * @param sheetId 歌单id
     * @return
     */
    @GetMapping("/findRankBySheetId/{sheetId}")
    public AjaxResult findRankBySheetId(@PathVariable("sheetId") Integer sheetId) {
        return AjaxResult.success("查询成功",iRankListService.rankOfSongListId(sheetId));
    }

    @PostMapping("/update")
    public AjaxResult updateSongListMsg(SongSheet songSheet) {
        SongSheet addSongSheet = new SongSheet();
        BeanUtils.copyProperties(songSheet, addSongSheet);
        boolean res = iSongSheetService.updateSongListMsg(songSheet);
        if (res) {
            return AjaxResult.success("修改成功");
        } else {
            return AjaxResult.error(CodeEnum.UPDATE_FAIL);
        }
    }

    @GetMapping("/likeTitle/detail")
    public AjaxResult songListOfLikeTitle(String title) {
        return AjaxResult.success("查询成功", iSongSheetService.likeTitle(title));
    }

    @GetMapping("/delete")
    public AjaxResult deleteSongList(Integer id) {
        boolean res = iSongSheetService.deleteSongList(id);
        if(res) {
            return AjaxResult.success("删除成功");
        } else {
            return  AjaxResult.error(CodeEnum.DELETE_FAIL);
        }
    }

    @PostMapping("/songList/img/update")
    public AjaxResult updateSongList(@RequestParam("file")MultipartFile multipartFile, @RequestParam("id")Integer id) {
        String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + "img" + System.getProperty("file.separator")
                + "songListPic";
        File aimFileParent = new File(filePath);
        if(!aimFileParent.exists()) {
            aimFileParent.mkdirs();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String imgPath = "img/songListPic/" + fileName;
        try {
            multipartFile.transferTo(dest);
            SongSheet songSheet = new SongSheet();
            songSheet.setId(id);
            songSheet.setPic(imgPath);
            boolean res = iSongSheetService.updateSongListImg(songSheet);
            if(res) {
                return AjaxResult.success("更新成功");
            } else {
                return AjaxResult.error(CodeEnum.UPDATE_FAIL);
            }
        } catch (Exception ex) {
            return AjaxResult.error(CodeEnum.UPDATE_FAIL);
        }

    }
}
