package com.hekeda.dao;

import com.hekeda.bean.RowMessage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RowMessageDao {
    //获取播种信息
    public List<RowMessage> getAllRowMessage(
            @Param("sowtag") String sowtag,
            @Param("pageStart") int pageStart,
            @Param("pageSize") int pageSize);



    //获取播种信息数
    public Integer getRowCounts();

    //根据删除播种信息
    public int deleteRow(int id);

    //获得经纬度信息
    public List<RowMessage> getRowMapData();
}
