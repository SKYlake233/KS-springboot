package com.example.dzy.Controller;

import com.example.dzy.Common.Constants;
import com.example.dzy.Common.Result;
import com.example.dzy.Controller.DTO.AdminUserDTO;
import com.example.dzy.Controller.DTO.UserDTO;
import com.example.dzy.Entity.AdminUser;
import com.example.dzy.Entity.User;
import com.example.dzy.Service.AdminUserService;
import com.example.dzy.Utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    AdminUserService adminUserService;

    //用户的登录  返回token
    @PostMapping("/login")
    public Result login(@RequestBody AdminUser adminUser){
        String userName = adminUser.getUserName();
        String password = adminUser.getPassWord();
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        AdminUserDTO retAdminUser = adminUserService.login(adminUser);
        if(retAdminUser == null){
            return Result.error(Constants.CODE_500,"账号或密码错误");
        }
        return Result.success(retAdminUser);
    }
}
