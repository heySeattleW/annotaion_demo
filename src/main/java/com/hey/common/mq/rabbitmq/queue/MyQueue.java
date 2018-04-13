package com.hey.common.mq.rabbitmq.queue;

import org.springframework.amqp.core.Queue;

/**
 * Created by heer on 2018/4/13.
 */
public class MyQueue {

    public Queue queue(){
        return new Queue("hey");
    }
}
