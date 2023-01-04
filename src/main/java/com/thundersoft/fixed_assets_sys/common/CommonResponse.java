package com.thundersoft.fixed_assets_sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse <T> {
    private Integer code;  //状态码
    private String message; // 消息
    private T data; // 数据


    public CommonResponse(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
