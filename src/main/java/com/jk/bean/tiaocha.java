package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class tiaocha {
    private Integer tiaojian;
    private String  proname;
    private Integer zhuangtai;

    private Data    minDate;

    private Data    maxDate;
}
