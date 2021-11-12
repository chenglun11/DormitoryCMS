package com.lchnan.dormitory.mapper;

import com.lchnan.dormitory.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin@lchnan.cn
 * @date 2021/11/12 17:11
 */
@Mapper
public interface UserMapper {
    int create(User user);
    int delete(Integer id);
    int update(User user);
    List<User> query(User user);
    User detail(Integer id);

}
