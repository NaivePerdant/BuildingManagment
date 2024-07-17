package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.dto.Result;
import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.service.AllocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/allocation")
public class AllocationController {

    @Resource
    AllocationService allocationService;

    @Operation(summary = "添加房间的分配记录")
    @PostMapping("/add")
    public Result addAllocation(@RequestBody Allocation allocation) {
        return Result.success(allocationService.insertAllocation(allocation));
    }

    @Operation(summary = "更新房间的分配记录")
    @PutMapping("/update")
    public Result updateAllocation(@RequestBody Allocation allocation) {
        return Result.success(allocationService.updateAllocation(allocation));
    }

    @Operation(summary = "解除房间的分配")
    @DeleteMapping("/remove")
    public Result removeAllocation(@RequestBody Allocation allocation) {
        allocationService.removeAllocationById(allocation.getId());
        return Result.success();
    }

    @Operation(summary = "查询房间的分配记录")
    @GetMapping("/list")
    public Result allocationList(@RequestParam int roomId) {
        return Result.success(allocationService.getAllocationByRoomId(roomId));
    }

    @Operation(summary = "查询房间的历史分配记录")
    @GetMapping("/history")
    public Result allocationHistoryList(@RequestParam int roomId) {
        return Result.success(allocationService.getAllocationHistoryByRoomId(roomId));
    }


}
