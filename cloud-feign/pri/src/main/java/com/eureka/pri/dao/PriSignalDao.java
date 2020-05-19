package com.eureka.pri.dao;

import com.eureka.pri.model.PriSignalModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PriSignalDao {

    @Select("select * from ge_14987173031 where DataNum=#{id}")
    PriSignalModel getDataById(long id);

    @Select("select * from ge_14987173031 order by DataNum limit #{startIndex}, #{endIndex}")
    List<PriSignalModel> getData(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    @Select("select * from ge_14987173031")
    List<PriSignalModel> getDataPage();

}
