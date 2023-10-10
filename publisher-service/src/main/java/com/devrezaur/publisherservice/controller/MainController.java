package com.devrezaur.publisherservice.controller;

import com.devrezaur.publisherservice.model.OrderEvent;
import com.devrezaur.publisherservice.pubsub.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/publish")
    public String publish(@RequestBody OrderEvent orderEvent) {
        publisherService.publish(orderEvent);
        return "Success";
    }
}
