package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class zhaobiao {
    private Integer id;
    private String  biaoti;
    private String  fuwuleixing;
    private String  suoshuhangye;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date  kaishiriqi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date  jieshuriqi;
    private Integer zhuangtai;
    private String  dianjiliang;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date    lurushijian;
    private String proname;
    private String neirong;
    private String suozaichengshi;
    private String zhaiyao;
}
