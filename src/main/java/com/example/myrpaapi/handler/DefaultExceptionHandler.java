package com.example.myrpaapi.handler;

import com.example.myrpaapi.constant.ResultCode;
import com.example.myrpaapi.constant.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultJson<?> handleDefaultException(Exception e) {
        log.error("", e);
        return ResultJson.failure(ResultCode.BAD_REQUEST, e.getMessage());
    }
}
