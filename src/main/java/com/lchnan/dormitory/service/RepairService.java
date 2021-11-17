package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Repair;
import com.lchnan.dormitory.mapper.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RepairService {

    @Autowired
    private RepairMapper repairMapper;

    public int create(Repair repair) {
        return repairMapper.create(repair);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                repairMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return repairMapper.delete(id);
    }

    public int update(Repair repair) {
        return repairMapper.update(repair);
    }

    public int updateSelective(Repair repair) {
        return repairMapper.updateSelective(repair);
    }

    public PageInfo<Repair> query(Repair repair) {
        if(repair != null && repair.getPage() != null){
            PageHelper.startPage(repair.getPage(),repair.getLimit());
        }
        return new PageInfo<Repair>(repairMapper.query(repair));
    }

    public Repair detail(Integer id) {
        return repairMapper.detail(id);
    }

    public int count(Repair repair) {
        return repairMapper.count(repair);
    }
}
