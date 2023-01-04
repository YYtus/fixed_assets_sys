package com.thundersoft.fixed_assets_sys.advice;

import com.alibaba.fastjson.JSON;
import com.thundersoft.fixed_assets_sys.annotation.IgnoreResponseAdvice;
import com.thundersoft.fixed_assets_sys.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

// restController 处理器， 所有的restController都会按照该处理器处理响应结果
@RestControllerAdvice
@Slf4j
public class CommonResponseDataAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {
        // 如果当前方法
        if(methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        // 如果当前类上标记了 IgnoreResponseAdvice注解则不做任何处理
        if(methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        CommonResponse<Object> commonResponse = new CommonResponse<>(0,"");
        if(body == null){
            return commonResponse;
        }else if(body instanceof CommonResponse){
            commonResponse = (CommonResponse<Object>) body;
        }else{
            commonResponse.setData(body);
            commonResponse.setCode(200);
            commonResponse.setMessage("success");
        }
        if(StringHttpMessageConverter.class.isAssignableFrom(selectedConverterType)){
            log.info("converter: [{}]",selectedConverterType);
            return JSON.toJSONString(commonResponse);
        }
        return commonResponse;

    }
}
