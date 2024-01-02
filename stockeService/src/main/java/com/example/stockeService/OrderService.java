package com.example.stockeService;

import com.example.basedomains.dto.OrderEvent;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderEventRepository orderEventRepository;
    private final OrderRepository orderRepository;

    public OrderService(OrderEventRepository orderEventRepository, OrderRepository orderRepository) {
        this.orderEventRepository = orderEventRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void save(OrderEvent orderEvent){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderEvent.getOrder().getOrderId());
        orderEntity.setName(orderEvent.getOrder().getName());
        orderEntity.setQty(orderEvent.getOrder().getQty());
        orderEntity.setPrice(orderEvent.getOrder().getPrice());
        orderRepository.save(orderEntity);
        OrderEventEntity orderEventEntity = new OrderEventEntity();
        orderEventEntity.setMessage(orderEvent.getMessage());
        orderEventEntity.setStatusOfOrder(orderEvent.getStatusOfOrder());
        orderEventEntity.setOrder(orderEntity);
        orderEventRepository.save(orderEventEntity);
    }
}
