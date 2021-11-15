package com.lchnan.dormitory.service;

import com.lchnan.dormitory.mapper.NoticeMapper;
import com.lchnan.dormitory.entity.Notice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public int create(Notice notice) {
        return noticeMapper.create(notice);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                noticeMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return noticeMapper.delete(id);
    }

    public int update(Notice notice) {
        return noticeMapper.update(notice);
    }

    public int updateSelective(Notice notice) {
        return noticeMapper.updateSelective(notice);
    }

    public PageInfo<Notice> query(Notice notice) {
        if(notice != null && notice.getPage() != null){
            PageHelper.startPage(notice.getPage(),notice.getLimit());
        }
        return new PageInfo<Notice>(noticeMapper.query(notice));
    }

    public Notice detail(Integer id) {
        return noticeMapper.detail(id);
    }

    public int count(Notice notice) {
        return noticeMapper.count(notice);
    }
}
