package com.jk.service;

import com.jk.bean.liandong;
import com.jk.mapper.RecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public List<LinkedHashMap<String, Object>> getluxian(String a, String b) {
        return recMapper.getluxian(a,b);
    }




    @Override
    public List<LinkedHashMap<String, Object>> getBroadcastMap() {
        return recMapper.getBroadcastMap();
    }
}
