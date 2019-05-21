package com.jk.controller;

import com.jk.bean.Commpany;
import com.jk.bean.liandong;
import com.jk.service.RecSevice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("getbiaoTi")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getbiaoTi() {
        List<LinkedHashMap<String, Object>> list=recSevice.getbiaoTi();
        return list;
    }

    //轮播图
    @RequestMapping("getBroadcastMap")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getBroadcastMap() {
        List<LinkedHashMap<String, Object>> list=recSevice.getBroadcastMap();
        return list;
    }
    //跳转页面
    @RequestMapping("toShow")
    public String toShow(String url) {
        return url;
    }


    @RequestMapping("xingZhengQu")
    @ResponseBody
    public List<LinkedHashMap<String,Object>> xingZhengQu(String city) {
        List<LinkedHashMap<String,Object>> list=recSevice.xingZhengQu(city);
        return list;
    }

    @RequestMapping("addRemen")
    @ResponseBody
    public void addRemen(String begin,String end){
        Jedis jedis = jedisPool.getResource();
        jedis.lpush("remen",begin,end);
        jedis.close();
    }

    @RequestMapping("toZhuanxian")
    public String toZhuanxian(String startcity, String endcity, Model model){
        if (StringUtils.isNotEmpty(startcity)&&StringUtils.isNotEmpty(endcity)){
                  model.addAttribute("status",true);
            model.addAttribute("startcity",startcity);
            model.addAttribute("endcity",endcity);
        }
        else{
            model.addAttribute("status",false);
        }
      return "zhuanxian";
    }

    @RequestMapping("findCommBYcity")
    @ResponseBody
    public List<Commpany> findCommBYcity(String startcity, String endcity){
        List<Commpany> commBYcity = recSevice.findCommBYcity(startcity, endcity);
        return commBYcity;
    }

    @RequestMapping("findNowByAll")
    @ResponseBody
    public List<String> findNowByAll(String nowCity){
        return recSevice.findNowByAll(nowCity);
    }

    @RequestMapping("getRemen")
    @ResponseBody
    public List<String> getRemen(){
        Jedis jedis = jedisPool.getResource();
        Long llen = jedis.llen("remen");
        List<String> remen = jedis.lrange("remen", 0, llen - 1);
        return remen;
    }
}
