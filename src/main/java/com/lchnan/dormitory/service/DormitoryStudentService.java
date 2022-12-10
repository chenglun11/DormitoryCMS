package com.lchnan.dormitory.service;

import com.lchnan.dormitory.entity.Dormitory;
import com.lchnan.dormitory.mapper.DormitoryMapper;
import com.lchnan.dormitory.mapper.DormitoryStudentMapper;
import com.lchnan.dormitory.entity.DormitoryStudent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DormitoryStudentService {

    @Autowired
    private DormitoryStudentMapper dormitoryStudentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

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

    public synchronized int select_dormitory_submit(Integer studentId,Integer dormitoryId,Integer bedId){
        Dormitory detail = dormitoryMapper.detail(dormitoryId);
        //获取容量
        int capacity = detail.getCapacity();
        DormitoryStudent ds = new DormitoryStudent();
        ds.setDormitoryId(dormitoryId);
        List<DormitoryStudent> list = dormitoryStudentMapper.query(ds);
        if(list.size() == capacity){
            return 0;
        }else{
            dormitoryStudentMapper.deleteByCond(studentId,dormitoryId);
            DormitoryStudent entity = new DormitoryStudent();
            entity.setDormitoryId(dormitoryId);
            entity.setBedId(bedId);
            entity.setStudentId(studentId);
            entity.setCheckin(new Date());
            entity.setStatus(1);
            dormitoryStudentMapper.create(entity);
        }
        return 1;
    }



    public int countByBuildingId(Integer buildingId){
        return dormitoryStudentMapper.countByBuildingId(buildingId);
    }

    public Map<String,Object> queryStudentByBedId(Integer bedId){
        return dormitoryStudentMapper.queryStudentByBedId(bedId);
    }

}
