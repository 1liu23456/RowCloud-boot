package com.hekeda.controller;

import com.alibaba.fastjson.JSON;
import com.hekeda.bean.QueryInfo;
import com.hekeda.bean.User;
import com.hekeda.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 *
 * 用户相关信息
 */

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 获取所有用户列表
     * 展现在前端
     * 需要 总用户数量，每页最大数
     */
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        //获取最大列表数和当前编号
        int userCounts = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        //获取所有用户列表
        List<User> allUser =
                userDao.getAllUser("%" + queryInfo.getQuery() + "%",
                        pageStart, queryInfo.getPageSize());
        //存储用户
        HashMap<String, Object> res = new HashMap<>();
        res.put("userNum", userCounts);
        res.put("data",allUser);
        String res_str = JSON.toJSONString(res);
        return res_str;
    }









}
