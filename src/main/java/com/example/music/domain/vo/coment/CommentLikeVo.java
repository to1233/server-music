package com.example.music.domain.vo.coment;

import lombok.Data;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 11:42
 * @Description
 */
@Data
public class CommentLikeVo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 是否置顶
     */
    private Integer up;
}
