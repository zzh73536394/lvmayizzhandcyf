package com.jk.service;

import com.jk.bean.liandong;
import com.jk.bean.orderModel;

import com.jk.bean.orderwModel;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface RecsService {
    //获取省的信息 wzk  2019-5-17 21:45:28
    List<liandong> getsheng();

    //查询 市的信息  wzk  2019-5-17 22:21:08
    List<liandong> getshi(Integer typeid);

    //查询 县的信息 wzk  2019-5-17 22:28:13
    List<liandong> getxian(Integer typeid);

    //测试代码  测试 代码


    void commitdan(orderModel orderModel);

    void commitdanss(orderwModel orderwModel);
}
