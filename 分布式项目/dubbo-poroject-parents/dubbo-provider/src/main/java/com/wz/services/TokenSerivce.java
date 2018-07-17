package com.wz.services;

import com.wz.utils.JwtTokenInfo;
import com.wz.utils.UserTokenGenerate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @package: com.wz.services
 * @Author:
 * @Date: 2018/7/16 0016 下午 7:09
 */
@Component
public class TokenSerivce {
    @Value("${jwt.expire}")
    private int expireTime;

    public String generateToken(JwtTokenInfo jwtTokenInfo){
       return UserTokenGenerate.generateToken(jwtTokenInfo,expireTime);
    }

    public JwtTokenInfo getInfo(String token){
        return UserTokenGenerate.getTokenInfo(token);
    }
}
