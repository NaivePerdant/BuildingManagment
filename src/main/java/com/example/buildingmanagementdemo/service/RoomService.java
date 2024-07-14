package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.mapper.AllocationHistoryMapper;
import com.example.buildingmanagementdemo.mapper.AllocationMapper;
import com.example.buildingmanagementdemo.mapper.RoomMapper;
import com.example.buildingmanagementdemo.model.AllocationExample;
import com.example.buildingmanagementdemo.model.AllocationHistoryExample;
import com.example.buildingmanagementdemo.model.Room;
import com.example.buildingmanagementdemo.model.RoomExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private AllocationMapper allocationMapper;
    @Autowired
    private AllocationHistoryMapper allocationHistoryMapper;

    public List<Room> getRoomListByBuildingId(Integer buildingId) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andBuildingIdEqualTo(buildingId);
        return roomMapper.selectByExample(roomExample);
    }

    public Room getRoomById(int roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    public int updateRoom(Room room) {
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    public int deleteRoom(int roomId) {
        AllocationExample allocationExample = new AllocationExample();
        allocationExample.createCriteria().andRoomIdEqualTo(roomId);
        allocationMapper.deleteByExample(allocationExample);
        AllocationHistoryExample allocationHistoryExample = new AllocationHistoryExample();
        allocationHistoryExample.createCriteria().andRoomIdEqualTo(roomId);
        allocationHistoryMapper.deleteByExample(allocationHistoryExample);
        return roomMapper.deleteByPrimaryKey(roomId);
    }

    public int addRoom(Room room) {
        return roomMapper.insertSelective(room);
    }
}
