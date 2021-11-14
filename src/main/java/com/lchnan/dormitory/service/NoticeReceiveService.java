package com.lchnan.dormitory.service;

import com.yanzhen.mapper.NoticeReceiveMapper;
import com.yanzhen.entity.NoticeReceive;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class NoticeReceiveService {

    @Autowired
    private NoticeReceiveMapper noticeReceiveMapper;

    public int create(NoticeReceive noticeReceive) {
        return noticeReceiveMapper.create(noticeReceive);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                noticeReceiveMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return noticeReceiveMapper.delete(id);
    }

    public int update(NoticeReceive noticeReceive) {
        return noticeReceiveMapper.update(noticeReceive);
    }

    public int updateSelective(NoticeReceive noticeReceive) {
        return noticeReceiveMapper.updateSelective(noticeReceive);
    }

    public PageInfo<NoticeReceive> query(NoticeReceive noticeReceive) {
        if(noticeReceive != null && noticeReceive.getPage() != null){
            PageHelper.startPage(noticeReceive.getPage(),noticeReceive.getLimit());
        }
        return new PageInfo<NoticeReceive>(noticeReceiveMapper.query(noticeReceive));
    }

    public NoticeReceive detail(Integer id) {
        return noticeReceiveMapper.detail(id);
    }

    public int count(NoticeReceive noticeReceive) {
        return noticeReceiveMapper.count(noticeReceive);
    }
}
