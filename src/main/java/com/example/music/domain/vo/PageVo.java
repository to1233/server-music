package com.example.music.domain.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/11 8:54
 * @Description 分页参数
 */
@Data
public class PageVo<T> {

    private Long total ;

    private Long pages;

    private  Long current;

    private Long size;

    private List<T> records;

    public PageVo(IPage<T> page) {
        this.total = page.getTotal();
        this.size = page.getSize();
        this.pages = page.getPages();
        this.current = page.getCurrent();
        this.records = page.getRecords();
    }

    public PageVo(IPage<?> page, List<T> records) {
        this.total = page.getTotal();
        this.size = page.getSize();
        this.pages = page.getCurrent();
        this.records = records;
    }

    public PageVo(Long total, List<T> records) {
        this.total = total;
        this.records = records;
    }


}
