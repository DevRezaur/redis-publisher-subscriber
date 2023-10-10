package com.devrezaur.subscriberservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisSubscriberConfiguration {

    private final MessageListener messageListener;
    private final RedisConnectionFactory connectionFactory;

    public RedisSubscriberConfiguration(MessageListener messageListener, RedisConnectionFactory connectionFactory) {
        this.messageListener = messageListener;
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(ChannelTopic topic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListener, topic);
        return container;
    }
}
