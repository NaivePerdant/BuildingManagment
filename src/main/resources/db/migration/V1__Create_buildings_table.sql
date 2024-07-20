-- 创建数据库
CREATE DATABASE IF NOT EXISTS building_management DEFAULT CHARACTER SET UTF8;
-- 切换数据库
USE building_management;
-- 创建楼宇信息表 (buildings)
CREATE TABLE buildings (
                           id INT PRIMARY KEY AUTO_INCREMENT COMMENT '楼宇ID，主键自增',
                           name VARCHAR(255) DEFAULT '' COMMENT '楼宇名称',
                           campus VARCHAR(255) DEFAULT '' COMMENT '校区',
                           property_cert_no VARCHAR(255) NOT NULL COMMENT '房产证号',
                           room_count INT DEFAULT 0 COMMENT '房间数',
                           building_area DECIMAL(10,2) DEFAULT 0.0 COMMENT '建筑面积',
                           usable_area DECIMAL(10,2) DEFAULT 0.0 COMMENT '使用面积',
                           floors_above_ground INT DEFAULT 0 COMMENT '地上楼层数',
                           floors_below_ground INT DEFAULT 0 COMMENT '地下楼层数',
                           location VARCHAR(255) DEFAULT '' COMMENT '位置',
                           build_year SMALLINT DEFAULT 0 COMMENT '楼宇年月',
                           register_time BIGINT DEFAULT 0 COMMENT '登记时间',
                           department VARCHAR(255) DEFAULT '' COMMENT '所属部门',
                           purpose VARCHAR(255) DEFAULT '' COMMENT '用途'
)DEFAULT CHARSET='UTF8' COMMENT='楼宇信息表';