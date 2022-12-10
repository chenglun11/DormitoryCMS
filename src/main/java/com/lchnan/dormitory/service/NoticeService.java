package com.lchnan.dormitory.service;

import com.lchnan.dormitory.entity.NoticeReceive;
import com.lchnan.dormitory.mapper.NoticeMapper;
import com.lchnan.dormitory.entity.Notice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan.dormitory.mapper.NoticeReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NoticeReceiveMapper noticeReceiveMapper;

    public int create(Notice notice) {
        noticeMapper.create(notice);
        List<Integer> buildingIds = notice.getBuildingIds();
        for (Integer buildingId : buildingIds) {
            NoticeReceive  noticeReceive = new NoticeReceive();
            noticeReceive.setBuildingId(buildingId);
            noticeReceive.setNoticeId(notice.getId());
            noticeReceiveMapper.create(noticeReceive);
        }
        return 1;
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if(!StringUtils.isEmpty(s)){
                noticeReceiveMapper.deleteByNoticeId(Integer.parseInt(s));
                noticeMapper.delete(Integer.parseInt(s));
            row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        noticeReceiveMapper.deleteByNoticeId(id);
        return noticeMapper.delete(id);
    }

    public int update(Notice notice) {
        return noticeMapper.update(notice);
    }

    public int updateSelective(Notice notice) {
        noticeMapper.updateSelective(notice);
        noticeReceiveMapper.deleteByNoticeId(notice.getId());
        List<Integer> buildingIds = notice.getBuildingIds();
        for (Integer buildingId : buildingIds) {
            NoticeReceive  noticeReceive = new NoticeReceive();
            noticeReceive.setBuildingId(buildingId);
            noticeReceive.setNoticeId(notice.getId());
            noticeReceiveMapper.create(noticeReceive);
        }
        return 1;
    }

    public PageInfo<Notice> query(Notice notice) {
        if(notice != null && notice.getPage() != null){
            PageHelper.startPage(notice.getPage(),notice.getLimit());
        }
        return new PageInfo<Notice>(noticeMapper.query(notice));
    }

    public PageInfo<Notice> queryByBuildingId(Notice notice){
        if(notice != null && notice.getPage() != null){
            PageHelper.startPage(notice.getPage(),notice.getLimit());
        }
        return new PageInfo<Notice>(noticeMapper.queryByBuildingId(notice));
    }

    public Notice detail(Integer id) {
        return noticeMapper.detail(id);
    }

    public int count(Notice notice) {
        return noticeMapper.count(notice);
    }
}
