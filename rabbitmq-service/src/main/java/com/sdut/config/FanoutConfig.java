package com.sdut.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Projectname: Cloud
 * @Filename: FanoutConfig
 * @Author: SpringForest
 * @Data:2023/1/11 09:14
 * @Description:
 */

@Configuration
public class FanoutConfig {
    //声明Exchange交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("simple.exchange");
    }

    //声明第一个队列
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1");
    }

    //声明第二个队列
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2");
    }

    //绑定队列1和交换机
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    //如需绑定其他队列，同理
    //绑定队列1和交换机
    @Bean
    public Binding bindingQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    //Object
    @Bean
    public Queue objectQueue() {
        return new Queue("object.queue");
    }

   
}
