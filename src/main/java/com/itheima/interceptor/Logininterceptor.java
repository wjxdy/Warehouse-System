package com.itheima.interceptor;


import com.itheima.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Slf4j
@Component
public class Logininterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        log.info("请求被拦截，token的值为: {}", token);

        if (token==null||!JwtUtils.verify(token)){

            response.setStatus(401);

            return false;
        }
        return true;
    }
}
