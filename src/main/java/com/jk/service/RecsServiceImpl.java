package com.jk.service;

import com.jk.bean.liandong;
import com.jk.bean.orderModel;


import com.jk.bean.orderwModel;
import com.jk.mapper.recswzkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class RecsServiceImpl implements RecsService {

    @Autowired
    private recswzkMapper recswzkMapper;

    /**
     * 获取省的信息 wzk  2019-5-17 21:45:54
     * @return
     */
    @Override
    public List<liandong> getsheng() {
        return recswzkMapper.getsheng();
    }

    /**
     * 获取市的信息 wzk 2019-5-17 22:21:32
     * @param typeid
     * @return
     */
    @Override
    public List<liandong> getshi(Integer typeid) {
        return recswzkMapper.getshi(typeid);
    }

    /**
     * 获取 县的信息 wzk  2019-5-17 22:28:38
     * @param typeid
     * @return
     */
    @Override
    public List<liandong> getxian(Integer typeid) {

        return recswzkMapper.getxian(typeid);
    }

    /**
     * 测试代码  测试代码
     * @param
     * @return
     */


    @Override
    public void commitdan(orderModel orderModel) {
        recswzkMapper.commitdan(orderModel);
    }

    @Override
    public void commitdanss(orderwModel orderwModel) {

        //预估运费
        recswzkMapper.deal(orderwModel);
        Integer id =  recswzkMapper.queryid();
        orderwModel.setFreightId(id);
        //商品表的新增
        recswzkMapper.commitdanss(orderwModel);

        Date date = new Date();
        orderwModel.setPlaceDate(date);
        //订单表的新增
        recswzkMapper.orderw(orderwModel);

    }
}
