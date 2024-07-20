-- 创建房间信息表 (rooms)
CREATE TABLE rooms (
                       id INT PRIMARY KEY AUTO_INCREMENT COMMENT '房间ID，主键自增',
                       building_id INT NOT NULL COMMENT '所属楼宇ID',
                       floor INT DEFAULT 0 COMMENT '所属楼层',
                       room_no VARCHAR(50) DEFAULT '' COMMENT '房间号',
                       name VARCHAR(255) DEFAULT '' COMMENT '房间名称',
                       area DECIMAL(10,2) DEFAULT 0.0 COMMENT '建筑面积',
                       usable_area DECIMAL(10,2) DEFAULT 0.0 COMMENT '使用面积',
                       orientation VARCHAR(50) DEFAULT '' COMMENT '朝向',
                       department VARCHAR(255) DEFAULT '' COMMENT '所属部门',
                       purpose VARCHAR(255) DEFAULT '' COMMENT '用途',
                       bed_count INT DEFAULT 0 COMMENT '床位数',
                       thumbnail VARCHAR(255) DEFAULT '' COMMENT '缩略图',
                       structure_image VARCHAR(255) DEFAULT '' COMMENT '结构图',
                       notes VARCHAR(255) DEFAULT '' COMMENT '备注'
)DEFAULT CHARSET='UTF8' COMMENT '房间信息表';