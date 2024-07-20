package com.example.buildingmanagementdemo.service;

import com.example.buildingmanagementdemo.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRoomListByBuildingId(Integer buildingId);

    Room getRoomById(int roomId);

    int updateRoom(Room room);

    int deleteRoom(int roomId);

    int addRoom(Room room);
}
