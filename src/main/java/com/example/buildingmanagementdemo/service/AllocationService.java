package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.mapper.AllocationHistoryMapper;
import com.example.buildingmanagementdemo.mapper.AllocationMapper;
import com.example.buildingmanagementdemo.mapper.RoomMapper;
import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.model.AllocationExample;
import com.example.buildingmanagementdemo.model.AllocationHistory;
import com.example.buildingmanagementdemo.model.AllocationHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {
    private static final int ERROR_CODE_ALLOCATION_ALREADY_EXISTS = -1;
    private static final int ERROR_CODE_ROOM_NOT_FOUND = -2;
    private final Byte allocated = 0;
    private final Byte unallocated = 1;

    @Autowired
    private AllocationMapper allocationMapper;

    @Autowired
    private AllocationHistoryMapper allocationHistoryMapper;

    @Autowired
    private RoomMapper roomMapper;

    public int insertAllocation(Allocation allocation) {
        if (isAllocated(allocation.getRoomId())) {
            return ERROR_CODE_ALLOCATION_ALREADY_EXISTS;
        }
        if (roomMapper.selectByPrimaryKey(allocation.getRoomId()) == null) {
            return ERROR_CODE_ROOM_NOT_FOUND;
        }
        allocation.setStatus(allocated);
        return allocationMapper.insertSelective(allocation);
    }

    public boolean isAllocated(int roomId) {
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(roomId);
        List<Allocation> allocations = allocationMapper.selectByExample(allocationExample);
        return !allocations.isEmpty();
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

    public int updateAllocation(Allocation allocation) {
        Allocation originalAllocation = allocationMapper.selectByPrimaryKey(allocation.getId());
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andIdEqualTo(allocation.getId());
        int result = allocationMapper.updateByExampleSelective(allocation, allocationExample);
        if (result == 1) {
            AllocationHistory allocationHistory = new AllocationHistory();
            allocationHistory.setRoomId(originalAllocation.getRoomId());
            allocationHistory.setAllocatedTo(originalAllocation.getAllocatedTo());
            allocationHistory.setAllocationTime(originalAllocation.getAllocationTime());
            allocationHistory.setDeallocationTime(System.currentTimeMillis());
            allocationHistoryMapper.insert(allocationHistory);
        }
        return result;
    }

    public List<Allocation> getAllocationByRoomId(int id) {
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(id);
        return allocationMapper.selectByExample(allocationExample);
    }

    public List<AllocationHistory> getAllocationHistoryByRoomId(int id) {
        AllocationHistoryExample allocationHistoryExample = new AllocationHistoryExample();
        allocationHistoryExample.createCriteria().andRoomIdEqualTo(id);
        return allocationHistoryMapper.selectByExample(allocationHistoryExample);
    }

}
