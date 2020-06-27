package app.config;

import app.interceptor.AdminVisitInterceptor;
import app.interceptor.UserVisitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/27 16:21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AdminVisitInterceptor adminVisitInterceptor;
    @Resource
    private UserVisitInterceptor userVisitInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/").setViewName("index");
        // registry.addViewController("/").setViewName("userLogin");
        // registry.addViewController("/user").setViewName("userLogin");
        // registry.addViewController("login").setViewName("userLogin");
        // registry.addViewController("login.html").setViewName("userLogin");
        // registry.addViewController("toLogin").setViewName("userLogin");
        // registry.addViewController("/admin").setViewName("adminLogin");
        // registry.addViewController("/admin/login.html").setViewName("adminLogin");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = new String[]{
                "/",
                "/user",
                "/user/login",
                "/user/toLogin",
                "/user/login.html",
                "/user/register",
                "/user/toRegister",
                "/user/register.html",
                "/admin/login",
                "/admin/toLogin",
                "/admin/login.html",
                "/admin/register",
                "/admin/toRegister",
                "/admin/register.html",
                "/static/**"
        };
        registry.addInterceptor(userVisitInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludes);
        registry.addInterceptor(adminVisitInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludes);
    }
}
