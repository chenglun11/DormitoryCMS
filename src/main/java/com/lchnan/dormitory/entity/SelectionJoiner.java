package com.lchnan.dormitory.entity;

import com.lchnan.dormitory.utils.Entity;


/**
 * @author 596183363@qq.com
 * @time 2020-11-21 14:27:15
 */
public class SelectionJoiner extends Entity {

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private Integer selectionId;
    /**
     *
     */
    private Integer clazzId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Integer selectionId) {
        this.selectionId = selectionId;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }
}