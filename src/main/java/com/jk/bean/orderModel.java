package com.jk.bean;

import lombok.Data;

/**
 * 在线发货
 */
@Data
public class orderModel {
    private  Integer id;//ID
    private   String  startarea;//出发地
    private   String  endarea; //目的地
    private   String  user;//联系人
    private   String  userphone;//联系电话
    private   String  goodsName;//货物名称
    private   Integer singleton;//货物重量
    private   Integer volume;//货物体积
    private   String explaines;//货物说明
}
