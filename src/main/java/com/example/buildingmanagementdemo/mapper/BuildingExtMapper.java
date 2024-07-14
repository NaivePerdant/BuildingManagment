package com.example.buildingmanagementdemo.mapper;

import com.example.buildingmanagementdemo.model.Building;

import java.util.List;

public interface BuildingExtMapper {
    List<Building> fullSelectByKeyword(String keyword);
}
