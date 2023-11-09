package plugins;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Jwt {
    private final String SECRET = "token-vvtcp";

    /**
     * 生成token
     *
     * @return : token
     */
    public String generateToken() {
        Calendar instance = Calendar.getInstance();
        // 过期时间
        instance.add(Calendar.SECOND, 600);
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("time", "2023-10-11");
        Map<String, Object> claim = new HashMap<>();
        claim.put("name", "melikui");
        claim.put("sex", "boy");
        // 生成令牌
        String token = JWT.create()
                .withHeader(headers) // 第一部分 Header
                .withClaim("age", 20) // 第二部分 Payload
                .withClaim("info", claim)
                .withExpiresAt(instance.getTime()) // 设置过期时间
                .sign(Algorithm.HMAC256(this.SECRET)); // 第三部分 Signature，设置签名 保密 复杂
        // 输出令牌
        System.out.println(token);
        return token;
    }

    /**
     * 校验token
     */
    public void verifyToken(String token) {
        // 创建一个验证的对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(this.SECRET)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
        System.out.println("----" + verify.getHeader());
        System.out.println(verify.getClaim("age").asInt());
        System.out.println(verify.getClaim("info").asMap().get("name"));
        System.out.println("过期时间：" + verify.getExpiresAt());
    }
}
