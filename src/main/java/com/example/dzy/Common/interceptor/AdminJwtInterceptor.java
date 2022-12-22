package com.example.dzy.Common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dzy.Common.Constants;
import com.example.dzy.Common.Exception.UserException;
import com.example.dzy.Entity.AdminUser;
import com.example.dzy.Entity.User;
import com.example.dzy.Mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminJwtInterceptor implements HandlerInterceptor {

    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.addHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        response.addHeader("Access-Control-Max-Age", "120");
        String token = request.getHeader("token");
        //执行认证
        if(StrUtil.isBlank(token)){
            throw new UserException(Constants.CODE_401,"未登录，请重新登录");
        }

        String userName;
        try{
            userName = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new UserException(Constants.CODE_401,"token验证失败");
        }

        //获得用户对象userQueryWrapper.eq("user_name" , user.getUserName())
        AdminUser user = adminUserMapper.selectOne(new QueryWrapper<AdminUser>().eq("user_name" , userName));

        if(user == null)
            throw new UserException(Constants.CODE_401,"用户不存在");

        //用户密码  最后验证
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassWord())).build();
        try{
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw  new UserException(Constants.CODE_401,"用户不存在");
        }
        return true;
    }

}
