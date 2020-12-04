package com.thebigscale.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thebigscale.utils.LocalDateTimeDeserializer;
import com.thebigscale.utils.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Data
@Builder
@Jacksonized
public class OrderMessage {
    private String creditCardNumber;
    private String itemName;
    private String orderLocation;
    private String orderNumber;
    private int price;
    private int quantity;

    @lombok.Getter
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime oderDateTime;

}
