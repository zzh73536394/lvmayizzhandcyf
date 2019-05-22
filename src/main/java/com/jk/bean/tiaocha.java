package com.jk.bean;


import lombok.Data;


import java.util.Date;

@Data
public class tiaocha {
    private Integer tiaojian;
    private String  proname;
    private Integer zhuangtai;
  private  Integer userid;
    private Date minDate;

    private Date    maxDate;
}
