package com.example.orderservice.domain.entity.payment;

import com.example.orderservice.domain.entity.common.BaseEntity;
import com.example.orderservice.domain.entity.manufacture.Manufacture;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;

@Table(name = "payment_status")
@Entity
public  class PaymentStatus extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "description")
    private String description;

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }
}

