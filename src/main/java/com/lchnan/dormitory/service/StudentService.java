package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.StudentMapper;
import com.lchnan.dormitory.entity.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int create(Student student) {
        return studentMapper.create(student);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                studentMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return studentMapper.delete(id);
    }

    public int update(Student student) {
        return studentMapper.update(student);
    }

    public int updateSelective(Student student) {
        return studentMapper.updateSelective(student);
    }

    public PageInfo<Student> query(Student student) {
        if(student != null && student.getPage() != null){
            PageHelper.startPage(student.getPage(),student.getLimit());
        }
        return new PageInfo<Student>(studentMapper.query(student));
    }

    public Student detail(Integer id) {
        return studentMapper.detail(id);
    }

    public int count(Student student) {
        return studentMapper.count(student);
    }

    public Student login(String userName,String password){
        return studentMapper.login(userName,password);
    }

}
