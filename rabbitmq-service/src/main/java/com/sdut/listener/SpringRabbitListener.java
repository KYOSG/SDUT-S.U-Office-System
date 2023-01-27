package com.sdut.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Projectname: Cloud
 * @Filename: SpringRabbitListener
 * @Author: SpringForest
 * @Data:2023/1/10 12:57
 * @Description:
 */

@Component
public class SpringRabbitListener {
    //@RabbitListener(queues = "simple.queue")
    //public void listenSimpleQueue(String msg) {
    //    System.out.println("接收到的消息：" + msg);
    //}

    @RabbitListener(queues = "fanout.queue1")
    public void listenWorkQueue1(String msg) {
        System.out.println("消费者1接收到的消息：" + msg);

    }

    @RabbitListener(queues = "fanout.queue2")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2接收到的消息：" + msg);
        Thread.sleep(20);
    }

    //Direct
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "direct.exchange", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg) {
        System.err.println("消费者接收到direct.queue1的消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "direct.exchange", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg) {
        System.err.println("消费者接收到direct.queue2的消息：" + msg);
    }

    //Topic
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = "china.news"
    ))
    public void listenTopicQueue1(String msg) {
        System.err.println("消费者接收到topic.queue1的消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenTopicQueue2(String msg) {
        System.err.println("消费者接收到topic.queue2的消息：" + msg);
    }

    //接收Map参数
    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String, Object> map) {
        System.out.println(map);
    }
}
