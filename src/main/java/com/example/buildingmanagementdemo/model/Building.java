package com.example.buildingmanagementdemo.model;

import java.sql.Timestamp;

public class Building {
    private int id;
    private String name;
    private String campus;
    private String propertyCertNo;
    private String roomCount;
    private String buildingArea;
    private String usableArea;
    private String floorsAboveGround;
    private String floorsBelowGround;
    private String location;
    private int buildYear;
    private Timestamp registerTime;
    private String department;
    private String purpose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPropertyCertNo() {
        return propertyCertNo;
    }

    public void setPropertyCertNo(String propertyCertNo) {
        this.propertyCertNo = propertyCertNo;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }

    public String getFloorsAboveGround() {
        return floorsAboveGround;
    }

    public void setFloorsAboveGround(String floorsAboveGround) {
        this.floorsAboveGround = floorsAboveGround;
    }

    public String getFloorsBelowGround() {
        return floorsBelowGround;
    }

    public void setFloorsBelowGround(String floorsBelowGround) {
        this.floorsBelowGround = floorsBelowGround;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
