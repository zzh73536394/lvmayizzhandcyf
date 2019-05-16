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
}
