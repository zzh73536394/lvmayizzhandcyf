package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class tianjiadizhi {
    private Integer id;
    private Integer dizhileixing;
    private Integer morendizhi;
    private String  xiangxidizhi;
    private String  zhenshixingming;
    private String  shoujihaoma;
    private String  dianhuahaoma;
    private String  beizhuxinxi;
    private Integer  pid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date    tianjiashijian;
}
