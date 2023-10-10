package com.devrezaur.publisherservice.pubsub.publisher;

import com.devrezaur.publisherservice.model.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventPublisher {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic channelTopic;

    public EventPublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
        this.redisTemplate = redisTemplate;
        this.channelTopic = channelTopic;
    }

    public Long publishOrderEvent(OrderEvent orderEvent) {
        log.info("Publishing event: {}", orderEvent);
        return redisTemplate.convertAndSend(channelTopic.getTopic(), orderEvent);
    }
}
