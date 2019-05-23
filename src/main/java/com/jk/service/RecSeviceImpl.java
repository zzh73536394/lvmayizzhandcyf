package com.jk.service;

import com.jk.bean.Commpany;
import com.jk.bean.CommpanyInfo;
import com.jk.bean.Order;
import com.jk.bean.liandong;
import com.jk.bean.tiaocha;
import com.jk.bean.zhaobiao;
import com.jk.mapper.RecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;

@Service
public class RecSeviceImpl implements RecSevice{

    @Autowired
    private RecMapper recMapper;



    @Override
    public List<liandong> getsheng() {
        List<liandong> getsheng = recMapper.getsheng();
        return getsheng;
    }

    @Override
    public List<liandong> getshi(Integer typeid) {
        List<liandong> getshi = recMapper.getshi(typeid);
        return getshi;
    }

    @Override
    public List<liandong> getxian(Integer typeid) {
        List<liandong> getshi = recMapper.getxian(typeid);
        return getshi;
    }
    @Override
    public List<LinkedHashMap<String, Object>> getbiaoTi() {
        return recMapper.getbiaoTi();
    }




    @Override
    public List<LinkedHashMap<String, Object>> getBroadcastMap() {
        return recMapper.getBroadcastMap();
    }



    @Override
    public HashMap<String, Object> tiaocha(Integer pageSize, Integer start, tiaocha tiaocha) {
        String proname ="";
        if(tiaocha.getProname()!=null&&tiaocha.getProname()!=""){
            proname=  tiaocha.getProname().replaceAll(" ","");
        }
        Integer count = recMapper.count();
        List<Order> tiaocha1 = recMapper.tiaocha(pageSize, start,tiaocha.getMaxDate(),tiaocha.getMinDate(),proname,tiaocha.getTiaojian(),tiaocha.getZhuangtai(),tiaocha.getUserid());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",count);
        hashMap.put("rows",tiaocha1);
        return hashMap;
    }

    @Override
    public void add(zhaobiao zhaobiao) {
        recMapper.add(zhaobiao);
    }

    @Override
    public HashMap<String, Object> zhaobiaoguanli(Integer pageSize, Integer start, tiaocha tiaocha) {
        String proname ="";
        if(tiaocha.getProname()!=null&&tiaocha.getProname()!=""){
            proname=  tiaocha.getProname().replaceAll(" ","");
        }
        Integer count = recMapper.countzhaobiao();
        List<zhaobiao> tiaocha1 = recMapper.zhaobiaoguanli(pageSize, start, proname,tiaocha.getZhuangtai());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",count);
        hashMap.put("rows",tiaocha1);
        return hashMap;
    }

    @Override
    public void xiugaimima(String oldpassword, String password, Integer user) {
        Integer countsum = recMapper.countsum(oldpassword, user);
        if (countsum == 1) {
            recMapper.xiugaimima(password);
        }
    }
    @Override
    public List<Commpany> getShangQuan(String city, String gongName, Integer num) {
        return recMapper.getShangQuan(city,gongName,num);
    }

    @Override
    public Commpany jianjie(String city) {
        return recMapper.jianjie(city);
    }

    @Override
    public HashMap<String, Object> getsession(Integer userid) {
        return recMapper.getsession(userid);
    }
    @Override
    public List<LinkedHashMap<String, Object>> getAllXianLu() {
        return recMapper.getAllXianLu();
    }


    @Override
    public List<LinkedHashMap<String, Object>> xingZhengQu(String city) {
        return recMapper.xingZhengQu(city);
    }

    @Override
    public List<Commpany> findCommBYcity(String startcity, String endcity) {

        return recMapper.findCommBYcity(startcity,endcity);
    }

    @Override
    public List<String> findNowByAll(String nowCity) {

        return recMapper.findNowByAll(nowCity);
    }

    @Override
    public CommpanyInfo findCommInfo(Integer id) {
        return recMapper.findCommInfo(id);
    }
}
