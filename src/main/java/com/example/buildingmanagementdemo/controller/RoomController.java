package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.mapper.RoomMapper;
import com.example.buildingmanagementdemo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 查询所有房间信息
     * @param model
     * @return
     */
    @RequestMapping("/room/list")
    public String roomList(Model model){
        model.addAttribute("roomList", roomMapper.selectByExample(null));
        return "test";
    }

    /**
     * 更新房间信息
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/room/update")
    public String updateRoom(@RequestParam(name = "id") int id,
                             Model model){
        model.addAttribute("room", roomMapper.selectByPrimaryKey(id));
        return "test";
    }

    /**
     * 删除房间信息
     * @param id
     * @return
     */
    @PostMapping("/room/delete")
    public String deleteRoom(@RequestParam(name = "id") int id){
        roomMapper.deleteByPrimaryKey(id);
        return "test";
    }

    /**
     * 添加房间信息
     * @param model
     * @return
     */
    @PostMapping("/room/add")
    public String addRoom(Model model){
        model.addAttribute("room", new Room());
        return "test";
    }

}
