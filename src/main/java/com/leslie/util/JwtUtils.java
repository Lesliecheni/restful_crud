package com.leslie.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author lesliecheni
 * @version 1.0
 * @date 2020/7/18 0:15
 */
public class JwtUtils {
      //盐 加密用
        private  static String key="yingjie" ;
        //token过期时间
        private static long ttl=3600000;//一个小时

        public static String getKey() {
            return key;
        }

        public  void setKey(String key) {
            this.key = key;
        }

        public static long getTtl() {
            return ttl;
        }

        public void setTtl(long ttl) {
            this.ttl = ttl;
        }

        /**
         * 生成JWT
         *
         * @param id
         * @param subject
         * @return
         */
        public static String createJWT(String id, String subject, String roles) {
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            JwtBuilder builder = Jwts.builder().setId(id)
                    .setSubject(subject)
                    .setIssuedAt(now)
                    .signWith(SignatureAlgorithm.HS256, key).claim("roles", roles);
            if (ttl > 0) {
                builder.setExpiration( new Date( nowMillis + ttl));
            }
            return builder.compact();
        }

    public static void main(String[] args) {
            //生成token
        String token =createJWT("1","yingjie","user");
        System.out.println(token);
        // 解析
        Claims claims = parseJWT(token);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.get("roles"));
    }
        /**
         * 解析JWT
         * @param jwtStr
         * @return
         */
        public static Claims parseJWT(String jwtStr){
            return  Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwtStr)
                    .getBody();
        }

}
