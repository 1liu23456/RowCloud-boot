package com.hekeda.bean;

import lombok.Data;

import java.util.Date;
@Data
public class RowMessage {
    private int id;
    private String longitude;
    private String latitude;
    private double sowdeep;
    private int sowtag;
    private int ferttag;
    private Date date;
    private double pressure;

}
