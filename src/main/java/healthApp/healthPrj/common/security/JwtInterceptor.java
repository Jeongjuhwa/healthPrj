package healthApp.healthPrj.common.security;

import healthApp.healthPrj.common.security.annotation.Authenticated;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    private final JwtService jwtService;
    private final String COOKIE_KEY;

    public JwtInterceptor(JwtService jwtService, String cookie) {
        this.jwtService = jwtService;
        this.COOKIE_KEY = cookie;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 인증 target 이 아닌경우 pass
        if (!(handler instanceof HandlerMethod) || !isAuthenticationPresent((HandlerMethod) handler)) {
            return true;
        }

        String token = CookieFactory.getCookie(request, COOKIE_KEY)
                .map(Cookie::getValue)
                .orElseThrow(() -> new RuntimeException("토큰이 없습니다"));

        return validateToken(token);
    }

    private Boolean validateToken(String token) {
        return jwtService.isUsable(token, System.currentTimeMillis());
    }

    private boolean isAuthenticationPresent(HandlerMethod handler) {
        return handler.hasMethodAnnotation(Authenticated.class)
                || handler.getBeanType()
                .isAnnotationPresent(Authenticated.class);
    }
}
