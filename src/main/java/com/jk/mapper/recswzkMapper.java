package com.jk.mapper;

import com.jk.bean.liandong;
import com.jk.bean.orderModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface recswzkMapper {

    /**
     * 获取省的信息  wzk  2019-5-17 21:46:33
     * @return
     */
    @Select("select * from t_area where pid=0")
    List<liandong> getsheng();

    /**
     * 查询市的信息  wzk  2019-5-17 22:22:14
     * @param typeid
     * @return
     */
    @Select("select * from t_area where pid=#{typeid}")
    List<liandong> getshi(Integer typeid);

    /**
     * 查询 县的信息  wzk  2019-5-17 22:29:18
     * @param typeid
     * @return
     */
    @Select("select * from t_area where pid=#{typeid}")
    List<liandong> getxian(Integer typeid);

    /**
     * 测试代码 测试代码 测试代码
     * * @param sch
     * @return
     */



    /**
     * 提交订单
     * 2019-5-18 20:34:19
     * wzk
     * @param orderModel
     */
    void commitdan(orderModel orderModel);

    /**
     *
     * @return
     */
    @Select(" select count(*) from schooltest  ")
    long getgetblacklistsum();
}

