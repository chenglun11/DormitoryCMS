package com.lchnan.dormitory.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Bed;
import com.lchnan.dormitory.mapper.BedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BedService {

    @Autowired
    private BedMapper bedMapper;

    public int create(Bed bed) {
        return bedMapper.create(bed);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                bedMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return bedMapper.delete(id);
    }

    public int update(Bed bed) {
        return bedMapper.update(bed);
    }

    public int updateSelective(Bed bed) {
        return bedMapper.updateSelective(bed);
    }

    public PageInfo<Bed> query(Bed bed) {
        if(bed != null && bed.getPage() != null){
            PageHelper.startPage(bed.getPage(),bed.getLimit());
        }
        return new PageInfo<Bed>(bedMapper.query(bed));
    }

    public Bed detail(Integer id) {
        return bedMapper.detail(id);
    }

    public int count(Bed bed) {
        return bedMapper.count(bed);
    }
}
