package com.jk.service;

import com.jk.mapper.RecMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecSeviceImpl implements RecSevice{

    @Autowired
    private RecMapper recMapper;
}
