package com.jk.mapper;



import com.jk.bean.Commpany;
import com.jk.bean.liandong;
import org.apache.ibatis.annotations.Param;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
    @Select("select * from t_area where pid =(select a.id from t_area a where a.`name`='北京市')")
    List<LinkedHashMap<String, Object>> xingZhengQu(String city);

    @Select("select *from t_commpany where chufadi=#{startcity} and mudidi=#{endcity}")
    List<Commpany> findCommBYcity(@Param("startcity") String startcity, @Param("endcity")String endcity);

    @Select("select mudidi from t_commpany where chufadi=#{nowCity} GROUP BY mudidi")
    List<String> findNowByAll(@Param("nowCity") String nowCity);
}