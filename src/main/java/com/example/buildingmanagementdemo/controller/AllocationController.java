package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.model.AllocationExample;
import com.example.buildingmanagementdemo.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class AllocationController {
    Byte allocated = 0;
    Byte unallocated = 1;

    @Autowired
    AllocationService allocationService;

    /**
     * 添加房间的分配记录
     * @param roomId 房间id
     * @param allocatedTo 分配用户id
     * @return
     */
    @PostMapping("/allocation/add")
    public String addAllocation(@RequestParam(name = "roomId") Integer roomId,
                                @RequestParam(name = "userId") String allocatedTo) {
        Allocation allocation = new Allocation();
        allocation.setRoomId(roomId);
        allocation.setAllocatedTo(allocatedTo);
        allocation.setAllocationTime(System.currentTimeMillis());
        allocation.setStatus(allocated);
        allocationService.insertAllocation(allocation);
        return "test";
    }

    /**
     * 更新房间的分配记录
     * @param roomId 房间id
     * @param allocatedTo 分配用户id
     * @return
     */
    @PostMapping("/allocation/update")
    public String updateAllocation(@RequestParam(name = "roomId") Integer roomId,
            @RequestParam(name = "userId") String allocatedTo) {
        Allocation allocation = new Allocation();
        allocation.setAllocatedTo(allocatedTo);
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(roomId).andStatusEqualTo(allocated);
        allocationService.updateAllocation(allocation, allocationExample);
        return "test";
    }

    /**
     * 解除房间的分配
     * @param id
     * @return
     */
    @PostMapping("/allocation/remove")
    public String removeAllocation(@RequestParam(name = "id") int id) {
        allocationService.removeAllocationById(id);
        return "test";
    }

    /**
     * 查询房间的分配记录
     * @param roomId
     * @param model
     * @return
     */
    @RequestMapping("/allocation/list")
    public String allocationList(@RequestParam(name = "roomId") int roomId,
                                 Model model) {
        model.addAttribute("allocation", allocationService.getAllocationById(roomId));
        return "test";
    }


    /**
     * 查询房间的历史分配记录
     * @param roomId
     * @param model
     * @return
     */
    @RequestMapping("/allocation/history")
    public String allocationHistoryList(@RequestParam(name = "roomId") int roomId,
                                        Model model) {
        model.addAttribute("allocationHistory", allocationService.getAllocationHistoryById(roomId));
        return "test";
    }


}
