package healthApp.healthPrj.common.config;

import healthApp.healthPrj.common.security.JwtInterceptor;
import healthApp.healthPrj.common.security.JwtService;
import healthApp.healthPrj.common.security.JwtSessionArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JwtService jwtService;
    public final static String JWT_COOKIE_NAME = "health.prj";

    public WebConfig(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(jwtArgsResolver());
    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor(jwtService, JWT_COOKIE_NAME);
    }

    @Bean
    public JwtSessionArgumentResolver jwtArgsResolver() {
        return new JwtSessionArgumentResolver(jwtService, JWT_COOKIE_NAME);
    }
}
