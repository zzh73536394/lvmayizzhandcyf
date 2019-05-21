package com.jk.controller;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@Controller
public class HttpController {

    @RequestMapping(value="/getXinWen" , produces="application/json;charset=utf-8")
    @ResponseBody
    public  String  getXinWen(){

        CloseableHttpClient httpClient = HttpClients.createDefault();


        //  传参用的集合
        /*ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("msg", msg));
        params.add(new BasicNameValuePair("key","free"));
        params.add(new BasicNameValuePair("appid","0"));
        String	paramsStr ="";
        try {
            paramsStr	= EntityUtils.toString(new UrlEncodedFormEntity(params,"UTF-8"));
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }*/

        HttpGet httpget = new HttpGet("http://ic.snssdk.com/2/article/v25/stream/");

        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1;"
                + " Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        httpget.setHeader("Accept", "application/json");

        httpget.setHeader("Accept-Encoding", "gzip, deflate");
        httpget.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30000)  		//设置链接超时的时间1秒钟
                .setSocketTimeout(30000) 		//设置读取超时1秒钟
                .build(); 						//RequestConfig静态方法  setProxy  设置代理


        httpget.setConfig(config);

        CloseableHttpResponse response=null;
        String jsonStr="";
        try {
            response= httpClient.execute(httpget);
            jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                response.close();
                httpget.abort();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return  jsonStr;
    }


    //获取当前城市
    @RequestMapping(value="/getDataCity" , produces="application/json;charset=utf-8")
    @ResponseBody
    public  String  getDataCity(String msg){

        CloseableHttpClient httpClient = HttpClients.createDefault();


        //  传参用的集合
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        /*params.add(new BasicNameValuePair("msg", msg));
        params.add(new BasicNameValuePair("key","free"));*/
        params.add(new BasicNameValuePair("key","3d08d38eaff8e2d5532014b64a0c1e62"));
        String	paramsStr ="";
        try {
            paramsStr	= EntityUtils.toString(new UrlEncodedFormEntity(params,"UTF-8"));
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        HttpGet httpget = new HttpGet("https://restapi.amap.com/v3/ip?"+paramsStr);

        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1;"
                + " Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
        httpget.setHeader("Accept", "application/json");

        httpget.setHeader("Accept-Encoding", "gzip, deflate");
        httpget.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30000)  		//设置链接超时的时间1秒钟
                .setSocketTimeout(30000) 		//设置读取超时1秒钟
                .build(); 						//RequestConfig静态方法  setProxy  设置代理


        httpget.setConfig(config);

        CloseableHttpResponse response=null;
        String jsonStr="";
        try {
            response= httpClient.execute(httpget);
            jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                response.close();
                httpget.abort();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return  jsonStr;
    }
}
