package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.*;
import com.jk.rmi.ThisClient;
import com.alibaba.druid.support.logging.Log;
import com.jk.bean.Commpany;
import com.jk.bean.liandong;
import com.jk.bean.tiaocha;
import com.jk.bean.zhaobiao;
import com.jk.service.RecSevice;
import com.jk.util.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class RecController {

    @Autowired
    private JedisPool jedisPool;

    @Autowired

    private RecSevice recSevice;

    @Autowired
    private ThisClient thisClient;





    //三级联动 省
    @RequestMapping("getsheng")
    @ResponseBody
    public String getsheng() {
        Jedis jedis = jedisPool.getResource();
        if (StringUtils.isNotEmpty(jedis.get("sheng"))){
            String sheng = jedis.get("sheng");
            jedis.close();
            return sheng;
        }else{
            List<liandong> getsheng = recSevice.getsheng();
            String jsonString = JSON.toJSONString(getsheng);
            jedis.set("sheng",jsonString);
            jedis.close();
            return jsonString;
        }


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
    public String getbiaoTi() {
        Jedis jedis = jedisPool.getResource();
        if (StringUtils.isNotEmpty(jedis.get("biaoti"))){
            String sheng = jedis.get("biaoti");
            jedis.close();
            return sheng;
        }else{
            List<LinkedHashMap<String, Object>> list=recSevice.getbiaoTi();
            String jsonString = JSON.toJSONString(list);
            jedis.set("biaoti",jsonString);
            jedis.close();
            return jsonString;
        }

    }

    //轮播图
    @RequestMapping("getBroadcastMap")
    @ResponseBody
    public String getBroadcastMap() {
        Jedis jedis = jedisPool.getResource();
        if (StringUtils.isNotEmpty(jedis.get("luobo"))){
            String sheng = jedis.get("luobo");
            jedis.close();
            return sheng;
        }else{
            List<LinkedHashMap<String, Object>> list=recSevice.getBroadcastMap();
            String jsonString = JSON.toJSONString(list);
            jedis.set("luobo",jsonString);
            jedis.close();
            return jsonString;
        }

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

    @RequestMapping("toCommInfo")
    public String findCommInfo(Integer id,Model model){
        CommpanyInfo cominfo=recSevice.findCommInfo(id);
        model.addAttribute("cominfo",cominfo);
        return "commpanyInfo";
    }


    @RequestMapping("tiaocha")
    @ResponseBody
    public HashMap<String, Object> tiaocha(Integer pageSize, Integer start, tiaocha tiaocha,HttpSession session) {
        Integer userid = (Integer)session.getAttribute("userid");
        tiaocha.setUserid(userid);
        return recSevice.tiaocha(pageSize,start,tiaocha);
    }

    @RequestMapping("add")
    @ResponseBody
    public void add(zhaobiao zhaobiao) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        zhaobiao.setLurushijian(date);
        recSevice.add(zhaobiao);
    }

    @RequestMapping("zhaobiaoguanli")
    @ResponseBody
    public HashMap<String, Object> zhaobiaoguanli(Integer pageSize, Integer start, tiaocha tiaocha) {
        return recSevice.zhaobiaoguanli(pageSize,start,tiaocha);
    }

    @RequestMapping("login")
    @ResponseBody
    public HashMap<String,Object> userLogin(HttpServletResponse response,String loginnum, String password,Integer remPwd , HttpSession session, Model model){
        HashMap<String, Object> map = thisClient.findUser(loginnum, password, 3);
        if ((Integer) map.get("status")==0){
            String ur = map.get("usr").toString();
            UserModel usr = JSON.parseObject(ur, UserModel.class);
            if (usr!=null){
                session.setAttribute("username",usr.getLoginnumber());
                session.setAttribute("userid",usr.getId());
                if (remPwd!=null){
                    Cookie cookie = new Cookie(Constant.cookieNamePwd,loginnum+Constant.splitstr+password);
                    cookie.setMaxAge(604800);
                    response.addCookie(cookie);
                    model.addAttribute("password",1);
                }else{
                    Cookie cookie = new Cookie(Constant.cookieNamePwd,"");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }else{
                Cookie cookie = new Cookie(Constant.cookieNamePwd,"");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return map;
    }

    @RequestMapping("zhongxin")
    public String zhongxin(HttpSession session){
        Integer userid = (Integer)session.getAttribute("userid");
        if (userid==null){
            return "login";
        }else{
            return "wodedingdan";
        }
    }

    @RequestMapping("xiugaimima")
    @ResponseBody
    public void xiugaimima(String oldpassword,String password, HttpSession httpSession) {
        Integer user =(Integer) httpSession.getAttribute("userid");
        recSevice.xiugaimima(oldpassword,password,user);
    }

    //物流商圈
    @RequestMapping("getShangQuan")
    @ResponseBody
    public List<Commpany> getShangQuan(String city,String gongName,Integer num){
        List<Commpany> list=recSevice.getShangQuan(city,gongName,num);
        return list;
    }
    @RequestMapping("jianjie")
    @ResponseBody
    public Commpany jianjie(String city){
        Commpany commpany=recSevice.jianjie(city);
        return commpany;
    }

    @RequestMapping("tozaixianfahuo")
    public String tozaixianfahuo(HttpSession session){
        Integer user =(Integer) session.getAttribute("userid");
          if (user==null){
              return "login";
          }else{
              return "zaixian";
          }
    }

    @RequestMapping("outLogin")
    public String outLogin(HttpSession session){
        session.invalidate();
        return "login";
    }


    @RequestMapping("getsession")
    @ResponseBody
    public HashMap<String, Object> getsession(HttpSession httpSession) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Integer userid = (Integer)httpSession.getAttribute("userid");
        return recSevice.getsession(userid);
    }





    //查询所有线路
    @RequestMapping("getAllXianLu")
    @ResponseBody
    public List<LinkedHashMap<String, Object>> getAllXianLu() {
        return recSevice.getAllXianLu();
    }
}
