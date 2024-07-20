-- 创建历史分配记录表 (allocation_history)
CREATE TABLE allocation_history (
                                    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '历史分配记录ID，主键自增',
                                    room_id INT NOT NULL COMMENT '房间ID',
                                    allocated_to VARCHAR(255) NOT NULL COMMENT '分配给谁',
                                    allocation_time BIGINT NOT NULL COMMENT '分配时间',
                                    deallocation_time BIGINT NOT NULL COMMENT '解除时间',
                                    notes VARCHAR(255) DEFAULT '' COMMENT '备注'
)DEFAULT CHARSET='UTF8' COMMENT='历史分配记录表';
