package com.jk.service;

import com.jk.bean.*;
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
        Integer count = recMapper.count(tiaocha.getUserid());
        List<tableall> tiaocha1 = recMapper.tiaocha(pageSize, start,tiaocha.getMaxDate(),tiaocha.getMinDate(),proname,tiaocha.getTiaojian(),tiaocha.getZhuangtai(),tiaocha.getUserid());
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
    public HashMap<String, Object> zhaobiaoguanli(Integer pageSize, Integer start, tiaocha tiaocha, Integer userid) {
        String proname ="";
        if(tiaocha.getProname()!=null&&tiaocha.getProname()!=""){
            proname=  tiaocha.getProname().replaceAll(" ","");
        }
        Integer count = recMapper.countzhaobiao(userid);
        List<zhaobiao> tiaocha1 = recMapper.zhaobiaoguanli(pageSize, start, proname,tiaocha.getZhuangtai(),userid);
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
        HashMap<String, Object> getsession = recMapper.getsession(userid);
        return getsession;

    }

    @Override
    public void adddizhi(tianjiadizhi tianjiadizhi) {
        recMapper.adddizhi(tianjiadizhi);
    }

    /**
     * 查询 个人中心 收货地址
     * @param tianjiadizhi
     * @param size
     * @param pageSize
     * @param start
     * @return
     */
    @Override
    public HashMap<String, Object> finddizhiTab(Integer pageSize, Integer start, Integer userid) {
            long findsumren=recMapper.findsumren(userid);
            List<tianjiadizhi> list=recMapper.finddizhiTab(pageSize,start,userid);
            HashMap<String,Object> map= new HashMap<>();
            map.put("total",findsumren);
            map.put("rows",list);
            return map;
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
