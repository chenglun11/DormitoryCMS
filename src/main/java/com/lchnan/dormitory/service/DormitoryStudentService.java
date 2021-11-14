package com.lchnan.dormitory.service;

import com.yanzhen.mapper.DormitoryStudentMapper;
import com.yanzhen.entity.DormitoryStudent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DormitoryStudentService {

    @Autowired
    private DormitoryStudentMapper dormitoryStudentMapper;

    public int create(DormitoryStudent dormitoryStudent) {
        return dormitoryStudentMapper.create(dormitoryStudent);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                dormitoryStudentMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return dormitoryStudentMapper.delete(id);
    }

    public int update(DormitoryStudent dormitoryStudent) {
        return dormitoryStudentMapper.update(dormitoryStudent);
    }

    public int updateSelective(DormitoryStudent dormitoryStudent) {
        return dormitoryStudentMapper.updateSelective(dormitoryStudent);
    }

    public PageInfo<DormitoryStudent> query(DormitoryStudent dormitoryStudent) {
        if(dormitoryStudent != null && dormitoryStudent.getPage() != null){
            PageHelper.startPage(dormitoryStudent.getPage(),dormitoryStudent.getLimit());
        }
        return new PageInfo<DormitoryStudent>(dormitoryStudentMapper.query(dormitoryStudent));
    }

    public DormitoryStudent detail(Integer id) {
        return dormitoryStudentMapper.detail(id);
    }

    public int count(DormitoryStudent dormitoryStudent) {
        return dormitoryStudentMapper.count(dormitoryStudent);
    }
}
