package com.example.rabbitMQClient.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQResponseConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQResponseConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.response.queue.name}"})
    public void consume(String message){
        log.info(String.format("Received message response{}->%S",message));

    }
}
