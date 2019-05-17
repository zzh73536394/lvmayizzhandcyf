package com.jk.service;


import com.jk.bean.liandong;


import java.util.LinkedHashMap;
import java.util.List;

public interface RecSevice {



    List<liandong> getsheng();

    List<liandong> getshi(Integer typeid);

    List<liandong> getxian(Integer typeid);

    List<LinkedHashMap<String, Object>> getbiaoTi();


    List<LinkedHashMap<String, Object>> getluxian(String a, String b);
}
