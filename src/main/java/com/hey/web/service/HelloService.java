package com.hey.web.service;

import org.springframework.stereotype.Service;

/**
 * Created by heer on 2018/3/29.
 */
@Service
public class HelloService {


    public String hello(){

        //抛异常
        //ServiceUtil.isTrue(false,"这里假装抛一下异常。。。");
        System.out.println("hello,world");
        return "hello,world";
    }

}
