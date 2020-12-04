package com.thebigscale.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thebigscale.dto.OrderMessage;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OrderSerializer implements Serializer<OrderMessage> {

    @Override
    public byte[] serialize(String topic, OrderMessage data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public byte[] serialize(String topic, Headers headers, OrderMessage data) {
        return serialize(topic, data);
    }
}
