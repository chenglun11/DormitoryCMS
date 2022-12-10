package com.lchnan.dormitory.controller;

import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.entity.*;
import com.lchnan.dormitory.service.*;
import com.lchnan.dormitory.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private SelectionDormitoryService selectionDormitoryService;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private DormitoryStudentService dormitoryStudentService;
    @Autowired
    private AbsenceService absenceService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UserService userService;
    @Autowired
    private SelectionService selectionService;
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/info")
    public Result info(HttpServletRequest request){
        Student param = (Student)request.getAttribute("student");
        Student student = studentService.detail(param.getId());
        student.setOrg(orgService.detail(student.getClazzId()));
        student.setGrade(gradeService.detail(student.getGradeId()));
        return Result.ok(student);
    }

    @GetMapping("/select_dormitory")
    public Result select_dormitory(HttpServletRequest request){
        Student param = (Student)request.getAttribute("student");
        Student student = studentService.detail(param.getId());

        SelectionDormitory selectionDormitory = new SelectionDormitory();
        selectionDormitory.setClazzId(student.getClazzId());
        selectionDormitory.setLimit(1000);
        PageInfo<SelectionDormitory> pageInfo = selectionDormitoryService.query(selectionDormitory);

        List<Map<String,Object>> list = new ArrayList<>();
        //待选宿舍列表
        List<SelectionDormitory> selectionDormitorys = pageInfo.getList();
        for (SelectionDormitory sd : selectionDormitorys) {
            Map<String,Object> map = new HashMap<>();
            //查询宿舍的基本信息
            Dormitory dormitory = dormitoryService.detail(sd.getDormitoryId());
            map.put("capacity",dormitory.getCapacity());
            map.put("id",dormitory.getId());
            map.put("no",dormitory.getNo());
            map.put("sex",dormitory.getSex());
            Building building = buildingService.detail(dormitory.getBuildingId());
            map.put("buildingName",building.getName());

            //查询已选择的所有的学生
            DormitoryStudent ds = new DormitoryStudent();
            ds.setDormitoryId(sd.getDormitoryId());
            ds.setLimit(1000);
            PageInfo<DormitoryStudent> dormitoryStudents = dormitoryStudentService.query(ds);
            map.put("selected",dormitoryStudents.getList().size());

            //构造已选择的同学信息
            List<Map<String,Object>> studentMapList = new ArrayList<>();
            List<DormitoryStudent> list1 = dormitoryStudents.getList();
            list1.forEach(ds1->{
                Map<String,Object> studentMap = new HashMap<>();
                Student detail = studentService.detail(ds1.getStudentId());
                studentMap.put("stuNo",detail.getStuNo());
                studentMap.put("name",detail.getName());
                studentMap.put("bedId",ds1.getBedId());
                studentMapList.add(studentMap);
            });
            map.put("studentList",studentMapList);
            list.add(map);
        }
        return Result.ok(list);
    }

    @PostMapping("/select_dormitory_submit")
    public Result select_dormitory(@RequestBody Map<String,String> map,HttpServletRequest request){
        Student param = (Student)request.getAttribute("student");
        Student student = studentService.detail(param.getId());

        List<Selection> selections = selectionService.queryByClazzId(student.getClazzId());
        if(selections != null && selections.size()==0){
            return Result.fail("操作失败，未设置！请联系管理员");
        }
        Selection selection = selections.get(0);
        if(selection.getStartTime().getTime()>System.currentTimeMillis() || System.currentTimeMillis()>selection.getEndTime().getTime()){
            return Result.fail("操作失败，不在时间段内选择");

        }
        String bedId = map.get("bedId");
        String dormitoryId = map.get("dormitoryId");
        int row = dormitoryStudentService.select_dormitory_submit(student.getId(),Integer.parseInt(dormitoryId),Integer.parseInt(bedId));
        if(row>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }


    @PostMapping("/absence")
    public Map<String,Object> query(@RequestBody Absence absence,HttpServletRequest request){
        Student param = (Student)request.getAttribute("student");
        absence.setStudentId(param.getId());
        PageInfo<Absence> pageInfo = absenceService.query(absence);
        pageInfo.getList().forEach(entity->{
            Student detail = studentService.detail(entity.getStudentId());
            entity.setStudent(detail);
            Dormitory dormitory = dormitoryService.detail(entity.getDormitoryId());
            entity.setDormitory(dormitory);
        });
        return Result.ok(pageInfo);
    }

    @PostMapping("repair_create")
    public Result repair_create(@RequestBody Repair repair,HttpServletRequest request){
        Student param = (Student)request.getAttribute("student");
        DormitoryStudent ds = new DormitoryStudent();
        ds.setStudentId(param.getId());
        PageInfo<DormitoryStudent> pageInfo = dormitoryStudentService.query(ds);
        if(pageInfo.getList() != null && pageInfo.getList().size()>0){
            DormitoryStudent dormitoryStudent = pageInfo.getList().get(0);
            Dormitory detail = dormitoryService.detail(dormitoryStudent.getDormitoryId());
            repair.setBuildingId(detail.getBuildingId());
            repair.setDormitoryId(dormitoryStudent.getDormitoryId());
            repair.setStudentId(param.getId());
            repair.setCreateDate(new Date());
            repair.setStatus(0);
            int flag = repairService.create(repair);
            if(flag>0){
                return Result.ok();
            }else{
                return Result.fail();
            }
        }else{
            return Result.fail("操作失败，没有关联宿舍");
        }
    }


    @PostMapping("notice_query")
    public Map<String, Object> notice_query(@RequestBody Notice notice, HttpServletRequest request){
        Student param = (Student)request.getAttribute("student");
        DormitoryStudent ds = new DormitoryStudent();
        ds.setStudentId(param.getId());
        PageInfo<Notice> noticePageInfo = null;
        PageInfo<DormitoryStudent> pageInfo = dormitoryStudentService.query(ds);
        if(pageInfo.getList() != null && pageInfo.getList().size()>0){
            DormitoryStudent dormitoryStudent = pageInfo.getList().get(0);
            Dormitory detail = dormitoryService.detail(dormitoryStudent.getDormitoryId());
            notice.setBuildingId(detail.getBuildingId());
            noticePageInfo = noticeService.queryByBuildingId(notice);
            noticePageInfo.getList().forEach(entity->{
                entity.setUser(userService.detail(entity.getUserId()));
            });
            return Result.ok(noticePageInfo);
        }else{
            return Result.ok(noticePageInfo);
        }
    }
}
