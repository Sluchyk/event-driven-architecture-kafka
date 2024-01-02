package com.example.stockeService;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID orderUUIDId;
    private String name;
    private String qty;
    private String price;

    public OrderEntity(
            UUID UUIDId,
                       String name,
                       String qty,
                       String price) {
    }
    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "order")
    @JoinColumn
    private OrderEventEntity orderEvent;

    public OrderEventEntity getOrderEvent() {
        return orderEvent;
    }

    public void setOrderEvent(OrderEventEntity orderEvent) {
        this.orderEvent = orderEvent;
    }

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderUUIDId;
    }

    public void setOrderId(UUID orderUUIDId) {
        this.orderUUIDId = orderUUIDId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
