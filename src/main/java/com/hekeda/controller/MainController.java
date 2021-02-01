package com.hekeda.controller;

import com.alibaba.fastjson.JSON;
import com.hekeda.bean.MainMenu;
import com.hekeda.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 菜单选项处理
 *
 *      * 后台获取数据步骤：
 *      * 1.设计数据表对应的数据
 *      * 2.编写实体类
 *      * 3.编写接口方法
 *      * 4.编写映射文件
 *      * 5.编写控制层
 *      * 利用接口方法操作映射文件从数据库获取数据
 *      *
 *      * 前台从后台获取数据只需要请求这个控制层路径得到他的返回结果解构即可
 *
 */

@RestController
public class MainController {

    @Autowired
    MenuDao menuDao;
    @RequestMapping("/menus")
    public String getAllMenus() {
        System.out.println("访问成功");
        HashMap<String, Object> data = new HashMap<>();
        //获取主页菜单选项
        List<MainMenu> menus = menuDao.getMenus();
        if (menus != null) {
            //把菜单选项放在data里,返回200
            data.put("menus",menus);
            data.put("flag",200);
        } else {
            data.put("flag",404);
        }
        String s = JSON.toJSONString(data);
//        System.out.println(s);
        //把从数据库获得的数据返回给前端
        return s;
    }

}
