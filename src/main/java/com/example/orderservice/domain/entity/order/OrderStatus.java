package com.example.orderservice.domain.entity.order;


import com.example.orderservice.domain.entity.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "order_status")
@Entity
public class OrderStatus extends BaseEntity {
    @Id
    @Column(name = "id")
    private Long Id;
    @Column(name = "code", nullable = false)
    private String name;
    @Column(name = "name", nullable = false)
    private String description;

}