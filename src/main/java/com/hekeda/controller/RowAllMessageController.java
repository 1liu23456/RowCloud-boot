package com.hekeda.controller;

import com.alibaba.fastjson.JSON;
import com.hekeda.bean.QueryInfo;
import com.hekeda.bean.RowMessage;
import com.hekeda.bean.User;
import com.hekeda.dao.RowMessageDao;
import com.sun.rowset.internal.Row;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
@Api(description="播种信息操作")
@RestController
public class RowAllMessageController {
    @Autowired
    private RowMessageDao rowMessageDao;

    @ApiOperation(value = "获取所有信息")
    //查询所有播种信息
    @RequestMapping("/rowAllMessage")
    public String getRowMessage(QueryInfo queryInfo) {
        //获取最大列表数和当前编号
        int rowCounts = rowMessageDao.getRowCounts();
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
//        System.out.println(rowCounts);
//        System.out.println(pageStart);
        //获取所有播种信息
        List<RowMessage> allRowMessage = rowMessageDao.getAllRowMessage("%" + queryInfo.getQuery() + "%",
                pageStart, queryInfo.getPageSize());
        System.out.println(allRowMessage);
        //存储用户
        HashMap<String, Object> res = new HashMap<>();
        res.put("rowNum", rowCounts);
        res.put("data",allRowMessage);
        String res_str = JSON.toJSONString(res);
        return res_str;
    }

    @ApiOperation(value = "删除信息")
    @RequestMapping("/deleteRow")
    public String deleteRowMessage(int id) {
        int count = rowMessageDao.deleteRow(id);
        System.out.println("删除了" + count + "条信息");
        return count > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/mapData")
    public List<RowMessage> getRowMapData() {
        List<RowMessage> rowMapData = rowMessageDao.getRowMapData();
        return rowMapData;
    }

}
