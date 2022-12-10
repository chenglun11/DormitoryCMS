package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.DormitorySet;
import com.lchnan.dormitory.service.DormitorySetService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dormitorySet")
public class DormitorySetController {

    @Autowired
    private DormitorySetService dormitorySetService;

    @PostMapping("create")
    public Result create(@RequestBody DormitorySet dormitorySet){
        int flag = dormitorySetService.create(dormitorySet);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = dormitorySetService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody DormitorySet dormitorySet){
        int flag = dormitorySetService.update(dormitorySet);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public DormitorySet detail(Integer id){
        return dormitorySetService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  DormitorySet dormitorySet){
        PageInfo<DormitorySet> pageInfo = dormitorySetService.query(dormitorySet);
        return Result.ok(pageInfo);
    }

}
