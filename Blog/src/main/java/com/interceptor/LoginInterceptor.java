//package com.interceptor;
//
//import com.annotation.LoginAuthentication;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by vicriss on 2015/11/13.
// */
//public class LoginInterceptor implements HandlerInterceptor {
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//
////        LoginAuthentication loginAuthentication = ((HandlerMethod) o).getMethodAnnotation(LoginAuthentication.class);
//
//        if (o instanceof HandlerMethod) {
//            HandlerMethod method = (HandlerMethod) o;
//            LoginAuthentication loginAuthentication = method.getMethodAnnotation(LoginAuthentication.class);
//
//            if (loginAuthentication == null || loginAuthentication.validate() == false)
//                return true;
//            else {
//                if (httpServletRequest.getSession().getAttribute("userId") == null) {
//                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.html");
//                    return false;
//                } else
//                    return true;
//            }
//        }
//
//        return false;
//    }
//
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
