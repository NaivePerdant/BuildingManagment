package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.model.Building;

import java.util.List;

public interface BuildingService {
    int insertBuilding(Building building);

    int removeBuilding(int id);

    int updateBuilding(Building building);

    List<Building> selectAllBuildings();

    Building selectBuildingById(int id);

    List<Building> search(String keyword);
}
