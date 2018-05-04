package com.hey.common.mq.rabbitmq.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by heer on 2018/4/13.
 */
@Component
public class MyQueue {

    @Bean
    public Queue queue(){
        return new Queue("hello",true,false,false);
    }
}
