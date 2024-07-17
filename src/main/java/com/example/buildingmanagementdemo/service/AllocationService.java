package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.model.Allocation;
import com.example.buildingmanagementdemo.model.AllocationHistory;

import java.util.List;

public interface AllocationService {
    int insertAllocation(Allocation allocation);

    void removeAllocationById(int id);

    int updateAllocation(Allocation allocation);

    List<Allocation> getAllocationByRoomId(int id);

    List<AllocationHistory> getAllocationHistoryByRoomId(int id);
}
