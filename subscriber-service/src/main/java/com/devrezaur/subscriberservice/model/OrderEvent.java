package com.devrezaur.subscriberservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderEvent {
    private String orderId;
    private String userId;
    private String productName;
    private Integer price;
    private Integer quantity;
}
