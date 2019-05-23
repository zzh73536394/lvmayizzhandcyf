package com.jk.mapper;

import com.jk.bean.liandong;
import com.jk.bean.orderModel;
import com.jk.bean.orderwModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
     * 提交订单
     * 2019-5-18 20:34:19
     * wzk
     * @param orderModel
     */
    void commitdan(orderModel orderModel);



    /**
     * 提交订单 goods 订单
     * 2019-5-18 20:34:19
     * wzk
     * @param
     */
    void commitdanss(orderwModel orderwModel);

    /**
     *在线发货 wzk  2019-5-21 10:04:44  不包括收件人 和收件人联系人
     * @param orderwModel
     */

    void orderw(orderwModel orderwModel);



    Integer getzhuanxianid(@Param("chufatext") String chufatext, @Param("muditext")String muditext);
}

