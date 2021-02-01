package com.hekeda.controller;


import com.alibaba.fastjson.JSON;
import com.hekeda.bean.User;
import com.hekeda.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * localhost:9000/login 页面
 *
 */
@RestController
public class LoginController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        String flag = "error";
        //从数据库获得用户名和密码，保证state等于1，才可以查得到，mapper接口并且state=1
        User us = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        System.out.println(us);
        //创建集合保存用户
        HashMap<String, Object> res = new HashMap<>();
        //如果用户不为空，使得flag为ok
        if(us!=null) {
            flag = "ok";
        }
        //把结果放在集合里保存
        res.put("flag",flag);
        res.put("user",user);
        System.out.println("User : " + user);
        //转换为json字符串
        String res_json = JSON.toJSONString(res);
        //把结果返回，相应给前台
        return res_json;
    }

}
