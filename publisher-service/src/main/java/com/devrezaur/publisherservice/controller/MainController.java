package com.devrezaur.publisherservice.controller;

import com.devrezaur.publisherservice.model.OrderEvent;
import com.devrezaur.publisherservice.pubsub.publisher.EventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final EventPublisher eventPublisher;

    public MainController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody OrderEvent orderEvent) {
        eventPublisher.publishOrderEvent(orderEvent);
        return "Order event published successfully";
    }
}
