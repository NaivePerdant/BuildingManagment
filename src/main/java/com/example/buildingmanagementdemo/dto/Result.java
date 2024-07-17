package com.example.buildingmanagementdemo.dto;

import lombok.Data;

/**
 * 返回值的标准格式
 */
@Data
public class Result {
    /**
     * 状态码
     */
    private int code;
    /**
     * 消息提示
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }
}