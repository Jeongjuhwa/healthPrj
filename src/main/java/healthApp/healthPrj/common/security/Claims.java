package healthApp.healthPrj.common.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Claims {
    private final Map<String, Object> claims = new HashMap<>();

    public void put(String key, Object value) {
        claims.put(key, value);
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return claims.entrySet();
    }
}
