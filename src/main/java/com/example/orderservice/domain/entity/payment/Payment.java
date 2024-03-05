package com.example.orderservice.domain.entity.payment;

import com.example.orderservice.domain.entity.manufacture.Manufacture;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long order_id;

    @OneToOne
    private PaymentMethod payment_method;

    @OneToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatus payment_status;

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }
}
