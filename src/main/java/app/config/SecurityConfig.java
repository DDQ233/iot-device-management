package app.config;

import app.service.before.UserService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/27 20:10
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] loginUrlPermit = new String[]{
                "/",
                "/user",
                "/user/login",
                "/user/toLogin",
                "/user/login.html",
                "/admin/login",
                "/admin/toLogin",
                "/admin/login.html",
        };
        String[] registerUrlPermit = new String[]{
                "/user/register",
                "/user/toRegister",
                "/user/register.html",
                "/admin/register",
                "/admin/toRegister",
                "/admin/register.html"
        };
        String[] staticPermit = new String[]{
                "/css/**",
                "/fonts/**",
                "/images/**",
                "/js/**",
                "/lib/**"
        };

        http.authorizeRequests()
                .antMatchers(loginUrlPermit).permitAll()
                .antMatchers(registerUrlPermit).permitAll()
                .antMatchers(staticPermit).permitAll();
                // .anyRequest().authenticated();

        // http.formLogin()
        //         .loginPage("/user/toLogin").permitAll()
        //         .defaultSuccessUrl("/custom/list");
    }
}
