package com.hekeda.bean;

import lombok.Data;

import java.util.List;

/**
 * 主页菜单选项
 * 必须写get，set方法，不然前台获取不到对应的数据
 * 写了setter，getter方法才能在前端控制台打印出对应的数据
 */
@Data
public class MainMenu {
    private int id;
    private String title;
    private String path;
    //根据选项获取对应的选项
    private List<SubMenu> sList;


}
