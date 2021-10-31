package healthApp.healthPrj.common.security;


import healthApp.healthPrj.domain.member.dto.MemberGymPayload;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Payload {

    private final Claims claims = new Claims();

    private final ZonedDateTime expirationDateTime;

    public Payload(MemberGymPayload memberGymPayload, ZonedDateTime expirationDateTime) {
        addClaim("info", memberGymPayload);
        this.expirationDateTime = expirationDateTime;
    }

    public void addClaim(String key, Object value){
        claims.put(key,value);
    }

    public Set<Map.Entry<String, Object>> entrySetOfClaims() {
        return claims.entrySet();
    }

    public Date expirationDate() {
        return Date.from(this.expirationDateTime.toInstant());
    }
}
