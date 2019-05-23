package com.jk.service;


import com.jk.bean.*;


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

    HashMap<String, Object> zhaobiaoguanli(Integer pageSize, Integer start, tiaocha tiaocha, Integer userid);


    void xiugaimima(String oldpassword, String password, Integer user);

    List<Commpany> getShangQuan(String city, String gongName, Integer num);

    Commpany jianjie(String city);

    HashMap<String, Object> getsession(Integer userid);


    void adddizhi(tianjiadizhi tianjiadizhi);

    HashMap<String, Object> finddizhiTab(Integer pageSize, Integer start, Integer userid);

    /**
     * 查询 个人中心 收货地址
     *
     * @param tianjiadizhi
     * @param size
     * @param pageSize
     * @param start
     * @return
     */


    List<LinkedHashMap<String, Object>> getAllXianLu();


}
