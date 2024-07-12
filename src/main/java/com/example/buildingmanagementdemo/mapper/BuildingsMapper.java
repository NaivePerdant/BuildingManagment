package com.example.buildingmanagementdemo.mapper;

import com.example.buildingmanagementdemo.model.Building;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BuildingsMapper {
    @Select("select * from buildings where id = #{id}")
    Building getBuildingById(int id);

    @Insert("insert into buildings (name) values(#{name})")
    int addBuilding(Building building);

}
