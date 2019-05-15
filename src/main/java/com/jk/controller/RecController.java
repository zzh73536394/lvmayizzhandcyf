package com.jk.controller;

import com.jk.service.RecSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Controller
public class RecController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired

    private RecSevice recSevice;
}
