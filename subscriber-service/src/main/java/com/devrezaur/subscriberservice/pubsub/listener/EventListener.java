package com.devrezaur.subscriberservice.pubsub.listener;

import com.devrezaur.subscriberservice.model.OrderEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.IOException;

@Slf4j
@Configuration
public class EventListener implements MessageListener {

    private final ObjectMapper objectMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    public EventListener(ObjectMapper objectMapper, RedisTemplate<String, Object> redisTemplate) {
        this.objectMapper = objectMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(@NonNull Message message, @Nullable byte[] pattern) {
        try {
            log.info("New message received: {}", message);
            OrderEvent orderEvent = objectMapper.readValue(message.getBody(), OrderEvent.class);
            redisTemplate.opsForValue().set(orderEvent.getOrderId(), orderEvent);
        } catch (IOException e) {
            log.error("Error while parsing message!");
        }
    }
}
