package com.example.dzy.Common.ExceptionHandler;

import com.example.dzy.Common.Exception.UserException;
import com.example.dzy.Common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserException.class)
    @ResponseBody
    public Result handle(UserException use){
        return Result.error(use.getCode(), use.getMessage());
    }
}
