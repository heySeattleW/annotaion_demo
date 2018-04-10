package com.hey.common.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heer on 2018/4/10.
 */
public class JwtToken {

    /**
     * 公用秘钥，保存在服务器端，客户端不会知道秘钥，也不会在网络间流传
     */
    public static final String SECRET = "hey";

    /**
     * 生成token
     * @return
     * @throws Exception
     */
    public static String createToken()throws Exception{
        //签发时间
        Date date = new Date();

        //过期时间30分钟
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expireDate = nowTime.getTime();

        Map map = new HashMap();
        map.put("typ","JWT");
        map.put("alg","HS256");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("name","hey")//声明，可以存储一些逻辑必要的但是不敏感的信息
                .withExpiresAt(expireDate)//设置过期时间大于签发时间
                .withIssuedAt(date)//设置签发时间
                .sign(Algorithm.HMAC256(SECRET));//加密
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String,Claim> verifyToken(String token)throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            //验证token
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("凭证已过期，请重新登录");
        }
        return jwt.getClaims();
    }
}
