package com.example.dzy.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dzy.Common.Constants;
import com.example.dzy.Common.Exception.UserException;
import com.example.dzy.Controller.Convert.AdminUserConvert;
import com.example.dzy.Controller.Convert.UserConvert;
import com.example.dzy.Controller.DTO.AdminUserDTO;
import com.example.dzy.Controller.DTO.UserDTO;
import com.example.dzy.Entity.AdminUser;
import com.example.dzy.Entity.User;
import com.example.dzy.Mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.dzy.Utils.tokenUtils.geneToken;

@Service
public class AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    public AdminUserDTO login(AdminUser adminUser){
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name" , adminUser.getUserName());
        queryWrapper.eq("pass_word" , adminUser.getPassWord());
        AdminUser one;
        try{
            one = adminUserMapper.selectOne(queryWrapper);
        } catch (Exception ex){
            throw new UserException(Constants.CODE_500,"系统出错");
        }if(one == null){
            throw new UserException(Constants.CODE_600,"用户名或密码错误");
        }
        AdminUserDTO adminUserDTo = AdminUserConvert.adminUerToDTO(one);
        adminUserDTo.setToken(geneToken(one.getUserName(),one.getPassWord()));
        return adminUserDTo;
    }
}
