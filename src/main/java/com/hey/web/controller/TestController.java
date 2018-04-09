package com.hey.web.controller;

import com.hey.common.annotation.Access;
import com.hey.common.enums.CodeStatus;
import com.hey.common.result.BaseResult;
import com.hey.web.entity.Hello;
import com.hey.web.service.HelloService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heer on 2018/3/29.
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "hello",produces = "application/json")
    @ApiOperation(value = "hello接口",httpMethod = "GET")
    public BaseResult hello(@Valid Hello hello, BindingResult bindingResult){
        BaseResult result = new BaseResult();
        if (bindingResult.hasErrors()){
            result.setCode(CodeStatus.PARAMETERS_ERROR.getCode());
            result.setMsg(CodeStatus.PARAMETERS_ERROR.getMsg());
            result.setData(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        result.setData(hello.toString());
        return result;
    }
}
