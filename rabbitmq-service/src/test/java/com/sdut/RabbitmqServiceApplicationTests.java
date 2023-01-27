package com.sdut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqServiceApplicationTests {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /*
     * 发送消息
     * */
    @Test
    public void testSendMessageToSimpleQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "Hello Spring AMQP_____";
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            message += String.valueOf(i);
            rabbitTemplate.convertAndSend(queueName, message);

        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    @Test
    public void testSendFanoutExchange() {
        //交换机名称
        String exchangeName = "simple.exchange";
        //消息
        String message = "Hello MQ Exchange";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange() {
        //交换机名称
        String exchangeName = "direct.exchange";
        //消息
        String message = "Hello red";
        //RoutingKey
        String routingKey = "red";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

    @Test
    public void testTopicExchange() {
        //交换机名称
        String exchangeName = "topic.exchange";
        //消息
        String message = "Hello China news";
        //RoutingKey
        String routingKey = "china.news";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

    //发送对象类型的消息
    @Test
    public void testSendObject() {
        Map<String, Object> msg = new HashMap<>();
        msg.put("name", "test name");
        msg.put("age", 21);

        rabbitTemplate.convertAndSend("object.queue", msg);
    }

}
