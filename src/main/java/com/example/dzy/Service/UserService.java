package com.example.dzy.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dzy.Common.Constants;
import com.example.dzy.Common.Exception.UserException;
import com.example.dzy.Controller.Convert.UserConvert;
import com.example.dzy.Controller.DTO.UserDTO;
import com.example.dzy.Entity.User;
import com.example.dzy.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.dzy.Utils.tokenUtils.geneToken;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public int regis(User user) {
        return userMapper.insert(user);
    }

    public UserDTO login(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name" , user.getUserName());
        userQueryWrapper.eq("pass_word" , user.getPassWord());
        User one;
        try{
            one = userMapper.selectOne(userQueryWrapper);
        } catch (Exception ex){
            throw new UserException(Constants.CODE_500,"系统出错");
        }if(one == null){
            throw new UserException(Constants.CODE_600,"用户名或密码错误");
        }
        UserDTO userDTO = UserConvert.UerToDTO(user);
        userDTO.setToken(geneToken(user.getUserName(),user.getPassWord()));
        return userDTO;
    }
}
