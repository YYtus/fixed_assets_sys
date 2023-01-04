package com.thundersoft.fixed_assets_sys.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Duration;
import java.util.Date;

public final class JwtUtil {
    // 密钥
    private final static String SECRET_KEY="ThunderSoft";
    // JWT的过期时间
    private final static Duration exp = Duration.ofHours(20);


    // 构建凭证   根据用户名构建JWT字符串
    public static String generate(String username){
        Date expDate = new Date(
                System.currentTimeMillis()+exp.toMillis()
        );
        return Jwts.builder()
//                Claims:  Jwt  header  Claims  Signature
                .setExpiration(expDate)
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
    }

    public static Claims parse(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody();
        return claims;
    }
    // 解析凭证
}
