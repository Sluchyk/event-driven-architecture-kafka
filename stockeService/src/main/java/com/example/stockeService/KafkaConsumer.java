package com.example.stockeService;

import com.example.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private final OrderService orderService;

    public KafkaConsumer(OrderService orderService) {
        this.orderService = orderService;
    }


    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order consumer message -> %s",orderEvent.toString()));
        orderService.save(orderEvent);
    }
}
