package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.OrgMapper;
import com.lchnan.dormitory.entity.Org;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class OrgService {

    @Autowired
    private OrgMapper orgMapper;

    public int create(Org org) {
        return orgMapper.create(org);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                orgMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return orgMapper.delete(id);
    }

    public int update(Org org) {
        return orgMapper.update(org);
    }

    public int updateSelective(Org org) {
        return orgMapper.updateSelective(org);
    }

    public PageInfo<Org> query(Org org) {
        if(org != null && org.getPage() != null){
            PageHelper.startPage(org.getPage(),org.getLimit());
        }
        return new PageInfo<Org>(orgMapper.query(org));
    }

    public Org detail(Integer id) {
        return orgMapper.detail(id);
    }

    public int count(Org org) {
        return orgMapper.count(org);
    }

    public List<Org> queryOrgBySelectionId(Integer selectionId){
        return orgMapper.queryOrgBySelectionId(selectionId);
    }
}
