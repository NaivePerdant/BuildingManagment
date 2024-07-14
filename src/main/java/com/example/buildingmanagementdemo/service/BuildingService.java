package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.mapper.BuildingExtMapper;
import com.example.buildingmanagementdemo.mapper.BuildingMapper;
import com.example.buildingmanagementdemo.mapper.RoomMapper;
import com.example.buildingmanagementdemo.model.Building;
import com.example.buildingmanagementdemo.model.BuildingExample;
import com.example.buildingmanagementdemo.model.RoomExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    public static final int ERROR_CODE_BUILDING_NAME_EXIST = -1;
    private static final int ERROR_CODE_BUILDING_LOCATION_EXIST = -2;
    private static final int ERROR_CODE_BUILDING_PROPERTY_CERT_NO_EXIST = -3;

    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private BuildingExtMapper buildingExtMapper;

    public int insertBuilding(Building building) {
        // 检查名称是否已存在
        if (isBuildingNameExist(building.getName())) {
            return ERROR_CODE_BUILDING_NAME_EXIST;
        }

//        // 检查位置是否已存在
//        if (isBuildingLocationExist(building.getLocation())) {
//            return ERROR_CODE_BUILDING_LOCATION_EXIST;
//        }

        // 检查产权证号是否已存在
        if (isBuildingPropertyCertNoExist(building.getPropertyCertNo())) {
            return ERROR_CODE_BUILDING_PROPERTY_CERT_NO_EXIST;
        }

        return buildingMapper.insertSelective(building);
    }

    private boolean isBuildingNameExist(String name) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andNameEqualTo(name);
        return !buildingMapper.selectByExample(buildingExample).isEmpty();
    }

    private boolean isBuildingNameExistWithId(String name, int id) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andNameEqualTo(name).andIdNotEqualTo(id);
        return !buildingMapper.selectByExample(buildingExample).isEmpty();
    }

    private boolean isBuildingLocationExist(String location) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andLocationEqualTo(location);
        return !buildingMapper.selectByExample(buildingExample).isEmpty();
    }

    private boolean isBuildingPropertyCertNoExist(String propertyCertNo) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andPropertyCertNoEqualTo(propertyCertNo);
        return !buildingMapper.selectByExample(buildingExample).isEmpty();
    }

    private boolean isBuildingPropertyCertNoExistWithId(String name, int id) {
        BuildingExample buildingExample = new BuildingExample();
        buildingExample.createCriteria().andPropertyCertNoEqualTo(name).andIdNotEqualTo(id);
        return !buildingMapper.selectByExample(buildingExample).isEmpty();
    }

    public int removeBuilding(int id) {
        int result = buildingMapper.deleteByPrimaryKey(id);
        RoomExample example = new RoomExample();
        example.createCriteria().andBuildingIdEqualTo(id);
        roomMapper.deleteByExample(example);
        return result;
    }

    public int updateBuilding(Building building) {
        // 检查要修改的名称是否已存在
        if (isBuildingNameExistWithId(building.getName(), building.getId())) {
            return ERROR_CODE_BUILDING_NAME_EXIST;
        }
        // 检查要修改的产权证号是否已存在
        if (isBuildingPropertyCertNoExistWithId(building.getPropertyCertNo(), building.getId())) {
            return ERROR_CODE_BUILDING_PROPERTY_CERT_NO_EXIST;
        }
        return buildingMapper.updateByPrimaryKeySelective(building);
    }

    public List<Building> selectAllBuildings() {
        return buildingMapper.selectByExample(null);
    }

    public Building selectBuildingById(int id) {
        return buildingMapper.selectByPrimaryKey(id);
    }

    public List<Building> search(String keyword) {
        return buildingExtMapper.fullSelectByKeyword(keyword);
    }
}
