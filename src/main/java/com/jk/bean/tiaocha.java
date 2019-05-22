package com.jk.bean;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;



@Data
public class tiaocha {
    private Integer tiaojian;
    private String  proname;
    private Integer zhuangtai;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date minDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date   maxDate;
  private  Integer userid;

}
