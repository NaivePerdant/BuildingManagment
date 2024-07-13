USE building_management;
-- 创建楼宇信息表 (buildings)
CREATE TABLE buildings (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(255) NOT NULL,
                           campus VARCHAR(255),
                           property_cert_no VARCHAR(255),
                           room_count INT,
                           building_area DECIMAL(10,2),
                           usable_area DECIMAL(10,2),
                           floors_above_ground INT,
                           floors_below_ground INT,
                           location VARCHAR(255),
                           build_year YEAR,
                           register_time DATETIME,
                           department VARCHAR(255),
                           purpose VARCHAR(255)
);