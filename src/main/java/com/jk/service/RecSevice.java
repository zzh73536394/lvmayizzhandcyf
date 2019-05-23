package com.jk.service;


import com.jk.bean.Commpany;
import com.jk.bean.CommpanyInfo;
import com.jk.bean.liandong;
import com.jk.bean.tiaocha;
import com.jk.bean.zhaobiao;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface RecSevice {



    List<liandong> getsheng();

    List<liandong> getshi(Integer typeid);

    List<liandong> getxian(Integer typeid);

    List<LinkedHashMap<String, Object>> getbiaoTi();

    List<LinkedHashMap<String, Object>> getBroadcastMap();

    List<LinkedHashMap<String, Object>> xingZhengQu(String city);

    List<Commpany> findCommBYcity(String startcity, String endcity);

    List<String> findNowByAll(String nowCity);

    CommpanyInfo findCommInfo(Integer id);

    HashMap<String, Object> tiaocha(Integer pageSize, Integer start, tiaocha tiaocha);

    void add(zhaobiao zhaobiao);

    HashMap<String, Object> zhaobiaoguanli(Integer pageSize, Integer start, tiaocha tiaocha);


    void xiugaimima(String oldpassword, String password, Integer user);

    List<Commpany> getShangQuan(String city, String gongName, Integer num);

    Commpany jianjie(String city);

    HashMap<String, Object> getsession(Integer userid);
}
