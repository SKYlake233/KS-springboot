package com.example.dzy.Controller.Convert;

import com.example.dzy.Controller.DTO.AdminUserDTO;
import com.example.dzy.Controller.DTO.UserDTO;
import com.example.dzy.Entity.AdminUser;
import com.example.dzy.Entity.User;

public class AdminUserConvert {
    public static AdminUserDTO adminUerToDTO(AdminUser adminUser){
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        adminUserDTO.setId(adminUser.getId());
        adminUserDTO.setUserName(adminUser.getUserName());
        adminUserDTO.setPassWord(adminUser.getPassWord());
        adminUserDTO.setPhone(adminUser.getPhone());
        adminUserDTO.setAddress(adminUser.getAddress());
        adminUserDTO.setName(adminUser.getName());
        return adminUserDTO;
    }
}
