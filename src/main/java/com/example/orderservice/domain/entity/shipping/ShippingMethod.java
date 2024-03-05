package com.example.orderservice.domain.entity.shipping;


import com.example.orderservice.domain.entity.manufacture.Manufacture;
import org.modelmapper.ModelMapper;


public class ShippingMethod {

    public Manufacture CopyObject(Manufacture manufacture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Manufacture.class);
    }
}