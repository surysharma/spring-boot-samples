package com.thebigscale.controller;

import com.google.common.flogger.FluentLogger;
import com.thebigscale.dto.OrderMessage;
import com.thebigscale.service.OrderService;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class OrderController {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/order",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderMessage> addClient(@Valid @RequestBody OrderMessage orderRequest) {
        assert orderRequest != null;
        val orderMessage = OrderMessage.builder()
                .creditCardNumber(orderRequest.getCreditCardNumber())
                .itemName(orderRequest.getItemName())
        .orderLocation(orderRequest.getOrderLocation())
        .orderNumber(orderRequest.getOrderNumber())
        .price(orderRequest.getPrice())
        .quantity(orderRequest.getQuantity())
          .oderDateTime(LocalDateTime.now())
                .build();
        logger.atInfo().log("ORDER_MESSAGE=> " + orderMessage.toString());
        orderService.process(orderMessage);
        return new ResponseEntity<>(orderMessage, HttpStatus.ACCEPTED);
    }
}
