package com.jk.bean;




import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * 在线发货  需要的字段  wzk  2019-5-20 23:01:17  placeDate 下单时间 时分秒  accept 受理状态 默认 1 packaging 包装类型 纸箱
 */
@Data
public class orderwModel {
    private Integer id;//id
    private String  hairProvinces;//发货地址
    private String  closedProvinces;//收货地址
    private String  shipping;//发货联系人
    private String  sendPhone;//发货人电话
    private String  goodsName;//货物名称 goods 表1
    private Integer singleton;//货物重量 goods 表2
    private Integer volume;//货物体积 goods 表3
    private Integer wetherOrderId;//是否上门提货
    private String  bringSite;//上门提货地址
    private Integer homeOrderId;//是否送货上门
    private String  commpanyId;//送货上门地址
    private Integer statusId;//关联支付状态ID
    private String  explaines;//发货说明 5
    private String  delivery;//收货联系人
    private String  deliverPhone;//收货人电话
    private String  estimateMoney;//预估余额
    private String  packaging;//包装类型 纸箱4
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date placeDate;//下单时间
    private Integer accept;//受理状态 1
    private String presentSite;//送货地址
    private Long orderNo;//订单号
    private String city;//出发地的市
    private String city2;//目的地的市
    private Integer freightId;//关联钱的id
}
