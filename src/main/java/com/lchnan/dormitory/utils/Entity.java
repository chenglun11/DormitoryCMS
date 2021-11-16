package com.lchnan.dormitory.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/12 21:34
 */
public class Entity{
    private Integer page;

    private Integer limit = 10; /*页面大小*/

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
