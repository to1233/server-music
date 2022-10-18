package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.RankList;
import com.example.music.domain.vo.rank.RankListVo;
import com.example.music.enums.CodeEnum;
import com.example.music.service.IRankListService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 15:43
 * @Description 每个歌单的得分情况
 */
@RequestMapping("/rankList")
@RestController
public class RankListController {

    @Resource
    private IRankListService iRankListService;

    @PostMapping("/add")
    public AjaxResult addRank(@RequestBody RankListVo rankListVo) {
        RankList addRankList = new RankList();

        BeanUtils.copyProperties(rankListVo, addRankList);
        boolean res = iRankListService.addRank(addRankList);
        if (res) {
            return AjaxResult.success("添加成功");
        } else {
            return AjaxResult.error(CodeEnum.INSERT_FAIL);
        }
    }



    @GetMapping("/user")
    public AjaxResult getUserRank(Integer consumerId,Integer songListId) {
        return AjaxResult.success("查询成功",iRankListService.getUserRank(consumerId,songListId));
    }

}
