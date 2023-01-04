package com.thundersoft.fixed_assets_sys.advice;

import com.thundersoft.fixed_assets_sys.common.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


// 所有的restController都生效
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handleException(HttpServletRequest request, Exception ex){
        CommonResponse<String> response = new CommonResponse<>();
        response.setCode(500);
        response.setMessage("ERROR");
        response.setData(ex.getMessage());
        return response;
    }
}
