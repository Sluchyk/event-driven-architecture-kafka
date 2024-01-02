package com.example.basedomains.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private UUID orderId;
    private String name;
    private String qty;
    private String price;
}
