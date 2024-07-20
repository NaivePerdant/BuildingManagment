package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.model.Building;
import com.example.buildingmanagementdemo.service.impl.BuildingServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuildingServiceTest {

    @Resource
    private BuildingServiceImpl buildingService;

    @Test
    void insertBuilding() {
        Building building = new Building();
        building.setName("testBuilding");
        building.setPropertyCertNo("testCertNo");
        building.setLocation("testLocation");
        int result = buildingService.insertBuilding(building);
        assertEquals(1, result);
    }
}