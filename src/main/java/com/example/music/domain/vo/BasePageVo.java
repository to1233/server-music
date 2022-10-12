package com.example.music.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/11 8:49
 * @Description
 */
@Data
public class BasePageVo implements Serializable {


    private Integer pageNum = 1 ;

    private Integer pageSize = 10;


}
