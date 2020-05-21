package cn.bdqn.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 员工登录拦截器
 */

public class EmployeeLoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        System.out.println("拦截器！！！！！！！！！");
             //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
                 if (uri.indexOf("/login") >= 0) {
                        return true;
                 }
        //获取session
              HttpSession session = httpServletRequest.getSession();
                 Object object =  session.getAttribute("EMP");
               //判断session中是否有用户数据，如果有，则返回true，继续向下执行
                 if (object != null) {
                         return true;
                    }
                //不符合条件的给出提示信息，并转发到登录页面
                httpServletRequest.setAttribute("msg", "您还没有登录，请先登录！");
                httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, httpServletResponse);
                return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
