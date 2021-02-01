package com.hekeda.bean;

import lombok.Data;

@Data
public class QueryInfo {
    private String query; //查询信息
    private int pageNum = 1; //当前页
    private int pageSize = 1; //每页最大数
}
