package com.hey.common.handler;

import com.hey.common.enums.CodeStatus;
import com.hey.common.exception.ServiceException;
import com.hey.common.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heer on 2018/3/29.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    BaseResult handleException(Exception e){
        return exception(e);
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    BaseResult handleBusinessException(ServiceException e){
        return exception(e);
    }

    public static BaseResult exception(Exception e){

        LOGGER.error(e.getMessage(), e);
        BaseResult response = new BaseResult();
        response.setMsg(CodeStatus.ERROR.getMsg());
        response.setCode(CodeStatus.ERROR.getCode());
        response.setData(e.getMessage()==null?"java.lang.NullPointerException":e.getMessage());
        return response;
    }

}
