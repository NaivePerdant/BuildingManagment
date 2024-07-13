package com.example.buildingmanagementdemo.controller;

import com.example.buildingmanagementdemo.mapper.AllocationHistoryMapper;
import com.example.buildingmanagementdemo.mapper.AllocationMapper;
import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.model.AllocationExample;
import com.example.buildingmanagementdemo.model.AllocationHistory;
import com.example.buildingmanagementdemo.model.AllocationHistoryExample;
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
    private AllocationMapper allocationMapper;

    @Autowired
    private AllocationHistoryMapper allocationHistoryMapper;

    @PostMapping("/allocation/add")
    public String addAllocation(@RequestParam(name = "roomId") Integer roomId,
                                @RequestParam(name = "userId") String allocatedTo) {
        Allocation allocation = new Allocation();
        allocation.setRoomId(roomId);
        allocation.setAllocatedTo(allocatedTo);
        allocation.setAllocationTime(new Date());
        allocation.setStatus(allocated);
        allocationMapper.insert(allocation);
        return "test";
    }

    @PostMapping("/allocation/update")
    public String updateAllocation(@RequestParam(name = "roomId") Integer roomId,
            @RequestParam(name = "userId") String allocatedTo) {
        Allocation allocation = new Allocation();
        allocation.setAllocatedTo(allocatedTo);
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(roomId).andStatusEqualTo(allocated);
        allocationMapper.updateByExampleSelective(allocation, allocationExample);
        return "test";
    }

    @PostMapping("/allocation/remove")
    public String removeAllocation(@RequestParam(name = "id") int id) {
        Allocation allocation = allocationMapper.selectByPrimaryKey(id);
        allocationMapper.deleteByPrimaryKey(id);
        AllocationHistory allocationHistory = new AllocationHistory();
        allocationHistory.setRoomId(allocation.getRoomId());
        allocationHistory.setAllocatedTo(allocation.getAllocatedTo());
        allocationHistory.setAllocationTime(allocation.getAllocationTime());
        allocationHistory.setDeallocationTime(new Date());
        allocationHistoryMapper.insert(allocationHistory);
        return "test";
    }

    @RequestMapping("/allocation/list")
    public String allocationList(@RequestParam(name = "roomId") int roomId,
                                 Model model) {
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(roomId);
        List<Allocation> allocations = allocationMapper.selectByExample(allocationExample);
        model.addAttribute("allocation", allocations);
        return "test";
    }

    @RequestMapping("/allocation/history")
    public String allocationHistoryList(@RequestParam(name = "roomId") int roomId,
                                        Model model) {
        AllocationHistoryExample allocationHistoryExample = new AllocationHistoryExample();
        allocationHistoryExample.createCriteria().andRoomIdEqualTo(roomId);
        List<AllocationHistory> allocationHistories = allocationHistoryMapper.selectByExample(allocationHistoryExample);
        model.addAttribute("allocationHistory", allocationHistories);
        return "test";
    }


}
