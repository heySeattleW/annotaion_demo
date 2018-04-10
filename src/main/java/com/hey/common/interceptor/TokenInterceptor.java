package com.hey.common.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hey.common.annotation.Access;
import com.hey.common.annotation.Token;
import com.hey.common.enums.CodeStatus;
import com.hey.common.result.BaseResult;
import com.hey.common.security.JwtToken;
import com.hey.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by heer on 2018/4/10.
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HelloService helloService;

    // 在调用方法之前执行拦截
    @Override
    @ResponseBody
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 将handler强转为HandlerMethod, 前面已经证实这个handler就是HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 从方法处理器中获取出要调用的方法
        Method method = handlerMethod.getMethod();
        // 获取出方法上的Access注解
        Token access = method.getAnnotation(Token.class);
        if (access == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }
        String token = request.getParameter("token");
        if(token!=null&&!token.equals("")){
            //校验token
            Map<String,Claim> map = JwtToken.verifyToken(token);
            System.out.println(map.toString());
            //没抛异常就表示通过
            return true;
        }else {
            // 拦截之后应该返回公共结果
            response.setContentType("application/json;charset=utf-8");
            BaseResult result = new BaseResult();
            int code = CodeStatus.TOKEN_EXPIRE.getCode();
            result.setCode(code);
            result.setMsg(CodeStatus.ERROR.getMsg(code));
            response.getWriter().write(result.toString());
            response.getWriter().flush();
            return false;
        }
    }
}
