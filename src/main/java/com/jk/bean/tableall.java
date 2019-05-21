package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class tableall {

    private String companyName;//公司名称
    private String companyInfo;//公司简称
    private String companyPhone;//接单电话
    private String relationName;//联系人
    private String station;//官方网站
    private String companyLogo;//公司标志
    private String serviceAim;//服务宗旨
    private String introduction;//公司简介
    private String industry;//优势服务行业
    private String account;//账号
    private String password;//密码
    private String chufadi;
    private String mudidi;

    private String goodsName;//货物名称
    private Integer number;//件数
    private String packaging;//包装类型
    private Integer singleton;//d单件重量
    private Integer volume;//单件体积
    private String photograph;//图片
    private String explain;//发货说明
    private Integer freightId;//关联钱的id

    private  String  orderNo;

    private Integer singletons;//总重量
    private Integer volumes;//总体积
    private Integer numbers;//总件数

    private Integer id;//主键
    private String orderNo1;//订单号
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date placeDate;//下单时间
    private String closedProvinces;//收货地址
    private String hairProvinces;//发货地址
    private String forwarding;//发货单位
    private String consignee;//收货单位
    private String shipping;//发货联系人
    private String delivery;//收货联系人
    private String sendPhone;//发货人手机号
    private String deliverPhone;//收货人地址
    private String bringSite;//提货地址
    private String presentSite;//送货地址
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date affirmDate;//结算时间
    private Integer estimate;//预估运费
    private  Integer aaa;//判断收发货地址
    private   String  city2;     //到市
    private   String  city;      //从市


    private   String  county;    //从市
    private   String  county1;    //到市


    private Integer statusId;//关联支付状态id
    private String name;//支付类型
    private Integer wetherOrderId;//关联是否上门提货
    private String wethName;//是否上门提货类型
    private Integer goodsId;//关联货物的id
    private  Integer zhong;//总重量
    private Integer draw;
    private String  fleid;
    private Integer commpanyId;
    private Integer zt;//自定义字段

    private String acceptname;


}
