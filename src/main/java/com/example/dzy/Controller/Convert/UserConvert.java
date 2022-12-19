package com.example.dzy.Controller.Convert;

import com.example.dzy.Controller.DTO.UserDTO;
import com.example.dzy.Entity.User;

public class UserConvert {
    public static UserDTO UerToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setPassWord(user.getPassWord());
        userDTO.setNickName(user.getNickName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
