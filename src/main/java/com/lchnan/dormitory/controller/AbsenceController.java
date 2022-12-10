package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Absence;
import com.lchnan.dormitory.entity.Dormitory;
import com.lchnan.dormitory.entity.Student;
import com.lchnan.dormitory.service.AbsenceService;
import com.lchnan.dormitory.service.DormitoryService;
import com.lchnan.dormitory.service.StudentService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/absence")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping("create")
    public Result create(@RequestBody Absence absence){
        int flag = absenceService.create(absence);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = absenceService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Absence absence){
        int flag = absenceService.updateSelective(absence);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Absence detail(Integer id){
        return absenceService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Absence absence){
        PageInfo<Absence> pageInfo = absenceService.query(absence);
        pageInfo.getList().forEach(entity->{
            Student detail = studentService.detail(entity.getStudentId());
            entity.setStudent(detail);
            Dormitory dormitory = dormitoryService.detail(entity.getDormitoryId());
            entity.setDormitory(dormitory);
        });
        return Result.ok(pageInfo);
    }

}
