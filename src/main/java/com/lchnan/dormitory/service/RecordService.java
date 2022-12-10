package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.RecordMapper;
import com.lchnan.dormitory.entity.Record;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public int create(Record record) {
        return recordMapper.create(record);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                recordMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return recordMapper.delete(id);
    }

    public int update(Record record) {
        return recordMapper.update(record);
    }

    public int updateSelective(Record record) {
        return recordMapper.updateSelective(record);
    }

    public PageInfo<Record> query(Record record) {
        if(record != null && record.getPage() != null){
            PageHelper.startPage(record.getPage(),record.getLimit());
        }
        return new PageInfo<Record>(recordMapper.query(record));
    }

    public Record detail(Integer id) {
        return recordMapper.detail(id);
    }

    public int count(Record record) {
        return recordMapper.count(record);
    }
}
