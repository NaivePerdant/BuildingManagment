package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.mapper.AllocationHistoryMapper;
import com.example.buildingmanagementdemo.mapper.AllocationMapper;
import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.model.AllocationExample;
import com.example.buildingmanagementdemo.model.AllocationHistory;
import com.example.buildingmanagementdemo.model.AllocationHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AllocationService {
    private final Byte allocated = 0;
    private final Byte unallocated = 1;

    @Autowired
    private AllocationMapper allocationMapper;

    @Autowired
    private AllocationHistoryMapper allocationHistoryMapper;

    public int insertAllocation(Allocation allocation) {
        return allocationMapper.insert(allocation);
    }

    public void removeAllocationById(int id) {
        Allocation allocation = allocationMapper.selectByPrimaryKey(id);
        allocationMapper.deleteByPrimaryKey(id);
        AllocationHistory allocationHistory = new AllocationHistory();
        allocationHistory.setRoomId(allocation.getRoomId());
        allocationHistory.setAllocatedTo(allocation.getAllocatedTo());
        allocationHistory.setAllocationTime(allocation.getAllocationTime());
        allocationHistory.setDeallocationTime(System.currentTimeMillis());
        allocationHistoryMapper.insert(allocationHistory);
    }

    public int updateAllocation(Allocation allocation, AllocationExample allocationExample) {
        return allocationMapper.updateByExampleSelective(allocation, allocationExample);
    }

    public List<Allocation> getAllocationById(int id) {
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(id);
        return allocationMapper.selectByExample(allocationExample);
    }

    public List<AllocationHistory> getAllocationHistoryById(int id) {
        AllocationHistoryExample allocationHistoryExample = new AllocationHistoryExample();
        allocationHistoryExample.createCriteria().andRoomIdEqualTo(id);
        return allocationHistoryMapper.selectByExample(allocationHistoryExample);
    }

}
