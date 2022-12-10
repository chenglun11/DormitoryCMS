package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Record;
import com.lchnan.dormitory.service.RecordService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("create")
    public Result create(@RequestBody Record record){
        int flag = recordService.create(record);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = recordService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Record record){
        int flag = recordService.update(record);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Record detail(Integer id){
        return recordService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Record record){
        PageInfo<Record> pageInfo = recordService.query(record);
        return Result.ok(pageInfo);
    }

}
