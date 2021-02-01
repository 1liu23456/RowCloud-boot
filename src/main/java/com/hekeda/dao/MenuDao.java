package com.hekeda.dao;

import com.hekeda.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 获取主页菜单选项
 */
@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
