package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.dto.Result;
import com.example.buildingmanagementdemo.model.Room;
import com.example.buildingmanagementdemo.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {

    @Resource
    private RoomService roomService;

    @Operation(summary = "根据楼宇ID查询楼宇内的所有房间信息")
    @GetMapping("/list")
    public Result roomListByBuildingId(@RequestParam(name = "buildingId") int buildingId) {
        return Result.success(roomService.getRoomListByBuildingId(buildingId));
    }

    @Operation(summary = "根据房间ID查询房间信息")
    @GetMapping("/select")
    public Result roomById(@RequestParam(name = "roomId") int roomId) {
        return Result.success(roomService.getRoomById(roomId));
    }

    @Operation(summary = "更新房间信息")
    @PostMapping("/add")
    public Result addRoom(@RequestBody Room room) {
        return Result.success(roomService.addRoom(room));
    }

    @Operation(summary = "更新房间信息")
    @PutMapping("/update")
    public Result updateRoom(@RequestBody Room room) {
        return Result.success(roomService.updateRoom(room));
    }

    @Operation(summary = "删除房间信息")
    @DeleteMapping("/delete")
    public Result deleteRoom(@RequestParam(name = "roomId") int roomId) {
        return Result.success(roomService.deleteRoom(roomId));
    }

}
