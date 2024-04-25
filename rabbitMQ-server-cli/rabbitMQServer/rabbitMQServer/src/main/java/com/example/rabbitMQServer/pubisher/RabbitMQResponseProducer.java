package com.example.rabbitMQServer.pubisher;

import com.example.rabbitMQServer.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQResponseProducer {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQResponseProducer.class);
    @Value("${rabbitmq.response.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.response.routing.key}")
    private String routingKey;
    private RabbitTemplate rabbitTemplate;


    public RabbitMQResponseProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendResponse(User user){
       log.info(String.format("Sending response in json{}->%s",user.toString()));
    rabbitTemplate.convertAndSend(exchange,routingKey,user);
    }
}
