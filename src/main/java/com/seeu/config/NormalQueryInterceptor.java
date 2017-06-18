package com.seeu.config;

import com.TurnBackUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by neo on 23/02/2017.
 */
public class NormalQueryInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    TurnBackUtil turnBackUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/json;charset=UTF-8");//这句话是解决乱码的
        request.setAttribute("userid","xa563278");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}
