package com.example.dzy.Controller.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    private long id;
    private String userName;
    private String passWord;
    private String nickName;
    private String email;
    public String token;
}
