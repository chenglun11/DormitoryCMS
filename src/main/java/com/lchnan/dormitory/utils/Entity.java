package com.lchnan.dormitory.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 596183363@qq.com
 * @Description:
 * @date 2020/11/2114:05
 */
public class Entity {

    private Integer page = 1;//页码数

    private Integer limit = 10;//页面大小，默认的10

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
