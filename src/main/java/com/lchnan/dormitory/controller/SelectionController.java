package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.Org;
import com.lchnan.dormitory.entity.Selection;
import com.lchnan.dormitory.entity.SelectionJoiner;
import com.lchnan.dormitory.service.OrgService;
import com.lchnan.dormitory.service.SelectionJoinerService;
import com.lchnan.dormitory.service.SelectionService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/selection")
public class SelectionController {

    @Autowired
    private SelectionService selectionService;
    @Autowired
    private SelectionJoinerService selectionJoinerService;
    @Autowired
    private OrgService orgService;

    @PostMapping("create")
    public Result create(@RequestBody Selection selection){
        int flag = selectionService.create(selection);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = selectionService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Selection selection){
        int flag = selectionService.update(selection);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Selection detail(Integer id){
        return selectionService.detail(id);
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Selection selection){
        PageInfo<Selection> pageInfo = selectionService.query(selection);
        pageInfo.getList().forEach(item->{
            List<Org> clazzes = orgService.queryOrgBySelectionId(item.getId());
            item.setClazzes(clazzes);
        });
        return Result.ok(pageInfo);
    }
}
