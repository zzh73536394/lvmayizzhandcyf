package com.jk.mapper;



import com.jk.bean.*;
import com.jk.util.MenuTree;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import com.jk.bean.Commpany;
import com.jk.bean.CommpanyInfo;
import com.jk.bean.liandong;
import org.apache.ibatis.annotations.Param;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface RecMapper {




    @Select("select * from t_area where pid=0")
    List<liandong> getsheng();

    @Select("select * from t_area where pid=#{typeid}")
    List<liandong> getshi(@Param("typeid") Integer typeid);

    @Select("select * from t_area where pid=#{typeid}")
    List<liandong> getxian(@Param("typeid")Integer typeid);

    @Select("select * from t_biaoti")
    List<LinkedHashMap<String, Object>> getbiaoTi();
    @Select("SELECT * FROM t_oss")
    List<LinkedHashMap<String, Object>> getBroadcastMap();


    @Select("select * from t_commpany where chufadi=#{a} and mudidi=#{b}")
    List<LinkedHashMap<String, Object>> getluxian(String a, String b);
    @Select("select * from t_area where pid =(select a.id from t_area a where a.`name`=#{city})")
    List<LinkedHashMap<String, Object>> xingZhengQu(String city);

    @Select("select *from t_commpany where chufadi=#{startcity} and mudidi=#{endcity}")
    List<Commpany> findCommBYcity(@Param("startcity") String startcity, @Param("endcity")String endcity);

    @Select("select mudidi from t_commpany where chufadi=#{nowCity} GROUP BY mudidi")
    List<String> findNowByAll(@Param("nowCity") String nowCity);

    @Select("select * from t_qual where pid=#{id}")
    CommpanyInfo findCommInfo(@Param("id") Integer id);



    List<tableall> tiaocha(@Param("pageSize") Integer pageSize, @Param("start") Integer start, @Param("maxDate") Date maxDate, @Param("minDate") Date minDate, @Param("proname") String proname, @Param("tiaojian") Integer tiaojian, @Param("zhuangtai") Integer zhuangtai,@Param("userid")Integer userid);

    @Select("select count(*) from t_order tr INNER JOIN t_goods ts on tr.orderNo=ts.orderNo INNER JOIN t_commpany ty on tr.commpanyId=ty.id INNER JOIN t_accept tt on tr.accept=tt.id where 1=1 and tr.userid=#{userid}")
    Integer count(Integer userid);


    void add(zhaobiao zhaobiao);

    @Select("select count(*) from t_zhaobiao where pid=#{userid}")
    Integer countzhaobiao(Integer userid);


    List<zhaobiao> zhaobiaoguanli(@Param("pageSize")Integer pageSize,@Param("start") Integer start, @Param("proname")String proname,@Param("zhuangtai") Integer zhuangtai,@Param("userid") Integer userid);

    @Select("select count(*) from t_user where id = #{user} and password=#{oldpassword}")
    Integer countsum(@Param("oldpassword") String oldpassword,@Param("user") Integer user);

    @Update("update t_user set password=#{password}")
    void xiugaimima(String password);


    List<Commpany> getShangQuan(@Param("city") String city,@Param("gongName") String gongName,@Param("num") Integer num);

    Commpany jianjie(@Param("city")String city);

    @Select("select loginnumber from t_user where id=#{userid}")
    HashMap<String,Object> getsession(Integer userid);


    void adddizhi(tianjiadizhi tianjiadizhi);

    /**
     * 查询 个人中心收货地址总条数
     * @return
     * @param userid
     */
    @Select(" select count(*) from t_dizhiguanli where pid=#{userid}  ")
    long findsumren(Integer userid);



    /**
     * 查询 个人中心 收货地址 分页
     * @param tianjiadizhi
     * @param size
     * @param pageSize
     * @param start
     * @return
     */
    @Select(" select * from  t_dizhiguanli where pid=#{userid} limit #{start},#{pageSize}")
    List<tianjiadizhi> finddizhiTab(@Param("pageSize") Integer pageSize,@Param("start") Integer start,@Param("userid") Integer userid);

    @Select("select * from t_zhuanxian")
    List<LinkedHashMap<String, Object>> getAllXianLu();



}