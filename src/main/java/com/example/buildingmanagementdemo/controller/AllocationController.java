package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.model.AllocationExample;
import com.example.buildingmanagementdemo.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    /**
     * 添加房间的分配记录
     *
     * @param roomId      房间id
     * @param allocatedTo 分配用户id
     * @return
     */
    @PostMapping("/allocation/add")
    public String addAllocation(@RequestParam(name = "roomId") int roomId,
                                @RequestParam(name = "userId") String allocatedTo,
                                Model model) {
        Allocation allocation = new Allocation();
        allocation.setRoomId(roomId);
        allocation.setAllocatedTo(allocatedTo);
        allocation.setAllocationTime(System.currentTimeMillis());
        model.addAttribute("result", allocationService.insertAllocation(allocation));
        return "test";
    }

    /**
     * 更新房间的分配记录
     *
     * @param allocatedTo 分配用户id
     * @return
     */
    @PutMapping("/allocation/update")
    public String updateAllocation(@RequestParam(name = "id") int id,
                                   @RequestParam(name = "userId") String allocatedTo,
                                   Model model) {
        Allocation allocation = new Allocation();
        allocation.setId(id);
        allocation.setAllocatedTo(allocatedTo);
        model.addAttribute("result", allocationService.updateAllocation(allocation));
        return "test";
    }

    /**
     * 解除房间的分配
     *
     * @param id
     * @return
     */
    @DeleteMapping("/allocation/remove")
    public String removeAllocation(@RequestParam(name = "id") int id,
                                   Model model) {
        allocationService.removeAllocationById(id);
        return "test";
    }

    /**
     * 查询房间的分配记录
     *
     * @param roomId
     * @param model
     * @return
     */
    @GetMapping("/allocation/list")
    public String allocationList(@RequestParam(name = "roomId") int roomId,
                                 Model model) {
        model.addAttribute("result", allocationService.getAllocationByRoomId(roomId));
        return "test";
    }


    /**
     * 查询房间的历史分配记录
     *
     * @param roomId
     * @param model
     * @return
     */
    @GetMapping("/allocation/history")
    public String allocationHistoryList(@RequestParam(name = "roomId") int roomId,
                                        Model model) {
        model.addAttribute("result", allocationService.getAllocationHistoryByRoomId(roomId));
        return "test";
    }


}
