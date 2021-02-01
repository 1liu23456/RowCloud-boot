package com.hekeda.dao;

import com.hekeda.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {



    //查询登录用户接口
    public User getUserByMassage(@Param("username") String username,
                                 @Param("password") String password);

    //查询所有用户
    public List<User> getAllUser(@Param("username") String username,
                                 @Param("pageStart") int pageStart,
                                 @Param("pageSize") int pageSize);

    //查询所有用户数目
    public int getUserCounts(@Param("username") String username);




}
