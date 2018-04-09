package com.hey.common.interceptor;

import com.hey.common.annotation.Access;
import com.hey.common.enums.CodeStatus;
import com.hey.common.result.BaseResult;
import com.hey.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by heer on 2018/3/30.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

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
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }
        if (access.authorities().length > 0) {
            // 如果权限配置不为空, 则取出配置值
            String[] authorities = access.authorities();
            Set<String> authSet = new HashSet<>();
            for (String authority : authorities) {
                // 将权限加入一个set集合中
                authSet.add(authority);
            }
            // 这里我为了方便是直接参数传入权限, 在实际操作中应该是从参数中获取用户Id
            // 到数据库权限表中查询用户拥有的权限集合, 与set集合中的权限进行对比完成权限校验
            String role = request.getParameter("role");
            if (role!=null && !role.equals("")) {
                if (authSet.contains(role)) {
                    // 校验通过返回true, 否则拦截请求
                    return true;
                }
            }
        }
        // 拦截之后应该返回公共结果, 这里没做处理
        response.setContentType("application/json;charset=utf-8");
        BaseResult result = new BaseResult();
        int code = CodeStatus.NO_PERMISSION.getCode();
        result.setCode(code);
        result.setMsg(CodeStatus.ERROR.getMsg(code));
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        return false;
    }
}
