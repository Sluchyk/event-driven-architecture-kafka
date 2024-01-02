package com.example.orderService;

import com.example.basedomains.dto.Order;
import com.example.basedomains.dto.OrderEvent;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final KafkaProducer kafkaProducer;

    public OrderController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID());
        kafkaProducer.sendMessage(new OrderEvent("PENDING",
                "order status is in pending state",order));
        return ResponseEntity.ok("order :" +order+"placed successfully");
    }

}
