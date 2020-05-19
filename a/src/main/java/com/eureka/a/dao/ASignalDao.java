package com.eureka.a.dao;

import com.eureka.a.model.ASignalModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ASignalDao {

    @Select("select * from itaorigindata_460208719007996table where DataNum=#{id}")
    ASignalModel getDataById(long id);

    @Select("select * from itaorigindata_460208719007996table order by DataNum limit #{startIndex}, #{endIndex}")
    List<ASignalModel> getData(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    @Select("select * from itaorigindata_460208719007996table")
    List<ASignalModel> getDataPage();

}
