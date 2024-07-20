-- 创建分配记录表 (allocations)
CREATE TABLE allocations (
                             id INT PRIMARY KEY AUTO_INCREMENT COMMENT '分配记录ID，主键自增',
                             room_id INT NOT NULL COMMENT '房间ID',
                             allocated_to VARCHAR(255) NOT NULL COMMENT '分配给谁',
                             allocation_time BIGINT NOT NULL COMMENT '分配时间',
                             status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：0-未使用，1-已使用',
                             notes VARCHAR(255) DEFAULT '' COMMENT '备注'
)DEFAULT CHARSET='UTF8' COMMENT '分配记录表';