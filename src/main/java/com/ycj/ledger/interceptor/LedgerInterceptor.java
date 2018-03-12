package com.ycj.ledger.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.ycj.ledger.annotation.LedgerAuth;
import com.ycj.ledger.constant.Constant;
import com.ycj.ledger.result.BaseResult;
import com.ycj.ledger.utils.EncryptUtil;
import com.ycj.ledger.utils.Md5Util;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:21
 */
public class LedgerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        if (!(object instanceof HandlerMethod)) {
            return false;
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Methods", "POST,GET,PUT,DELETE,OPTIONS");
        LedgerAuth ledgerAuth = ((HandlerMethod) object).getMethodAnnotation(LedgerAuth.class);
        if (ledgerAuth == null || !ledgerAuth.isNeed()) {
            return true;
        }
        String headerAuth = httpServletRequest.getHeader("auth");
        if (StringUtils.isEmpty(headerAuth)) {
            httpServletResponse.getWriter().write(JSON.toJSONString(BaseResult.authorizationError()));
        } else {
            String auth = EncryptUtil.aesDecrypt(headerAuth, Constant.AUTH_KEY);
            if (Constant.AUTH.equals(auth)) {
                return true;
            } else {
                httpServletResponse.getWriter().write(JSON.toJSONString(BaseResult.authorizationError()));
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }


}
