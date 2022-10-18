package com.example.music.filters;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.music.common.AjaxResult;
import com.example.music.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static com.example.music.enums.CodeEnum.NOT_LOGIN;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/13 21:00
 * @Description
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }

        PrintWriter out = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String token = request.getHeader("AuthToken");
        if(ObjectUtils.isNull(token)) {
            try {
                out = response.getWriter();
                out.append(AjaxResult.error(NOT_LOGIN).toString());
                return false;
            } catch (Exception ex) {
                log.error("校验登录失败");
                return false;
            }
        }


        try {
            boolean b = JWTUtil.verifyToken(token);
        } catch (Exception ex) {
            out = response.getWriter();
            out.append(AjaxResult.error(NOT_LOGIN).toString());
            return false;
        }

        //
        return true;
    }
}
