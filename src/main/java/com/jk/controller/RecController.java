package com.jk.controller;

import com.jk.service.RecSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class RecController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired

    private RecSevice recSevice;

    @RequestMapping("getbiaoTi")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getbiaoTi() {
        List<LinkedHashMap<String, Object>> list=recSevice.getbiaoTi();
        return list;
    }
    //跳转页面
    @RequestMapping("toShow")
    public String toShow(String url) {
        return url;
    }
}
