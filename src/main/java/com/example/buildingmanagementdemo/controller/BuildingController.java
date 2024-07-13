package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.mapper.BuildingMapper;
import com.example.buildingmanagementdemo.mapper.RoomMapper;
import com.example.buildingmanagementdemo.model.Building;
import com.example.buildingmanagementdemo.model.RoomExample;
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
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 添加楼宇信息
     * @param name
     * @param campus
     * @param model
     * @return
     */
    @PostMapping("/building/add")
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
    @GetMapping("/building/list")
    public String getAllBuildings(Model model) {
        List<Building> allBuildings = buildingMapper.selectByExample(null);
        model.addAttribute("result", allBuildings);
        return "test";
    }

    /**
     * 更新指定ID的楼宇信息
     * @param id
     * @param name
     * @param campus
     * @param roomCount
     * @param model
     * @return
     */
    @PostMapping("/building/update")
    public String updateBuilding(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "campus") String campus,
                                 @RequestParam(name = "roomCount") int roomCount,
                                 Model model) {
        Building building = new Building();
        building.setId(id);
        building.setName(name);
        building.setCampus(campus);
        building.setRoomCount(roomCount);
        int result = buildingMapper.updateByPrimaryKeySelective(building);
        model.addAttribute("result", result);
        return "test";
    }

    /**
     * 删除楼宇信息
     * @param id
     * @return
     */
    @PostMapping("/building/remove")
    public String removeBuilding(@RequestParam(name = "id") int id) {
        buildingMapper.deleteByPrimaryKey(id);
        RoomExample example = new RoomExample();
        example.createCriteria().andBuildingIdEqualTo(id);
        roomMapper.deleteByExample(example);
        return "test";
    }

}
