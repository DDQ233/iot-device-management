package app.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/27 16:37
 */
@Component
public class AdminVisitInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();
        // URL : 除了 login.html 与 register.html 可以公开访问，其他的 URL 都进行拦截
        if (url.indexOf("/admin/login.html") > 0 || url.indexOf("/admin/register.html") > 0) {
            return true;
        }
        // 获取 Session
        HttpSession httpSession = request.getSession();
        // 判断 Session 中是否有用户 ID 信息
        if(httpSession.getAttribute("ADMIN_ID")!=null){
            return true;
        } else {
            request.getRequestDispatcher("adminLogin.html").forward(request, response);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
