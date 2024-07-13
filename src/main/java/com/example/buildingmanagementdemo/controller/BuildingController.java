package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.mapper.BuildingMapper;
import com.example.buildingmanagementdemo.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuildingController {

    @Autowired
    private BuildingMapper buildingMapper;

    /**
     * 添加楼宇信息
     * @param name
     * @param campus
     * @param model
     * @return
     */
    @PostMapping("/addBuilding")
    public String room(@RequestParam(name = "name") String name,
                       @RequestParam(name = "campus") String campus,
                       @RequestParam(name = "roomCount") int roomCount,
                       Model model) {
        Building building = new Building();
        building.setName(name);
        building.setCampus(campus);
        building.setRoomCount(roomCount);
        int result = buildingMapper.insert(building);
        model.addAttribute("result", result);
        return "test";
    }

    /**
     * 获取所有楼宇信息
     * @param model
     * @return
     */
    @GetMapping("/getAllBuildings")
    public String getAllBuildings(Model model) {
        List<Building> allBuildings = buildingMapper.selectByExample(null);
        model.addAttribute("result", allBuildings);
        return "test";
    }

    /**
     * 删除楼宇信息
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/removeBuilding")
    public String removeBuilding(@RequestParam(name = "id") int id,
                       Model model) {
        int result = buildingMapper.deleteByPrimaryKey(id);
        model.addAttribute("result", result);
        return "test";
    }

}
