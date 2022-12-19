package com.example.dzy.Controller.DTO;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

@Data
public class AdminUserDTO {
    private long id;
    private String userName;
    @Ignore
    private String passWord;
    private String name;
    private String phone;
    private String address;
    private String token;
}
