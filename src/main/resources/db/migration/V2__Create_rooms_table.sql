-- 创建房间信息表 (rooms)
CREATE TABLE rooms (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       building_id INT,
                       floor INT,
                       room_no VARCHAR(50),
                       name VARCHAR(255),
                       area DECIMAL(10,2),
                       usable_area DECIMAL(10,2),
                       orientation VARCHAR(50),
                       department VARCHAR(255),
                       purpose VARCHAR(255),
                       bed_count INT,
                       thumbnail VARCHAR(255),
                       structure_image VARCHAR(255),
                       notes VARCHAR(255)
);