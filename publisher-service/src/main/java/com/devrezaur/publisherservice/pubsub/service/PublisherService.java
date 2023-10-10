package com.devrezaur.publisherservice.pubsub.service;

import com.devrezaur.publisherservice.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PublisherService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    public Long publish(OrderEvent orderEvent) {
        log.info("Sending message: {}", orderEvent);
        return redisTemplate.convertAndSend(channelTopic.getTopic(), orderEvent);
    }
}
