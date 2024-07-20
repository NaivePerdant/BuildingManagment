package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.model.Room;
import com.example.buildingmanagementdemo.service.impl.BuildingServiceImpl;
import com.example.buildingmanagementdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private BuildingServiceImpl buildingService;

    /**
     * 根据楼宇ID查询楼宇内的所有房间信息
     * @param model
     * @return
     */
    @GetMapping("/room/list")
    public String roomListByBuildingId(@RequestParam(name = "buildingId") int buildingId,
                                       Model model){
        model.addAttribute("result", roomService.getRoomListByBuildingId(buildingId));
        return "test";
    }

    /**
     * 根据房间ID查询房间信息
     * @param roomId
     * @param model
     * @return
     */
    @GetMapping("/room/select")
    public String roomById(@RequestParam(name = "roomId") int roomId,
                           Model model){
        model.addAttribute("result", roomService.getRoomById(roomId));
        return "test";
    }

    /**
     * 添加房间信息
     * @param model
     * @return
     */
    @PostMapping("/room/add")
    public String addRoom(@RequestParam(name = "buildingId") int buildingId,
                          @RequestParam(name = "floor") int floor,
                          @RequestParam(name = "roomNo") String roomNo,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "area") double area,
                          @RequestParam(name = "usableArea") double usableArea,
                          @RequestParam(name = "orientation") String orientation,
                          @RequestParam(name = "department") String department,
                          @RequestParam(name = "purpose") String purpose,
                          @RequestParam(name = "bedCount") int bedCount,
                          @RequestParam(name = "thumbnail") String thumbnail,
                          @RequestParam(name = "notes") String notes,
                          Model model){
        Room room = new Room();
        room.setBuildingId(buildingId);
        room.setFloor(floor);
        room.setRoomNo(roomNo);
        room.setName(name);
        room.setArea(BigDecimal.valueOf(area));
        room.setUsableArea(BigDecimal.valueOf(usableArea));
        room.setOrientation(orientation);
        room.setDepartment(department);
        room.setPurpose(purpose);
        room.setBedCount(bedCount);
        room.setThumbnail(thumbnail);
        room.setNotes(notes);
        model.addAttribute("result", roomService.addRoom(room));
        return "test";
    }

    /**
     * 更新房间信息
     * @param roomId 房间ID
     * @param model
     * @return
     */
    @PutMapping("/room/update")
    public String updateRoom(@RequestParam(name = "roomId") int roomId,
                             @RequestParam(name = "floor") int floor,
                             @RequestParam(name = "roomNo") String roomNo,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "area") double area,
                             @RequestParam(name = "usableArea") double usableArea,
                             @RequestParam(name = "orientation") String orientation,
                             @RequestParam(name = "department") String department,
                             @RequestParam(name = "purpose") String purpose,
                             @RequestParam(name = "bedCount") int bedCount,
                             @RequestParam(name = "thumbnail") String thumbnail,
                             @RequestParam(name = "notes") String notes,
                             Model model){
        Room room = roomService.getRoomById(roomId);
        room.setFloor(floor);
        room.setRoomNo(roomNo);
        room.setName(name);
        room.setArea(BigDecimal.valueOf(area));
        room.setUsableArea(BigDecimal.valueOf(usableArea));
        room.setOrientation(orientation);
        room.setDepartment(department);
        room.setPurpose(purpose);
        room.setBedCount(bedCount);
        room.setThumbnail(thumbnail);
        room.setNotes(notes);
        model.addAttribute("result", roomService.updateRoom(room));
        return "test";
    }

    /**
     * 删除房间信息
     * @param roomId
     * @return
     */
    @DeleteMapping("/room/delete")
    public String deleteRoom(@RequestParam(name = "roomId") int roomId){
        roomService.deleteRoom(roomId);
        return "test";
    }

}
