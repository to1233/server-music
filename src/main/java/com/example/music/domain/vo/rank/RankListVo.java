package com.example.music.domain.vo.rank;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 16:02
 * @Description
 */
@Data
public class RankListVo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录人
     */
    private Integer consumerId;

    /**
     * 打分
     */
    private Integer score;

    /**
     * 对应的歌单
     */
    private Integer songListId;
}
