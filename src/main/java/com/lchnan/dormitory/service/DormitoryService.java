package com.lchnan.dormitory.service;

import com.lchnan.dormitory.entity.Bed;
import com.lchnan.dormitory.entity.Building;
import com.lchnan.dormitory.entity.DormitorySet;
import com.lchnan.dormitory.mapper.BedMapper;
import com.lchnan.dormitory.mapper.BuildingMapper;
import com.lchnan.dormitory.mapper.DormitoryMapper;
import com.lchnan.dormitory.entity.Dormitory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.mapper.DormitorySetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private DormitorySetMapper dormitorySetMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private BedMapper bedMapper;

    public int create(Dormitory dormitory) {
        return dormitoryMapper.create(dormitory);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                dormitoryMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return dormitoryMapper.delete(id);
    }

    public int update(Dormitory dormitory) {
        return dormitoryMapper.update(dormitory);
    }

    public int updateSelective(Dormitory dormitory) {
        return dormitoryMapper.updateSelective(dormitory);
    }

    public PageInfo<Dormitory> query(Dormitory dormitory) {
        if(dormitory != null && dormitory.getPage() != null){
            PageHelper.startPage(dormitory.getPage(),dormitory.getLimit());
        }
        return new PageInfo<Dormitory>(dormitoryMapper.query(dormitory));
    }

    public Dormitory detail(Integer id) {
        return dormitoryMapper.detail(id);
    }

    public int count(Dormitory dormitory) {
        return dormitoryMapper.count(dormitory);
    }

    @Transactional
    public void init(Dormitory dormitory){
        DormitorySet param = new DormitorySet();
        param.setBuildingId(dormitory.getBuildingId());
        param.setStoreyId(dormitory.getStoreyId());
        List<DormitorySet> dormitorySets = dormitorySetMapper.query(param);
        Building building = buildingMapper.detail(dormitory.getBuildingId());

        //删除已有床位（先查询出来，然后批量删除）
        List<Dormitory> dormitoryList = dormitoryMapper.query(dormitory);
        dormitoryList.forEach(item->{
            bedMapper.deleteByDormitoryId(item.getId());
        });
        //删除以有的数据(删除已有宿舍)
        dormitoryMapper.deleteByBuildingIdAndStoryId(dormitory.getBuildingId(),dormitory.getStoreyId());

        dormitorySets.forEach(dormitorySet -> {

            for(int i=dormitorySet.getStart();i<=dormitorySet.getEnd();i++){
                Dormitory entity = new Dormitory();
                entity.setNo(dormitorySet.getPrefix()+i);
                entity.setBuildingId(dormitory.getBuildingId());
                entity.setStoreyId(dormitory.getStoreyId());
                entity.setCapacity(dormitorySet.getCapacity());
                entity.setSex(building.getSex());
                entity.setType(building.getType());
                dormitoryMapper.create(entity);
                for(int j=1;j<=entity.getCapacity();j++){
                    Bed bed = new Bed();
                    bed.setBno(entity.getNo()+"-"+j);
                    bed.setDormitoryId(entity.getId());
                    bedMapper.create(bed);
                }
            }
        });
    }

}
