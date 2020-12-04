package com.thebigscale.service;

import com.google.common.flogger.FluentLogger;
import com.thebigscale.dto.OrderMessage;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Objects;

@Service
public class OrderService {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    KafkaTemplate<String, OrderMessage> kafkaTemplate;

    @Value("${orderTopic:t.commodity.order}")
    private String orderTopic;

    public OrderService(KafkaTemplate<String, OrderMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void process(OrderMessage orderMessage) {
        ListenableFuture<SendResult<String, OrderMessage>> futureSend = kafkaTemplate.send(orderTopic, orderMessage);
        futureSend.addCallback(
                result -> {
                    RecordMetadata recordMetadata = Objects.requireNonNull(result).getRecordMetadata();
                    logger.atInfo().log(recordMetadata.topic());
                },
                Throwable::printStackTrace);
    }
}
