package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.dto.Result;
import com.example.buildingmanagementdemo.model.Building;
import com.example.buildingmanagementdemo.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/building")
public class BuildingController {

    @Resource
    private BuildingService buildingService;

    @Operation(summary = "根据关键词搜索楼宇信息")
    @GetMapping("/search")
    public Result search(@RequestParam(value = "keyWords") String key) {
        return Result.success(buildingService.search(key));
    }

    @Operation(summary = "获取所有楼宇信息")
    @GetMapping("/list")
    public Result getAllBuildings() {
        return Result.success(buildingService.selectAllBuildings());
    }

    @Operation(summary = "根据id获取楼宇信息")
    @GetMapping("/select")
    public Result getBuilding(@RequestParam(name = "buildingId") int buildingId) {
        return Result.success(buildingService.selectBuildingById(buildingId));
    }

    @Operation(summary = "添加楼宇信息")
    @PostMapping("/add")
    public Result room(@RequestBody Building building) {
        return Result.success(buildingService.insertBuilding(building));
    }

    @Operation(summary = "更新楼宇信息")
    @PutMapping("/update")
    public Result updateBuilding(@RequestBody Building building) {
        if (buildingService.selectBuildingById(building.getId()) == null) {
            return Result.error("该楼宇不存在");
        }
        return Result.success(buildingService.updateBuilding(building));
    }

    @Operation(summary = "删除楼宇信息")
    @DeleteMapping("/remove")
    public Result removeBuilding(@RequestParam(name = "buildingId") int buildingId, Model model) {
        return Result.success(buildingService.removeBuilding(buildingId));
    }

}
