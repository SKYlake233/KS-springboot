package com.example.dzy.Controller;

import com.example.dzy.Common.Constants;
import com.example.dzy.Common.Result;
import com.example.dzy.Controller.DTO.UserDTO;
import com.example.dzy.Entity.User;
import com.example.dzy.Service.UserService;
import com.example.dzy.Utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //用户的注册
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        String userName = userDTO.getUserName();
        String password = userDTO.getPassWord();
        String nickName = userDTO.getNickName();
        String email = userDTO.getEmail();
        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(MD5Utils.code(password));
        user.setEmail(email);
        user.setNickName(nickName);
        if(userService.regis(user) == 0){
            return Result.error(Constants.CODE_500,"用户名或已注册");
        }
        //返回值200  不返回数据
        return Result.success();
    }

    //用户的登录  返回token
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
        String userName = userDTO.getUserName();
        String password = userDTO.getPassWord();

        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassWord(MD5Utils.code(password));

        UserDTO userRtnDTO;
        userRtnDTO = userService.login(user);
        //返回值200  不返回数据
        return Result.success(userRtnDTO);
    }

    @RequestMapping("/data")
    public Result getData(){
        return Result.success("hello");
    }

}
