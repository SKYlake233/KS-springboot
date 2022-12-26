package com.example.dzy.Utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class tokenUtils {
    /**/
    public static String geneToken(String userName , String sign){
        return JWT.create()
                .withAudience(userName)
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))
                .sign(Algorithm.HMAC256(sign));
    }
}
