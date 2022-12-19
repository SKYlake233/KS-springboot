package com.example.dzy.Common.Exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private String code;

    public UserException(String code , String msg){
        super(msg);
        this.code = code;
    }
}
