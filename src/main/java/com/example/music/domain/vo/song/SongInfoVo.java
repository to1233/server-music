package com.example.music.domain.vo.song;

import com.example.music.domain.entity.Song;
import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/11 20:59
 * @Description
 */
@Data
public class SongInfoVo extends Song {

    /**
     * 歌曲对应的歌手名字
     */
    private String singerName;
}
