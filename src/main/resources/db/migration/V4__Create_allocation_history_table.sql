-- 创建历史分配记录表 (allocation_history)
CREATE TABLE allocation_history (
                                    id INT PRIMARY KEY AUTO_INCREMENT,
                                    room_id INT,
                                    allocated_to VARCHAR(255),
                                    allocation_time DATETIME,
                                    deallocation_time DATETIME,
                                    notes VARCHAR(255)
);
