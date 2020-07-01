package app.config;

import app.interceptor.AdminVisitInterceptor;
import app.interceptor.UserVisitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/28 01:54
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AdminVisitInterceptor adminVisitInterceptor;
    @Resource
    private UserVisitInterceptor userVisitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] staticExclude = new String[]{
                "/static/**",
                "/static/**/**",
                "/static/**/**/**",
                "/static/**/**/**/**",
                "/css/**",
                "/fonts/**",
                "/images/**",
                "/js/**",
                "/lib/**",
                "/admin/**",
                "/before/**",
                "/common/**"
        };
        String[] adminExclude = new String[]{
                "/",
                "/admin",
                "/admin/login",
                "/admin/toLogin",
                "/admin/login.html"
        };
        String[] userExclude = new String[]{
                "/",
                "/user",
                "/user/login",
                "/user/toLogin",
                "/user/login.html"
                // "/api/data/**",
                // "/api/data/**/**"
        };

        registry.addInterceptor(adminVisitInterceptor)
                .addPathPatterns("/admin/**")
                .addPathPatterns("/device/**")
                .excludePathPatterns(staticExclude)
                .excludePathPatterns(adminExclude);
        registry.addInterceptor(userVisitInterceptor)
                .addPathPatterns("/user/**")
                .addPathPatterns("/custom/**")
                .excludePathPatterns(staticExclude)
                .excludePathPatterns(userExclude);
    }
}
