package com.jk.mapper;



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


    @Select("select * from t_commpany where chufadi=#{a} and mudidi=#{b}")
    List<LinkedHashMap<String, Object>> getluxian(String a, String b);
    @Select("select * from t_area where pid =(select a.id from t_area a where a.`name`='北京市')")
    List<LinkedHashMap<String, Object>> xingZhengQu(String city);
}