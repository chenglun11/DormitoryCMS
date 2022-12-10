package com.lchnan.dormitory.controller;

import com.lchnan.dormitory.entity.Menu;
import com.lchnan.dormitory.entity.User;
import com.lchnan.dormitory.service.MenuService;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/query")
    public Result query(HttpServletRequest request){
        List<Menu> menus = new ArrayList<>();
        if(request.getAttribute("user") != null){
            User user = (User) request.getAttribute("user");
            menus = menuService.query(user.getId());
        }else if(request.getAttribute("student") != null){
            menus = menuService.queryByType();
        }

        List<Menu> menuList1 = new ArrayList<>();
        //找出一级菜单
        for (Menu menu : menus) {
            if(menu.getParentId() == 0){
                menuList1.add(menu);
            }
        }

        //嵌套循环找出关联设置child属性
        for (Menu parent : menuList1) {
            List<Menu> child = new ArrayList<>();
            for (Menu entity : menus) {
                if(parent.getId() == entity.getParentId()){
                    child.add(entity);
                }
            }
            parent.setChild(child);
        }

        return Result.ok(menuList1);
    }

    @GetMapping("/tree")
    public Result tree(Integer checked,HttpServletRequest request){
        //check查询的时候是否选中状态
        List<Integer> checkedMenuId = new ArrayList<>();
        if(checked != null){
            User user = (User) request.getAttribute("user");
            //查询出来自己已经设置过得menuId
            checkedMenuId = menuService.queryCheckMenuId(user.getId());
        }
        List<Menu> list = menuService.list();
        List<Map<String,Object>> menus = new ArrayList<>();
        for (Menu menu : list) {
            if(menu.getParentId()==0){
                Map<String,Object> map = new HashMap<>();
                map.put("id",menu.getId());
                map.put("name",menu.getTitle());
                map.put("isParent",true);
                map.put("open",true);
                if(checked != null){
                    map.put("checked",checkedMenuId.contains(menu.getId()));
                }
                List<Map<String,Object>> child = new ArrayList<>();
                for (Menu menu1 : list) {
                    if(menu1.getParentId()!=0 && menu.getId() == menu1.getParentId()){
                        Map<String,Object> map2 = new HashMap<>();
                        map2.put("id",menu1.getId());
                        map2.put("name",menu1.getTitle());
                        map2.put("isParent",false);
                        if(checked != null){
                            map2.put("checked",checkedMenuId.contains(menu1.getId()));
                        }
                        child.add(map2);
                    }
                }
                map.put("children",child);
                menus.add(map);
            }
        }
        return Result.ok(menus);
    }

}
