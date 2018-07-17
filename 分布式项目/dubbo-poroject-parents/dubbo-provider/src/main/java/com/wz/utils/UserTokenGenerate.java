package com.wz.utils;

import io.jsonwebtoken.*;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * @package: com.wz.utils
 * @Author:
 * @Date: 2018/7/16 0016 下午 5:51
 */
public class UserTokenGenerate {

    // 生成签名算法key
    private static Key getKeyInstance(){
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        byte[] bytes=DatatypeConverter.parseBase64Binary("dubbo-user-provider");
         return  new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());
    }

// token-->自带信息/ 签名算法和key  过期时间
    public static String generateToken(JwtTokenInfo jwtTokenInfo,int expireTime){
       return Jwts.builder().claim(JwtConstants.JWT_USER_KEY_ID,jwtTokenInfo.getUid())
                .setExpiration(DateTime.now().plusHours(expireTime).toDate())
                .signWith(SignatureAlgorithm.HS256,UserTokenGenerate.getKeyInstance()).compact();
    }

    // /获得token中自带的信息
    public static JwtTokenInfo getTokenInfo(String token){
     Jws<Claims> claimsJws=Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(token);
     Claims claims=claimsJws.getBody();
     return  new JwtTokenInfo((claims.get(JwtConstants.JWT_USER_KEY_ID)).toString());

    }
}
