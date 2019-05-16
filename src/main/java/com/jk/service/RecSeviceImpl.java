package com.jk.service;

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
    public List<LinkedHashMap<String, Object>> getbiaoTi() {
        return recMapper.getbiaoTi();
    }
}
