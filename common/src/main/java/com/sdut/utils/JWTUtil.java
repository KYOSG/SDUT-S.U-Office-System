package com.sdut.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Projectname: Cloud
 * @Filename: JWTUtil
 * @Author: SpringForest
 * @Data:2023/1/8 20:45
 * @Description:
 */

public class JWTUtil {
    // 签名密钥
    private static final String SECRET = "SF";
    // token过期时间（秒）
    private static final int EXPIRATION = 7 * 24 * 60 * 60;

    /**
     * 生成token
     *
     * @param payload token携带的信息
     * @return token字符串
     */
    public static String getTokenByMap(Map<String, String> payload) {
        // 指定token过期时间(秒)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, EXPIRATION);

        JWTCreator.Builder builder = JWT.create();
        // 构建payload，填入信息
        payload.forEach(builder::withClaim);
        // 指定过期时间和签名算法
        return builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 解析token
     *
     * @param token token字符串
     * @return 解析后的token
     */
    public static DecodedJWT decode(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        return jwtVerifier.verify(token);
    }
}
