package com.example.shoppingbackend.interceptor;

import com.example.shoppingbackend.exception.CustomError;
import com.example.shoppingbackend.exception.CustomErrorType;
import com.example.shoppingbackend.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

@Slf4j
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws SignatureException {
        /** 地址过滤 */
        String uri = request.getRequestURI();
        log.debug("请求地址为：" + uri);
        if (uri.contains("/login") || uri.contains("swagger")) {
            return true;
        }
        /** Token 验证 JWTDemo*/
        String token = request.getHeader(jwtTokenUtil.getHeader());
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(jwtTokenUtil.getHeader());
        }
        if (StringUtils.isEmpty(token)) {
//            throw new SignatureException("token为空");
            throw new CustomError(CustomErrorType.NULLTOKEN_ERROR,"请求失败，token为空");
        }
        if (jwtTokenUtil.isTokenExpired(token)) {
//            throw new SignatureException(jwtTokenUtil.getHeader() + "失效，请重新登录。");
            throw new CustomError(CustomErrorType.OUTTIEMTOKEN_ERROR,"token过期，请重新登录");
        }
            /** 设置 identityId 用户身份ID */
            // request.setAttribute("identityId", jwtTokenUtil.getUsernameFromToken(token));
            return true;
        }


}