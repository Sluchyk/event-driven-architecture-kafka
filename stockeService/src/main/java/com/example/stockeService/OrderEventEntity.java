package com.example.stockeService;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class OrderEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderEventId;
    private String message;
    private String statusOfOrder;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private OrderEntity order;

    public OrderEventEntity(
                            String message,
                            String statusOfOrder) {
        this.message = message;
        this.statusOfOrder = statusOfOrder;
    }

    public OrderEventEntity() {

    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Long getId() {
        return orderEventId;
    }

    public void setId(Long orderEventId) {
        this.orderEventId = orderEventId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusOfOrder() {
        return statusOfOrder;
    }

    public void setStatusOfOrder(String statusOfOrder) {
        this.statusOfOrder = statusOfOrder;
    }
}
