package com.hey.common.aop;

import com.hey.common.enums.CodeStatus;
import com.hey.common.result.BaseResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by heer on 2018/3/29.
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class ControllerAop implements ThrowsAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Autowired
    private  HttpServletResponse response;

    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * @param jp
     */
    @Before("execution(* com.hey.web.controller.*.*(..))")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     */
    @AfterReturning(value="execution(* com.hey.web.controller.*.*(..))",returning="result")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
    }

    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     */
    @After("execution(* com.hey.web.controller.*.*(..))")
    public void afterMethod(JoinPoint jp){
        System.out.println("【后置通知】this is a afterMethod advice..."+jp.getSignature().getName());
    }

    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     * 现在注释，不用aop统一处理异常，改用ExceptionHandler
     */
    @AfterThrowing(value="execution(* com.hey.web.controller.*.*(..))",throwing="e")
    public void afterThrowingMethod(JoinPoint jp, Exception e){
        String methodName = jp.getSignature().getName();
        BaseResult<String> result = new BaseResult(e.getMessage());
        result.setMsg(CodeStatus.ERROR.getMsg());
        result.setCode(CodeStatus.ERROR.getCode());
        logger.error("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
        try {
            response.getWriter().write(result.toString());
        }catch (Exception e1){
            e1.printStackTrace();
        }

    }
}
