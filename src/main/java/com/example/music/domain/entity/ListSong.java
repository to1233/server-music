package com.example.music.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/20 9:38
 * @Description
 */
@Data
public class ListSong implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 歌曲id
     */
    private Integer songId;

    /**
     * 所属歌单id
     */
    private Integer songSheetId;

}
