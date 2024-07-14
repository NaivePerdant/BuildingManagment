package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.mapper.AllocationHistoryMapper;
import com.example.buildingmanagementdemo.mapper.AllocationMapper;
import com.example.buildingmanagementdemo.mapper.BuildingMapper;
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
    public static final int ERROR_CODE_BUILDING_NOT_EXIST = -1;
    private static final int ERROR_CODE_ROOM_NAME_EXIST = -2;
    private static final int ERROR_CODE_ROOM_NO_EXIST = -3;

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private AllocationMapper allocationMapper;
    @Autowired
    private AllocationHistoryMapper allocationHistoryMapper;
    @Autowired
    private BuildingMapper buildingMapper;

    public List<Room> getRoomListByBuildingId(Integer buildingId) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andBuildingIdEqualTo(buildingId);
        return roomMapper.selectByExample(roomExample);
    }

    public Room getRoomById(int roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    public int updateRoom(Room room) {
        if(buildingMapper.selectByPrimaryKey(room.getBuildingId()) == null) {
            return ERROR_CODE_BUILDING_NOT_EXIST;
        }
        if (isRoomNameExist(room.getName(), room.getId())) {
            return ERROR_CODE_ROOM_NAME_EXIST;
        }
        if (isRoomNoExist(room.getName(), room.getId())) {
            return ERROR_CODE_ROOM_NO_EXIST;
        }
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    private boolean isRoomNameExist(String roomName, int roomId) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andNameEqualTo(roomName).andIdNotEqualTo(roomId);
        return !roomMapper.selectByExample(roomExample).isEmpty();
    }

    private boolean isRoomNoExist(String roomName, int roomId) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andNameEqualTo(roomName).andIdNotEqualTo(roomId);
        return !roomMapper.selectByExample(roomExample).isEmpty();
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
        if(buildingMapper.selectByPrimaryKey(room.getBuildingId()) == null) {
            return ERROR_CODE_BUILDING_NOT_EXIST;
        }
        if (isRoomNameExist(room.getName())) {
            return ERROR_CODE_ROOM_NAME_EXIST;
        }
        if (isRoomNoExist(room.getRoomNo())) {
            return ERROR_CODE_ROOM_NO_EXIST;
        }
        return roomMapper.insertSelective(room);
    }

    private boolean isRoomNoExist(String roomNo) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andRoomNoEqualTo(roomNo);
        return !roomMapper.selectByExample(roomExample).isEmpty();
    }

    private boolean isRoomNameExist(String roomName) {
        RoomExample roomExample = new RoomExample();
        roomExample.createCriteria().andNameEqualTo(roomName);
        return !roomMapper.selectByExample(roomExample).isEmpty();
    }
}
