package com.example.buildingmanagementdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.buildingmanagementdemo.mapper")
public class BuildingManagementDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuildingManagementDemoApplication.class, args);
    }
}
