package com.jk.controller;

import com.jk.bean.liandong;
import com.jk.service.RecSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class RecController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired

    private RecSevice recSevice;


    @RequestMapping("runzhuye")
    public String zhuye() {
        return "zhuye";
    }

    //三级联动 省
    @RequestMapping("getsheng")
    @ResponseBody
    public List<liandong> getsheng() {
        List<liandong> getsheng = recSevice.getsheng();
        return getsheng;
    }

    //三级联动 市
    @RequestMapping("getshi")
    @ResponseBody
    public List<liandong> getshi(Integer typeid) {
        List<liandong> getshi = recSevice.getshi(typeid);
        return getshi;
    }

    @RequestMapping("getxian")
    @ResponseBody
    public List<liandong> getxian(Integer typeid) {
        List<liandong> getshi = recSevice.getxian(typeid);
        return getshi;
    }
}
