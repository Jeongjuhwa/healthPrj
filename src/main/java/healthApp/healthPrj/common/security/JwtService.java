package healthApp.healthPrj.common.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import healthApp.healthPrj.common.exception.ErrorCode;
import healthApp.healthPrj.common.exception.HealthAppException;
import healthApp.healthPrj.domain.member.dto.MemberGymPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@Component
public class JwtService {

    private final static byte[] JWT_KEY_SALT = "didhddkajdajdgoqhk".getBytes(StandardCharsets.UTF_8);
    private final static byte[] JWT_KEY = "didhddlajdajd".getBytes(StandardCharsets.UTF_8);

    private Key getSecretKey(){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(JWT_KEY);
            md.update(JWT_KEY_SALT);
            return Keys.hmacShaKeyFor(md.digest());
        }catch (NoSuchAlgorithmException e){
            throw new HealthAppException(ErrorCode.JWT_ALGORITHM_NOT_FOUND);
        }
    }

    public String createToken(MemberGymPayload memberGymPayload, ZonedDateTime expirationDateTime){
        Payload payload = new Payload(memberGymPayload,expirationDateTime);
        return createToken(payload);

    }

    private String createToken(Payload payload){
        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setExpiration(payload.expirationDate())
                .signWith(getSecretKey());

        for(Map.Entry<String, Object> entry : payload.entrySetOfClaims()){
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        return jwtBuilder.compact();
    }
    public boolean isUsable(String token, long current) {
        return checkJwt(token, current);
    }

    public String parseClaim(String token){return parseJwt(token);}

    private boolean checkJwt(String token, long current){
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token);

        Date expiration = claims.getBody().getExpiration();
        return current <= expiration.getTime();
    }

    private String parseJwt(String token){
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token);

        try {
            return new ObjectMapper().writeValueAsString(claims.getBody());
        } catch (JsonProcessingException e) {
            throw new HealthAppException(ErrorCode.JSON_PROCESSING_ERROR);
        }
    }
}
