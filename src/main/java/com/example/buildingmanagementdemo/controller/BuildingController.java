package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.mapper.BuildingsMapper;
import com.example.buildingmanagementdemo.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuildingController {

    @Autowired
    private BuildingsMapper buildingsMapper;

    @GetMapping("/addBuilding")
    public String room(@RequestParam(name = "name") String name,
                       Model model) {
        Building building = new Building();
        building.setName(name);
        buildingsMapper.addBuilding(building);
        model.addAttribute("name", name);
        return "addBuilding";
    }
}
