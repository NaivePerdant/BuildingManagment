package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.model.Building;
import com.example.buildingmanagementdemo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class BuildingController {

    @Autowired
    private BuildingService buildingService;


    /**
     * 根据关键词搜索楼宇信息
     * @param key 搜索关键词，可以是楼宇名字也可以是楼宇房产证号
     * @param model 用于返回数据
     * @return  路由地址
     */
    @GetMapping("/building/search")
    public String search(@RequestParam(value = "key") String key,
            Model model) {
        model.addAttribute("result", buildingService.search(key));
        return "test";
    }

    /**
     * 添加楼宇信息
     *
     * @param name              楼宇名称
     * @param campus            所在校区
     * @param roomCount         房间数量
     * @param propertyCertNo    产权证号
     * @param buildingArea      建筑面积
     * @param usableArea        使用面积
     * @param floorsAboveGround 地上层数
     * @param floorsBelowGround 地下层数
     * @param location          位置
     * @param buildYear         建成年份
     * @param department        所属部门
     * @param purpose           用途
     * @param model             用于返回数据
     * @return 路由地址
     */
    @PostMapping("/building/add")
    public String room(@RequestParam(name = "name") String name,
                       @RequestParam(name = "campus") String campus,
                       @RequestParam(name = "roomCount") int roomCount,
                       @RequestParam(name = "propertyCertNo") String propertyCertNo,
                       @RequestParam(name = "buildingArea") double buildingArea,
                       @RequestParam(name = "usableArea") double usableArea,
                       @RequestParam(name = "floorsAboveGround") int floorsAboveGround,
                       @RequestParam(name = "floorsBelowGround") int floorsBelowGround,
                       @RequestParam(name = "location") String location,
                       @RequestParam(name = "buildYear") Short buildYear,
                       @RequestParam(name = "department") String department,
                       @RequestParam(name = "purpose") String purpose,
                       Model model) {
        Building building = new Building();
        building.setName(name);
        building.setCampus(campus);
        building.setPropertyCertNo(propertyCertNo);
        building.setRoomCount(roomCount);
        building.setBuildingArea(BigDecimal.valueOf(buildingArea));
        building.setUsableArea(BigDecimal.valueOf(usableArea));
        building.setFloorsAboveGround(floorsAboveGround);
        building.setFloorsBelowGround(floorsBelowGround);
        building.setLocation(location);
        building.setBuildYear(buildYear);
        building.setRegisterTime(System.currentTimeMillis());
        building.setDepartment(department);
        building.setPurpose(purpose);
        model.addAttribute("result", buildingService.insertBuilding(building));
        return "test";
    }

    /**
     * 获取所有楼宇信息
     *
     * @param model 用于返回数据
     * @return 路由地址
     */
    @GetMapping("/building/list")
    public String getAllBuildings(Model model) {
        model.addAttribute("result", buildingService.selectAllBuildings());
        return "test";
    }

    /**
     * 更新楼宇信息
     *
     * @param id                楼宇id
     * @param name              楼宇名称
     * @param campus            所在校区
     * @param roomCount         房间数量
     * @param propertyCertNo    产权证号
     * @param buildingArea      建筑面积
     * @param usableArea        使用面积
     * @param floorsAboveGround 地上层数
     * @param floorsBelowGround 地下层数
     * @param location          位置
     * @param buildYear         建成年份
     * @param department        所属部门
     * @param purpose           用途
     * @param model             用于返回数据
     * @return 路由地址
     */
    @PostMapping("/building/update")
    public String updateBuilding(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "campus") String campus,
                                 @RequestParam(name = "roomCount") int roomCount,
                                 @RequestParam(name = "propertyCertNo") String propertyCertNo,
                                 @RequestParam(name = "buildingArea") double buildingArea,
                                 @RequestParam(name = "usableArea") double usableArea,
                                 @RequestParam(name = "floorsAboveGround") int floorsAboveGround,
                                 @RequestParam(name = "floorsBelowGround") int floorsBelowGround,
                                 @RequestParam(name = "location") String location,
                                 @RequestParam(name = "buildYear") Short buildYear,
                                 @RequestParam(name = "department") String department,
                                 @RequestParam(name = "purpose") String purpose,
                                 Model model) {
        Building building = new Building();
        building.setId(id);
        building.setName(name);
        building.setCampus(campus);
        building.setPropertyCertNo(propertyCertNo);
        building.setRoomCount(roomCount);
        building.setBuildingArea(BigDecimal.valueOf(buildingArea));
        building.setUsableArea(BigDecimal.valueOf(usableArea));
        building.setFloorsAboveGround(floorsAboveGround);
        building.setFloorsBelowGround(floorsBelowGround);
        building.setLocation(location);
        building.setBuildYear(buildYear);
        // 注册时间实际是修改时间
        building.setRegisterTime(System.currentTimeMillis());
        building.setDepartment(department);
        building.setPurpose(purpose);
        model.addAttribute("result", buildingService.updateBuilding(building));
        return "test";
    }

    /**
     * 删除楼宇信息
     *
     * @param id 楼宇id
     * @return 路由地址
     */
    @PostMapping("/building/remove")
    public String removeBuilding(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("result", buildingService.removeBuilding(id));
        return "test";
    }

}
