package com.jk.controller;

import com.jk.bean.liandong;
import com.jk.bean.orderModel;

import com.jk.bean.orderwModel;
import com.jk.service.RecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class recsController {
    @Autowired
    private RecsService recsService;

    /**
     * 获取省的信息 wzk  2019-5-17 22:19:39
     * @return
     */
    @RequestMapping("getshengs")
    @ResponseBody
    public List<liandong> getsheng() {
        List<liandong> getsheng = recsService.getsheng();
        return getsheng;
    }
    @RequestMapping("getshis")
    @ResponseBody
    public List<liandong> getshi(Integer typeid) {
        List<liandong> getshi = recsService.getshi(typeid);
        return getshi;
    }

    @RequestMapping("getxians")
    @ResponseBody
    public List<liandong> getxian(Integer typeid) {
        List<liandong> getxian = recsService.getxian(typeid);
        return getxian;
    }

    /**
     * 测试代码  条件查询 模糊查询  拼音查询 2019-5-18 11:25:32
     * @param sch
     * @return
     */

    /**
     * 提交订单  wzk  2019-5-18 17:43:19
     *
     */
    @RequestMapping("commitdan")
    @ResponseBody
    public void  commitdan(orderModel orderModel){
        recsService.commitdan(orderModel);
    }

    /**
     * 提交订单  wzk  2019-5-18 17:43:19
     *
     */
    @RequestMapping("commitdanss")
    @ResponseBody
    public Boolean  commitdanss(orderwModel orderwModel , HttpSession session){
        try {
            Integer userid = (Integer) session.getAttribute("userid");
            long date= new Date().getTime();
            orderwModel.setUserid(userid);
            Integer number= (int)(Math.random()*8999+1000);
            orderwModel.setOrderNo(date+""+userid+number);
            recsService.commitdanss(orderwModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
