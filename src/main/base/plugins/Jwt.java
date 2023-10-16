package plugins;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;

public class Jwt {
    private final String SECRET = "token-mytoday";

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
        // 生成令牌
        String token = JWT.create()
                // 第一部分Header
                .withHeader(headers)
                // 第二部分 Payload
                .withClaim("userId", 20)
                .withClaim("userName", "Melikui")
                // 设置过期时间
                .withExpiresAt(instance.getTime())
                // 第三部分 Signature，设置签名 保密 复杂
                .sign(Algorithm.HMAC256(this.SECRET));
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
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getClaim("userName").asString());
        System.out.println("过期时间：" + verify.getExpiresAt());
    }
}
