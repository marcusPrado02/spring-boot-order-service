package com.example.orderservice.domain.entity.shipping;

import com.example.orderservice.domain.entity.common.BaseEntity;
import com.example.orderservice.domain.entity.manufacture.Manufacture;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.modelmapper.ModelMapper;

@Table(name = "shipping")
@Entity
public class Shipping extends BaseEntity {

    private String name;
    private String description;
    private String code;
    private String status;
    private String trackingNumber;
    @OneToOne
    private ShippingMethod shippingMethod;

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }

}
