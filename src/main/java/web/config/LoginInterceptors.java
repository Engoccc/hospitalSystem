package web.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("/userInfo")||requestURL.toString().contains("/photos") ) {

            Object user = request.getSession().getAttribute("user");

            if (null == user) {
                response.sendRedirect("/hospitalSystem/login");
                // request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                return false;
            } else {
                return true;
            }
        }
        else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
